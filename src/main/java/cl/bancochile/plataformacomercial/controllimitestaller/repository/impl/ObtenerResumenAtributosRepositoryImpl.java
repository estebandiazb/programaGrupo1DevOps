package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ResumenAtributos;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerResumenAtributosRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapNumberToLong;

@Repository
@CallSp(nombre = "SP_GET_RESUMEN_ATRIBUTOS")
public class ObtenerResumenAtributosRepositoryImpl extends SimpleSPGenericDao
        implements ObtenerResumenAtributosRepository {

    @Override
    public ResumenAtributos ejecutar(long idTipoLimiteVersion) throws PlataformaBaseException {
        Map<String, Object> resultSet = ejecutar(new MapSqlParameterSource()
                .addValue("IN_ID_TIPO_LIMITE_VERSION", idTipoLimiteVersion)
        );
        return new ResumenAtributos.Builder()
                .normativos(mapNumberToLong(resultSet, "OUT_NORMATIVOS"))
                .basicos(mapNumberToLong(resultSet, "OUT_BASICOS"))
                .avanzados(mapNumberToLong(resultSet, "OUT_AVANZADOS"))
                .sinCategoria(mapNumberToLong(resultSet,"OUT_SIN_CATEGORIA"))
                .build();
    }
}
