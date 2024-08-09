package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.CallSp;
import cl.bancochile.bchdao.repository.SimpleSPGenericDao;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimiteFull;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerTipoLimitePorIdRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapNumberToInt;
import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapNumberToLong;
import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.MapperUtils.mapToString;

@Repository
@CallSp(nombre = "SP_GET_TIPO_LIMITE_POR_ID")
public class ObtenerTipoLimitePorIdRepositoryImpl extends SimpleSPGenericDao
        implements ObtenerTipoLimitePorIdRepository {

    @Override
    public TipoLimiteFull ejecutar(long idVersionTipoLimite) {

        Map<String, Object> resultSet =
                ejecutar(new MapSqlParameterSource()
                        .addValue("IN_ID_TIPO_LIMITE_VERSION", idVersionTipoLimite));
        return outMapper(resultSet);
    }

    private static TipoLimiteFull outMapper(Map<String, Object> resultSet) {

        String codigo = mapToString(resultSet, "OUT_CODIGO");
        String prefijo = StringUtils.substring(codigo, 0, 4);
        return new TipoLimiteFull.Builder()
                .id(mapNumberToLong(resultSet, "OUT_ID_TL_VERSION"))
                .idTipoLimite(mapNumberToLong(resultSet, "OUT_ID_TIPO_LIMITE"))
                .codigo(codigo)
                .nombre(mapToString(resultSet, "OUT_NOMBRE"))
                .descripcion(mapToString(resultSet, "OUT_DESCRIPCION"))
                .estado(EstadoTipoLimiteEnum.getById(mapNumberToInt(resultSet, "OUT_ESTADO_TL")))
                .fechaCreacion(mapToString(resultSet, "OUT_FECHA_CREACION"))
                .fechaActualizacion(mapToString(resultSet, "OUT_FECHA_ACTUALIZACION"))
                .usuarioCreacion(mapToString(resultSet, "OUT_USUARIO_CREACION"))
                .usuarioActualizacion(mapToString(resultSet, "OUT_USUARIO_ACTUALIZACION"))
                .version(mapNumberToInt(resultSet, "OUT_VERSION"))
                .prefijo(prefijo)
                .familiaLimite(mapNumberToLong(resultSet, "OUT_FAMILIA_TIPO_LIMITE"))
                .nombreFamiliaLimite(mapToString(resultSet, "OUT_NOMBRE_FAMILIA_TL"))
                .build();
    }
}
