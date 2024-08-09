package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerFamiliaLimitePorIdRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.FamiliaLimite;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@CallSp(nombre = "SP_GET_FAMILIA_LIMITE_BY_ID")
public class ObtenerFamiliaLimitePorIdRepositoryImpl extends SimpleSPGenericDao
        implements ObtenerFamiliaLimitePorIdRepository {

    @Override
    public FamiliaLimite ejecutar(long idFamiliaLimite) throws PlataformaBaseException {
        try {
            Map<String, Object> salida = ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_FAMILIA_LIMITE", idFamiliaLimite));
            return customMapper(salida);
        } catch (SimpleDaoException ex) {
            String mensajeError = "error al obtener familia de limite.";
            throw new PlataformaBaseException("rollBack obtener familia de limite", ex, mensajeError);
        }
    }

    @SuppressWarnings("unchecked")
    private static FamiliaLimite customMapper(Map<String, Object> salida) {
        return new FamiliaLimite.Builder()
                .id(MapperUtils.mapNumberToLong(salida, "OUT_ID_FAMILIA_LIMITE"))
                .estado(EstadoTipoLimiteEnum.getById(MapperUtils.mapNumberToInt(salida, "OUT_ESTADO_FAMILIA")))
                .nombre(MapperUtils.mapToString(salida, "OUT_NOMBRE"))
                .fechaActualizacion(MapperUtils.mapToString(salida, "OUT_FECHA_ACTUALIZACION"))
                .build();
    }

}
