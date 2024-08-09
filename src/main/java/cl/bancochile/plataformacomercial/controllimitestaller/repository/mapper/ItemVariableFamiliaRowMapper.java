package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemVariableFamiliaRowMapper implements RowMapper<ItemVariable> {

    @Override
    public ItemVariable mapRow(ResultSet rs, int i) throws SQLException {
        return new ItemVariable.Builder()
                .id(rs.getLong("ID"))
                .valor(rs.getString("VALOR"))
                .build();
    }
}
