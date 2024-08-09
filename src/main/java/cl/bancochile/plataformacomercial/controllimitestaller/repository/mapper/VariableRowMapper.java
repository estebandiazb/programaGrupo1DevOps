package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.Variable;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VariableRowMapper implements RowMapper<Variable> {

    @Override
    public Variable mapRow(ResultSet rs, int i) throws SQLException {
        return new Variable.Builder()
                .id(rs.getLong("ID"))
                .nombre(rs.getString("NOMBRE"))
                .cantidad(rs.getInt("CANTIDAD"))
                .build();
    }
}
