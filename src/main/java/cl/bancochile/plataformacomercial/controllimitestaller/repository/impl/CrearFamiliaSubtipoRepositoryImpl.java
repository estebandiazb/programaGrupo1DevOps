package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.CrearFamiliaSubtipoRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@CallSp(nombre = "SP_CREAR_FAMILIA_SUBTIPO")
public class CrearFamiliaSubtipoRepositoryImpl extends SimpleSPGenericDao implements CrearFamiliaSubtipoRepository {

    @Override
    public long ejecutar(String nombreFamiliaSubtipo) throws PlataformaBaseException {
        try {
            Map<String, Object> salida =ejecutar(new MapSqlParameterSource()
                    .addValue("IN_NOMBRE_FAMILIA_SUBTIPO", nombreFamiliaSubtipo));
            return MapperUtils.mapNumberToLong(salida, "OUT_ID_FAMILIA_SUBTIPO");
        } catch (SimpleDaoException ex) {
            if (ex.getCodigo() == -2){
                throw new TallerException(MsgErrorEnum.MSG_ERROR_EXISTE_NOMBRE_FAMSUBTIPO, ex);
            }
            String mensajeError = "error al crear familia de subtipo.";
            throw new PlataformaBaseException("rollBack crear familia subtipo", ex, mensajeError);
        }
    }
}
