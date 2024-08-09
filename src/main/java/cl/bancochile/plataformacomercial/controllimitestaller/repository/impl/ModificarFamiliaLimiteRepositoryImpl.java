package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ModificarFamiliaLimiteRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.FamiliaLimite;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapToString;

@Repository
@CallSp(nombre = "SP_UPD_FAMILIA_LIMITE")
public class ModificarFamiliaLimiteRepositoryImpl extends SimpleSPGenericDao
        implements ModificarFamiliaLimiteRepository {

    @Override
    public void ejecutar(FamiliaLimite familiaLimite) throws PlataformaBaseException {
        try {
            Map<String, Object> resultSet = ejecutar(new MapSqlParameterSource()
                    .addValue("IN_ID_FAMILIA_LIMITE", familiaLimite.getId())
                    .addValue("IN_NOMBRE", familiaLimite.getNombre())
                    .addValue("IN_USUARIO_MODIFICACION", familiaLimite.getUsuarioModificacion())
            );
            familiaLimite.setFechaActualizacion(mapToString(resultSet, "OUT_FECHA_MODIFICACION"));
        } catch (SimpleDaoException ex) {
            throw new TallerException(MsgErrorEnum.MSG_ERROR_INS_FAMLIM, ex);
        }
    }
}
