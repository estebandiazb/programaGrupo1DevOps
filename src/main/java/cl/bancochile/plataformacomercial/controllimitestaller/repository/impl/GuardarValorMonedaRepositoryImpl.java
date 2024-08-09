package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ValorMonedaBanco;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.GuardarValorMonedaRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_UPD_VALOR_MONEDA;
import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapNumberToLong;
import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapToString;

@Repository
@CallSp(nombre = "SP_SET_VALOR_MONEDA_BCO")
public class GuardarValorMonedaRepositoryImpl extends SimpleSPGenericDao
        implements GuardarValorMonedaRepository {

    @Override
    public void ejecutar(ValorMonedaBanco valorMonedaBanco) throws PlataformaBaseException {
        try {
            Map<String, Object> resultSet = ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_VALOR", valorMonedaBanco.getId())
                    .addValue("IN_ID_MONEDA", valorMonedaBanco.getIdMoneda())
                    .addValue("IN_FECHA", valorMonedaBanco.getFecha())
                    .addValue("IN_USUARIO_CREACION", valorMonedaBanco.getUsuarioCreacion())
                    .addValue("IN_USUARIO_MODIFICACION", valorMonedaBanco.getUsuarioModificacion())
                    .addValue("IN_PARIDAD_REUTERS", valorMonedaBanco.getParidadReuters())
                    .addValue("IN_PARIDAD_BANCO_CENTRAL", valorMonedaBanco.getParidadBancoCentral())
                    .addValue("IN_VALOR_OBSERVADO", valorMonedaBanco.getValorObservado())
                    .addValue("IN_MOTIVO_MODIFICACION", valorMonedaBanco.getMotivoModificacion())
                    .addValue("IN_ORIGEN_DATA", valorMonedaBanco.getOrigenData())
            );

            valorMonedaBanco.setId(mapNumberToLong(resultSet, "OUT_ID_VALOR"));
            valorMonedaBanco.setFechaCreacion(mapToString(resultSet, "OUT_FECHA_CREACION"));
            valorMonedaBanco.setFechaModificacion(mapToString(resultSet, "OUT_FECHA_MODIFICACION"));

        } catch (SimpleDaoException ex) {
            throw new TallerException(MSG_ERROR_UPD_VALOR_MONEDA, ex);
        }
    }
}
