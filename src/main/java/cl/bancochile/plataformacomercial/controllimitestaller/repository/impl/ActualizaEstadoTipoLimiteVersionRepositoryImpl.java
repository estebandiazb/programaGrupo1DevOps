package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ActualizaEstadoTipoLimiteVersionRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@CallSp(nombre = "SP_UPD_CAMB_ESTADO_LIM_VERS")
public class ActualizaEstadoTipoLimiteVersionRepositoryImpl extends SimpleSPGenericDao
        implements ActualizaEstadoTipoLimiteVersionRepository {

    @Override
    public void ejecutar(long idVersionTipoLimite, EstadoTipoLimiteEnum estado, String usuario) throws
            PlataformaBaseException {
        try{
            ejecutar(new MapSqlParameterSource()
                    .addValue("IN_LIMITE_ID", idVersionTipoLimite)
                    .addValue("IN_ESTADO", estado.getId())
                    .addValue("IN_USU_ACTUALIZA", usuario)

                    );
        }catch(SimpleDaoException ex){
            String mensajeError = "error al envíar parametro de bloqueo al SP_UPD_CAMB_ESTADO_LIM_VERS";
            throw new PlataformaBaseException("no se bloqueo el limite", ex, mensajeError);
        }
    }
}
