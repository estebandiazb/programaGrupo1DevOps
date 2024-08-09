package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.AgregarItemVariablesTipoLimiteVersionRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@CallSp(nombre = "SP_INS_VARIABLE_ITEM_TL")
public class AgregarItemVariablesTipoLimiteVersionRepositoryImpl extends SimpleSPGenericDao
        implements AgregarItemVariablesTipoLimiteVersionRepository {
    @Override
    public void ejecutar(long idVariableTipoLimite, ItemVariable itemVariable) throws PlataformaBaseException {
        try {

            ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_VARIABLE_TIPO_LIMITE", idVariableTipoLimite)
                    .addValue("IN_ID_VARIABLE_ITEM", itemVariable.getId())
                    .addValue("IN_SELECCIONADO", itemVariable.isSeleccionado() ? 1: 0)
                    .addValue("IN_VALOR", itemVariable.getValor())
            );

        } catch (SimpleDaoException ex) {
            throw new TallerException(MsgErrorEnum.MSG_ERROR_CREAR_TIPO_LIMITE_VERSION, ex);
        }
    }
}
