package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ReasignarLimiteRequest;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ReasignarFamiliaLimiteRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@CallSp(nombre = "SP_REASIGNAR_TIPO_LIMITE")
public class ReasignarFamiliaLimiteRepositoryImpl extends SimpleSPGenericDao
        implements ReasignarFamiliaLimiteRepository {

    @Override
    public void ejecutar(ReasignarLimiteRequest reasignarLimite) throws PlataformaBaseException {
        try {
            ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_FAMILIA_LIMITE", reasignarLimite.getIdFamiliaLimite())
                    .addValue("IN_ID_TIPO_LIMITE", reasignarLimite.getIdTipoLimite()));
        } catch (SimpleDaoException ex) {
            String mensajeError = "error al reasignar tipo de limite.";
            throw new PlataformaBaseException("rollBack reasignar tipo de limite", ex, mensajeError);
        }
    }

}
