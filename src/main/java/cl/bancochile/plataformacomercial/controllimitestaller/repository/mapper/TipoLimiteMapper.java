package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimite;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoLimiteMapper implements RowMapper<TipoLimite> {

    @Override
    public TipoLimite mapRow(ResultSet resultSet, int i) throws SQLException {
        return new TipoLimite.Builder()
                .id(resultSet.getLong("OUT_ID_TIPO_LIMITE"))
                .codigo(resultSet.getString("OUT_CODIGO"))
                .idVersion(resultSet.getLong("OUT_ID_VERSION"))
                .nombre(resultSet.getString("OUT_NOMBRE"))
                .comentarios(resultSet.getString("OUT_DESCRIPCION"))
                .version(resultSet.getInt("OUT_VERSION"))
                .fechaCreacion(resultSet.getString("OUT_FECHA_CREACION"))
                .usuarioCreacion(resultSet.getString("OUT_USUARIO_CREACION"))
                .fechaActualizacion(resultSet.getString("OUT_FECHA_ACTUALIZACION"))
                .usuarioActualizacion(resultSet.getString("OUT_USUARIO_ACTUALIZACION"))
                .estado(EstadoTipoLimiteEnum.getById(resultSet.getInt("OUT_ESTADO_TP")))
                .idFamiliaLimite(resultSet.getLong("OUT_ID_FAMILIA_LIMITE"))
                .build();
    }
}
