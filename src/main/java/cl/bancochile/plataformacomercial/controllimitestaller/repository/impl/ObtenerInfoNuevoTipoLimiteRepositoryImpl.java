package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerInfoNuevoTipoLimiteRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapNumberToInt;
import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapNumberToLong;

@Repository
@CallSp(nombre = "SP_GET_INFO_NUEVO_TL")
public class ObtenerInfoNuevoTipoLimiteRepositoryImpl extends SimpleSPGenericDao
        implements ObtenerInfoNuevoTipoLimiteRepository {

    @Override
    public long ejecutar(long idFamiliaTipoLimite, String prefijo) throws PlataformaBaseException {

        try {

            Map<String, Object> resultSet = ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_FAMILIA_TIPO_LIMITE", idFamiliaTipoLimite)
                    .addValue("IN_PREFIJO", prefijo)
            );

            boolean existePrefijo = mapNumberToInt(resultSet, "OUT_EXISTE_PREFIJO") == 1;

            if(existePrefijo){
                throw new TallerException(MsgErrorEnum.MSG_ERROR_YA_EXISTE_PREFIJO);
            }

            return mapNumberToLong(resultSet, "OUT_ID_CORRELATIVO");

        } catch (SimpleDaoException e) {
            throw new TallerException(MsgErrorEnum.MSG_ERROR_GET_INFO_TL, e);
        }
    }
}
