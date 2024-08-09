package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariableLimite;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ActualizarItemVariablesTipoLimiteRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@CallSp(nombre = "SP_UPDATE_VARIABLE_ITEM_TL")
public class ActualizarItemVariablesTipoLimiteRepositoryImpl extends SimpleSPGenericDao
        implements ActualizarItemVariablesTipoLimiteRepository {

    @Override
    public void ejecutar(ItemVariableLimite itemVariableLimite) throws PlataformaBaseException {
        try {
            ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_ITEM_VARIABLE_TL", itemVariableLimite.getId())
                    .addValue("IN_ID_VARIABLE_ITEM", itemVariableLimite.getIdVariableItem())
                    .addValue("IN_SELECCIONADO", itemVariableLimite.isSeleccionado())
                    .addValue("IN_VALOR", itemVariableLimite.getValor()));
        } catch (SimpleDaoException ex) {
            String mensajeError = "Error al actualizar item variable.";
            throw new PlataformaBaseException("RollBack actualizar item variable", ex, mensajeError);
        }
    }
}
