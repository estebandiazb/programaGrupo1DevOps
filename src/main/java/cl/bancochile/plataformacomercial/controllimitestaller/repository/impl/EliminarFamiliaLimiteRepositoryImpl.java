package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarFamiliaLimiteRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@CallSp(nombre = "SP_DEL_FAMILIA_LIMITE")
public class EliminarFamiliaLimiteRepositoryImpl extends SimpleSPGenericDao
        implements EliminarFamiliaLimiteRepository {
    @Override
    public void ejecutar(long idFamilia, String usuarioActualizacion) throws PlataformaBaseException {
        try {
            ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_FAMILIA", idFamilia)
                    .addValue("IN_USUARIO_ACTUALIZACION", usuarioActualizacion)
            );
        } catch (SimpleDaoException ex) {
            throw new TallerException(MsgErrorEnum.MSG_ERROR_DEL_FAMLIM, ex);
        }
    }
}
