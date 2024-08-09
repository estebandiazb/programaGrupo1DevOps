package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerVersionActivaTipoLimiteRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapNumberToLong;

@Repository
@CallSp(nombre = "SP_GET_LIM_VERS")
public class ObtenerVersionActivaTipoLimitePorIdRepositoryImpl extends SimpleSPGenericDao
        implements ObtenerVersionActivaTipoLimiteRepository {

    @Override
    public long ejecutar(long idVersion){
        Map<String, Object> resultSet=
                ejecutar(new MapSqlParameterSource()
                        .addValue("IN_ID_VERSION_TIPO_LIMITE", idVersion));
        return mapNumberToLong(resultSet, "OUT_ID_VERSION_ACTIVA");
    }
}
