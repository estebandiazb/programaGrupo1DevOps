package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.TipoLimiteVersion;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoLimiteVersionRowMapper implements RowMapper<TipoLimiteVersion> {

    @Override
    public TipoLimiteVersion mapRow(ResultSet rs, int i) throws SQLException {
        TipoLimiteVersion tipoLimite = new TipoLimiteVersion();

        tipoLimite.setId(rs.getLong("ID"));
        tipoLimite.setIdTipoLimite(rs.getLong("M_TIPO_LIMITE_ID"));
        tipoLimite.setNombre(rs.getString("NOMBRE"));
        tipoLimite.setComentarios(rs.getString("DESCRIPCION"));
        tipoLimite.setVersion(rs.getInt("VERSION"));
        tipoLimite.setUsuarioCreacion(rs.getString("USUARIO_CREACION"));
        tipoLimite.setUsuarioModificacion(rs.getString("USUARIO_ACTUALIZACION"));
        tipoLimite.setFechaActualizacion(rs.getString("FECHA_ACTUALIZACION"));
        tipoLimite.setFechaCreacion(rs.getString("FECHA_CREACION"));
        tipoLimite.setEstado(EstadoTipoLimiteEnum.getById(rs.getInt("ESTADO")));
        tipoLimite.setCodigo(rs.getString("CODIGO"));

        return tipoLimite;
    }
}
