package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableLimite;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VariableLimiteRowMapper implements RowMapper<VariableLimite> {

    @Override
    public VariableLimite mapRow(ResultSet rs, int i) throws SQLException {
        return new VariableLimite.Builder()
                .id(rs.getLong("ID_VARIABLE_TIPO_LIMITE"))
                .tooltip(rs.getString("TOOLTIP"))
                .valor(rs.getString("VALOR"))
                .codigoVariable(rs.getString("CODIGO_VARIABLE"))
                .codigoAtributo(rs.getString("CODIGO_ATRIBUTO"))
                .build();
    }
}
