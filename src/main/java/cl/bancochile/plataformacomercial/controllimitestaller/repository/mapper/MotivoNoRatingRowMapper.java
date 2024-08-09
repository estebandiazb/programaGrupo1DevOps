package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.MotivoNoRating;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MotivoNoRatingRowMapper implements RowMapper<MotivoNoRating> {

    @Override
    public MotivoNoRating mapRow(ResultSet resultSet, int i) throws SQLException {
        return new MotivoNoRating.Builder()
                .id(resultSet.getLong("ID"))
                .orden(resultSet.getInt("ORDEN"))
                .descripcion(resultSet.getString("DESCRIPCION"))
                .fechaCreacion(resultSet.getString("FECHA_CREACION"))
                .fechaActualizacion(resultSet.getString("FECHA_ACTUALIZACION"))
                .usuarioCreador(resultSet.getString("USUARIO_CREADOR"))
                .build();
    }
}
