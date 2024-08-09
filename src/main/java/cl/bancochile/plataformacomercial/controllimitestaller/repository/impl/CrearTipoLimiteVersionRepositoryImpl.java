package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimiteFull;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.CrearTipoLimiteVersionRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapNumberToLong;

@Repository
@CallSp(nombre = "SP_INS_TIPO_LIMITE_VERSION")
public class CrearTipoLimiteVersionRepositoryImpl extends SimpleSPGenericDao
        implements CrearTipoLimiteVersionRepository {
    @Override
    public long ejecutar(TipoLimiteFull tipoLimite) throws PlataformaBaseException {
        try {

            Map<String, Object> resultSet = ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_TIPO_LIMITE", tipoLimite.getIdTipoLimite())
                    .addValue("IN_NOMBRE", tipoLimite.getNombre())
                    .addValue("IN_DESCRIPCION", tipoLimite.getComentarios())
                    .addValue("IN_USUARIO_CREACION", tipoLimite.getUsuarioCreacion())
                    .addValue("IN_USUARIO_ACTUALIZACION", tipoLimite.getUsuarioModificacion())
                    .addValue("IN_ID_FAMILIA_LIMITE", tipoLimite.getIdFamiliaLimite())
            );

            return mapNumberToLong(resultSet, "OUT_ID_VERSION");

        } catch (SimpleDaoException ex) {
            throw new TallerException(MsgErrorEnum.MSG_ERROR_CREAR_TIPO_LIMITE_VERSION, ex);
        }
    }
}
