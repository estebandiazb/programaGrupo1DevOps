package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarAtributoTipoLimiteRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@CallSp(nombre = "SP_DEL_ATRIBUTO_TIPO_LIMITE")
public class EliminarAtributoTipoLimiteRepositoryImpl extends SimpleSPGenericDao
        implements EliminarAtributoTipoLimiteRepository {

    @Override
    public void ejecutar(Long idTipoLimite, String codigoAtributo) throws PlataformaBaseException {
        try {
            ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_TIPO_LIMITE", idTipoLimite)
                    .addValue("IN_COD_ATRIBUTO", codigoAtributo)
            );
        } catch (SimpleDaoException ex) {
            throw new TallerException(MsgErrorEnum.MSG_ERROR_DEL_FAMLIM, ex);
        }
    }
}
