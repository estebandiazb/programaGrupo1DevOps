package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarTipoLimiteRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@CallSp(nombre = "SP_DEL_LIM_VERS")
public class EliminarTipoLimiteRepositoryImpl extends SimpleSPGenericDao
    implements EliminarTipoLimiteRepository {

    @Override
    public void ejecutar(long id) throws PlataformaBaseException {
        try{
            ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_LIM_VER", id));
        }catch(SimpleDaoException ex){
            throw  new TallerException(MsgErrorEnum.MSG_ERROR_ELIMINAR_LIMITE, ex);
        }
    }
}
