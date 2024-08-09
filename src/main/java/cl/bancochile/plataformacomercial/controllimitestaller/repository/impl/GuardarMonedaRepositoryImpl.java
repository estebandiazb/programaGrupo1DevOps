package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.MonedaBanco;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.GuardarMonedaRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_SET_MONEDA;

@Repository
@CallSp(nombre = "SP_SET_MONEDA_BCO")
public class GuardarMonedaRepositoryImpl extends SimpleSPGenericDao
        implements GuardarMonedaRepository {

    @Override
    public void ejecutar(MonedaBanco monedaBanco) throws PlataformaBaseException {
        try {
            Map<String, Object> resultSet = ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_MONEDA", monedaBanco.getId())
                    .addValue("IN_CODIGO", monedaBanco.getCodigo())
                    .addValue("IN_CODIGO_BANCO", monedaBanco.getCodigoBanco())
                    .addValue("IN_NOMBRE", monedaBanco.getNombre())
                    .addValue("IN_DESCRIPCION", monedaBanco.getDescripcion())
                    .addValue("IN_SIMBOLO", monedaBanco.getSimbolo())
                    .addValue("IN_USUARIO_CREACION", monedaBanco.getUsuarioCreacion())
                    .addValue("IN_USUARIO_MODIFICACION", monedaBanco.getUsuarioModificacion())
            );
            monedaBanco.setId(MapperUtils.mapNumberToLong(resultSet, "OUT_ID_MONEDA"));
            monedaBanco.setFechaCreacion(MapperUtils.mapToString(resultSet, "OUT_FECHA_CREACION"));
            monedaBanco.setFechaModificacion(MapperUtils.mapToString(resultSet, "OUT_FECHA_MODIFICACION"));
        } catch (SimpleDaoException ex) {
            throw new TallerException(MSG_ERROR_SET_MONEDA, ex);
        }
    }
}
