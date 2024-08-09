package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.MotivoNoRating;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ActualizarMotivoNoRatingRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_ACTUALIZAR_MOTIVO_NO_RATING;

@Repository
@CallSp(nombre = "SP_UPD_MOTIVO_NO_RATING")
public class ActualizarMotivoNoRatingRepositoryImpl extends SimpleSPGenericDao
        implements ActualizarMotivoNoRatingRepository {

    @Override
    public void ejecutar(MotivoNoRating motivoNoRating) throws PlataformaBaseException {
        ejecutar(motivoNoRating, null, null);
    }

    @Override

    public long ejecutar(MotivoNoRating motivoNoRating, String nombreUsuario, String usuario)
            throws PlataformaBaseException {
        try {
            Map<String, Object> salida;
            salida = ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID", motivoNoRating.getId())
                    .addValue("IN_ORDEN", motivoNoRating.getOrden())
                    .addValue("IN_DESCRIPCION", motivoNoRating.getDescripcion())
                    .addValue("IN_USUARIO_CREADOR", usuario)
                    .addValue("IN_NOMBRE_USUARIO", nombreUsuario)
            );
            return MapperUtils.mapNumberToLong(salida, "OUT_ID");
        } catch (SimpleDaoException ex) {
            throw new TallerException(MSG_ERROR_ACTUALIZAR_MOTIVO_NO_RATING.getMensaje(), ex);
        }
    }
}
