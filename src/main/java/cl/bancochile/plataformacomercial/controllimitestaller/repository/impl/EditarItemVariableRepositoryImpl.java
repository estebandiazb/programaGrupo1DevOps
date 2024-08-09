package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EditarItemVariableRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_EDIT_ITEM_VARIABLE;

@Repository
@CallSp(nombre = "SP_UPDATE_ITEM_VARIABLE")
public class EditarItemVariableRepositoryImpl extends SimpleSPGenericDao implements EditarItemVariableRepository {

    @Override
    public void ejecutar(ItemVariable variable) throws PlataformaBaseException {
        try {
            ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_ITEM_VARIABLE", variable.getId())
                    .addValue("IN_VALOR", variable.getValor()));
        } catch (SimpleDaoException e) {
            throw new TallerException(MSG_ERROR_EDIT_ITEM_VARIABLE, e);
        }
    }
}
