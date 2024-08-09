package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimite;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.CrearTipoLimiteRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapNumberToLong;
import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapToString;

@Repository
@CallSp(nombre = "SP_INS_TIPO_LIMITE")
public class CrearTipoLimiteRepositoryImpl extends SimpleSPGenericDao
        implements CrearTipoLimiteRepository {
    @Override
    public TipoLimite ejecutar(String prefijoTipoLimite) throws PlataformaBaseException {
        try {

            Map<String, Object> resultSet = ejecutar(new MapSqlParameterSource()
                    .addValue("IN_PREFIJO_CODIGO", prefijoTipoLimite)
            );
            return new TipoLimite.Builder()
                    .id(mapNumberToLong(resultSet, "OUT_ID_TIPO_LIMITE"))
                    .codigo(mapToString(resultSet, "OUT_CODIGO_TL"))
                    .build();

        } catch (SimpleDaoException ex) {
            throw new TallerException(MsgErrorEnum.MSG_ERROR_CREAR_TIPO_LIMITE, ex);
        }
    }
}
