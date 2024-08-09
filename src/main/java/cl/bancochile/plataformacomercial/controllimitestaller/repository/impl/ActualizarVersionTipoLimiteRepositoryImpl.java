package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimiteFull;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ActualizarVersionTipoLimiteRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@CallSp(nombre = "SP_UPDATE_TIPO_LIMITE_VERSION")
public class ActualizarVersionTipoLimiteRepositoryImpl extends SimpleSPGenericDao
        implements ActualizarVersionTipoLimiteRepository {

    @Override
    public void ejecutar(TipoLimiteFull versionTipoLimite) throws PlataformaBaseException {
        try {
            ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_VERSION_TIPO_LIMITE", versionTipoLimite.getId())
                    .addValue("IN_NOMBRE", versionTipoLimite.getNombre())
                    .addValue("IN_COMENTARIO", versionTipoLimite.getComentarios())
                    .addValue("IN_USUARIO", versionTipoLimite.getUsuarioModificacion()));
        } catch (SimpleDaoException ex) {
            String mensajeError = "error al modificar tipo limite version.";
            throw new PlataformaBaseException("rollBack update tipo limite version", ex, mensajeError);
        }
    }
}
