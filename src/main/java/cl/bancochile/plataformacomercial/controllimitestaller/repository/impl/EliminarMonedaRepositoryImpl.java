package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarMonedaRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_DEL_MONEDA;

@Repository
@CallSp(nombre = "SP_DEL_MONEDA_BCO")
public class EliminarMonedaRepositoryImpl extends SimpleSPGenericDao
        implements EliminarMonedaRepository {

    @Override
    public void ejecutar(long idMoneda, String idUsaurio) throws PlataformaBaseException {
        try {
            ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_MONEDA", idMoneda)
                    .addValue("IN_USUARIO", idUsaurio)
            );
        } catch (SimpleDaoException ex) {
            throw new TallerException(MSG_ERROR_DEL_MONEDA, ex);
        }
    }
}
