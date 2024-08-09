package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoConfiguration;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Variable;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerFamiliaSubtipoPorIdRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper.ItemVariableFamiliaRowMapper;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper.ItemVariableRowMapper;
import cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@CallSp(nombre = "SP_GET_FAMILIA_SUBTIPO_BY_ID")
public class ObtenerFamiliaSubtipoPorIdRepositoryImpl extends SimpleSPGenericDao
        implements ObtenerFamiliaSubtipoPorIdRepository {

    @Override
    public Variable ejecutar(long idFamiliaSubtipo) throws PlataformaBaseException {
        try {
            Map<String, Object> salida =ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_FAMILIA_SUBTIPO", idFamiliaSubtipo));
            return customMapper(salida, idFamiliaSubtipo);
        } catch (SimpleDaoException ex) {
            String mensajeError = "error al obtener familia de subtipo.";
            throw new PlataformaBaseException("rollBack obtener familia de subtipo", ex, mensajeError);
        }
    }

    @SuppressWarnings("unchecked")
    private static Variable customMapper(Map<String, Object> salida, long idFamiliaSubtipo) {
        return new Variable.Builder()
                .nombre(MapperUtils.mapToString(salida, "OUT_NOMBRE_FAMILIA_SUBTIPO"))
                .id(idFamiliaSubtipo)
                .items(((List<ItemVariable>) salida.get("OUT_SUBTIPOS")))
                .build();
    }

    @Autowired
    @Override
    public void setSimpleDaoConfiguration(
            @Qualifier("defaultSimpleDaoConfiguration") SimpleDaoConfiguration simpleDaoConfiguration) {
        try {
            super.setSimpleDaoConfiguration(simpleDaoConfiguration);
            super.getSimpleJdbcCall().returningResultSet("OUT_SUBTIPOS"
                    , ItemVariableFamiliaRowMapper.class.newInstance());
        } catch (Exception e) { // NOSONAR
            throw new IllegalArgumentException("SimpleDaoConfiguration no valida");
        }
    }
}
