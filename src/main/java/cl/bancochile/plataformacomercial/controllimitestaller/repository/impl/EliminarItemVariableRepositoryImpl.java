package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarItemVariableRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@CallSp(nombre = "SP_DEL_ITEM_VARIABLE")
public class EliminarItemVariableRepositoryImpl extends SimpleSPGenericDao implements EliminarItemVariableRepository {

    @Override
    public void ejecutar(long idItemVariable) throws PlataformaBaseException {
        try {
            ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_ITEM_VARIABLE", idItemVariable));
        } catch (SimpleDaoException ex) {
            String mensajeError = "error al eliminar item variable.";
            throw new PlataformaBaseException("rollBack eliminar item variable", ex, mensajeError);
        }
    }
}
