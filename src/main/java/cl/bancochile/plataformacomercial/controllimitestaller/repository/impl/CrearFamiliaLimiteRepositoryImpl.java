package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.CrearFamiliaLimiteRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.FamiliaLimite;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapNumberToLong;
import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapToString;

@Repository
@CallSp(nombre = "SP_INS_FAMILIA_LIMITE")
public class CrearFamiliaLimiteRepositoryImpl extends SimpleSPGenericDao
        implements CrearFamiliaLimiteRepository {
    @Override
    public void ejecutar(FamiliaLimite familiaLimite) throws PlataformaBaseException {
        try {
            Map<String, Object> resultSet = ejecutar(new MapSqlParameterSource()
                    .addValue("IN_NOMBRE", familiaLimite.getNombre())
                    .addValue("IN_USUARIO_CREACION", familiaLimite.getUsuarioCreacion())
            );
            familiaLimite.setId(mapNumberToLong(resultSet, "OUT_ID_FAMILIA"));
            familiaLimite.setFechaCreacion(mapToString(resultSet, "OUT_FECHA_CREACION"));
            familiaLimite.setEstado(EstadoTipoLimiteEnum.ACTIVO);
            familiaLimite.setCantidadLimitesActivos(0);
            familiaLimite.setCantidadLimitesBorrador(0);
            familiaLimite.setCantidadLimitesEnProceso(0);
            familiaLimite.setCantidadLimitesHistoricos(0);
        } catch (SimpleDaoException ex) {
            if (ex.getCodigo() == -1){
                throw new TallerException(MsgErrorEnum.MSG_ERROR_EXISTE_NOMBRE_FAMLIM, ex);
            }
            throw new TallerException(MsgErrorEnum.MSG_ERROR_INS_FAMLIM, ex);
        }
    }
}
