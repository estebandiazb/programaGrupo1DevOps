package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimite;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ActualizaEstadoTipoLimite2Repository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_CAMBIO_ESTADO_TIPO_LIMITE;

@Repository
@CallSp(nombre = "SP_UPD_CAMB_ESTADO_LIM")
public class ActualizaEstadoLimite2RepositoryImpl extends SimpleSPGenericDao
        implements ActualizaEstadoTipoLimite2Repository {

    @Override
    public void ejecutar(TipoLimite tipoLimite) throws PlataformaBaseException {
        try{
            ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_LIM", tipoLimite.getId())
                    .addValue("IN_ESTADO", tipoLimite.getEstado().getId())
            );
        }catch(SimpleDaoException ex){
            throw new PlataformaBaseException(MSG_ERROR_CAMBIO_ESTADO_TIPO_LIMITE.getMensaje(), ex,
                    MSG_ERROR_CAMBIO_ESTADO_TIPO_LIMITE.getCodigo());
        }
    }
}
