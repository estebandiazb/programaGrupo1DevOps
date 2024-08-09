package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableAtributo;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.AgregarVariablesTipoLimiteVersionRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapNumberToLong;

@Repository
@CallSp(nombre = "SP_INS_VARIABLE_TL_VERSION")
public class AgregarVariablesTipoLimiteVersionRepositoryImpl extends SimpleSPGenericDao
        implements AgregarVariablesTipoLimiteVersionRepository {
    @Override
    public long ejecutar(long idTipoLimiteVersion, VariableAtributo variable) throws PlataformaBaseException {
        try {

            Map<String, Object> resultSet = ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_TIPO_LIMITE_VERSION", idTipoLimiteVersion)
                    .addValue("IN_ID_ATRIBUTO", variable.getIdAtributo())
                    .addValue("IN_ID_VARIABLE", variable.getId())
                    .addValue("IN_TOOLTIP", variable.getTooltip())
                    .addValue("IN_VALOR", variable.getValor())
            );

            return mapNumberToLong(resultSet, "OUT_ID_VARIABLE_TL");

        } catch (SimpleDaoException ex) {
            throw new TallerException(MsgErrorEnum.MSG_ERROR_CREAR_TIPO_LIMITE_VERSION, ex);
        }
    }
}
