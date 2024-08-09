package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ActualizaEstadoFamiliaSubtipoRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@CallSp(nombre = "SP_ACTUALIZA_FAMILIA_SUBTIPO")
public class ActualizaEstadoFamiliaSubtipoRepositoryImpl extends SimpleSPGenericDao
        implements ActualizaEstadoFamiliaSubtipoRepository {
    @Override
    public void ejecutar(long idFamiliaSubtipo, EstadoTipoLimiteEnum estado) throws PlataformaBaseException{
        try {
            ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_FAMILIA_SUBTIPO", idFamiliaSubtipo)
                    .addValue("IN_ESTADO", estado.getId()));
        } catch (SimpleDaoException ex) {
            String mensajeError = "error al actualizar familia subtipo.";
            throw new PlataformaBaseException("rollBack crear actualizar familia subtipo", ex, mensajeError);
        }
    }

}
