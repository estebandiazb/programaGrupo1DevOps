package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ValorMonedaBanco;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerValorMonedaRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapNumberToBigDecimal;
import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapNumberToLong;
import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapToString;

@Repository
@CallSp(nombre = "SP_GET_VALOR_MONEDA_BCO")
public class ObtenerValorMonedaRepositoryImpl extends SimpleSPGenericDao
        implements ObtenerValorMonedaRepository {
    @Override
    public ValorMonedaBanco ejecutar(long idMoneda) {
        return outMapper(
                ejecutar(inMapper(idMoneda, null))
        );
    }

    @Override
    public ValorMonedaBanco ejecutar(String codigo) {
        return outMapper(
                ejecutar(inMapper(0, codigo))
        );
    }

    private static SqlParameterSource inMapper(long idMoneda, String codigo) {
        return new MapSqlParameterSource()
                .addValue("IN_ID_MONEDA", idMoneda)
                .addValue("IN_CODIGO", codigo)
                ;
    }

    private static ValorMonedaBanco outMapper(Map<String, Object> resultSet) {
        return new ValorMonedaBanco.Builder()
                .id(mapNumberToLong(resultSet, "OUT_ID_VALOR"))
                .idMoneda(mapNumberToLong(resultSet, "OUT_ID_MONEDA"))
                .fecha(mapToString(resultSet, "OUT_FECHA"))
                .fechaCreacion(mapToString(resultSet, "OUT_FECHA_CREACION"))
                .fechaModificacion(mapToString(resultSet, "OUT_FECHA_MODIFICACION"))
                .usuarioCreacion(mapToString(resultSet, "OUT_USUARIO_CREACION"))
                .usuarioModificacion(mapToString(resultSet, "OUT_USUARIO_MODIFICACION"))
                .valorObservado(mapNumberToBigDecimal(resultSet, "OUT_VALOR_OBSERVADO"))
                .paridadReuters(mapNumberToBigDecimal(resultSet, "OUT_PARIDAD_REUTERS"))
                .paridadBancoCentral(mapNumberToBigDecimal(resultSet, "OUT_PARIDAD_BANCO_CENTRAL"))
                .motivoModificacion(mapToString(resultSet, "OUT_MOTIVO_MODIFICACION"))
                .origenData(mapToString(resultSet, "OUT_ORIGEN_DATA"))
                .build();
    }
}
