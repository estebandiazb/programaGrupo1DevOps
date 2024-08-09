package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.MonedaBanco;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerMonedaRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapNumberToInt;
import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapNumberToLong;
import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapToString;

@Repository
@CallSp(nombre = "SP_GET_MONEDA_BCO")
public class ObtenerMonedaRepositoryImpl extends SimpleSPGenericDao
        implements ObtenerMonedaRepository {

    @Override
    public MonedaBanco ejecutar(long idMoneda) throws PlataformaBaseException {
        Map<String, Object> resultSet = ejecutar(new MapSqlParameterSource()
                .addValue("IN_ID_MONEDA", idMoneda)
        );
        return new MonedaBanco.Builder()
                .id(mapNumberToLong(resultSet, "OUT_ID_MONEDA"))
                .codigo(mapToString(resultSet, "OUT_CODIGO"))
                .codigoBanco(mapNumberToLong(resultSet, "OUT_CODIGO_BANCO"))
                .nombre(mapToString(resultSet, "OUT_NOMBRE"))
                .descripcion(mapToString(resultSet, "OUT_DESCRIPCION"))
                .simbolo(mapToString(resultSet, "OUT_SIMBOLO"))
                .fechaCreacion(mapToString(resultSet, "OUT_FECHA_CREACION"))
                .fechaModificacion(mapToString(resultSet, "OUT_FECHA_MODIFICACION"))
                .usuarioCreacion(mapToString(resultSet, "OUT_USUARIO_CREACION"))
                .usuarioModificacion(mapToString(resultSet, "OUT_USUARIO_MODIFICACION"))
                .estado(EstadoTipoLimiteEnum.getById(mapNumberToInt(resultSet, "OUT_ESTADO_MONEDA")))
                .valor(null)
                .build();
    }
}
