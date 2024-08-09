package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ParametroMac;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ActualizaRatingVigenteRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_UPD_PARAMETROS_MAC;

@Repository
@CallSp(nombre = "SP_UPDATE_PARAMETROS_MAC")
public class ActualizaRatingVigenteRepositoryImpl extends SimpleSPGenericDao
        implements ActualizaRatingVigenteRepository {

    @Override
    public void ejecutar(ParametroMac parametroMac) throws
            PlataformaBaseException {
        try {
             ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID", parametroMac.getId())
                    .addValue("IN_VALOR", parametroMac.getValor())
            );
        } catch (SimpleDaoException ex) {
            throw new TallerException(MSG_ERROR_UPD_PARAMETROS_MAC.getMensaje(), ex);
        }


    }
}
