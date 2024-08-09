package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.MotivoNoRating;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.AgregarMotivoNoRatingRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@CallSp(nombre = "SP_INS_MOTIVO_NO_RATING")
public class AgregarMotivoNoRatingRepositoryImpl extends SimpleSPGenericDao
        implements AgregarMotivoNoRatingRepository {
    @Override
    public long ejecutar(MotivoNoRating motivoNoRating, PerfilUser usuario) throws PlataformaBaseException {
        try {
            Map<String, Object> salida = ejecutar(new MapSqlParameterSource()
                    .addValue("IN_DESCRIPCION", motivoNoRating.getDescripcion())
                    .addValue("IN_NOMBRE_USUARIO", usuario.getNombre())
                    .addValue("IN_USUARIO_CREADOR", usuario.getUsuario())
            );
            return MapperUtils.mapNumberToLong(salida, "OUT_ID");
        } catch (SimpleDaoException ex) {
            throw new TallerException(MsgErrorEnum.MSG_ERROR_CREAR_MOTIVO_NO_RATING, ex);
        }
    }
}
