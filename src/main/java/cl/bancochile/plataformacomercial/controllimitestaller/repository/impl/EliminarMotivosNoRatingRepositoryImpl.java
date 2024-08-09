package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarMotivoNoRatingRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@CallSp(nombre = "SP_DEL_MOTIVOS_NO_RATING")
public class EliminarMotivosNoRatingRepositoryImpl extends SimpleSPGenericDao
implements EliminarMotivoNoRatingRepository  {
    @Override
    public void ejecutar(Long idMotivoNoRating) throws PlataformaBaseException {
        try {
            ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_MOTIVO_NO_RATING", idMotivoNoRating)
            );
        } catch (SimpleDaoException ex) {
            throw new TallerException(MsgErrorEnum.MSG_ERROR_ELIMINAR_MOTIVO_NO_RATING, ex);
        }
    }
}
