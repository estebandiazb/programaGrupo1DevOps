package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariableLimite;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemVariableLimiteRowMapper implements RowMapper<ItemVariableLimite> {

    @Override
    public ItemVariableLimite mapRow(ResultSet rs, int i) throws SQLException {
        return new ItemVariableLimite.Builder()
                .id(rs.getLong("ID_ITEM_VARIABLE_TL"))
                .idVariableLimite(rs.getLong("ID_VARIABLE_TIPO_LIMITE"))
                .idVariableItem(rs.getLong("ID_VARIABLE_ITEM"))
                .seleccionado(rs.getInt("SELECCIONADO") == 0 ? Boolean.FALSE : Boolean.TRUE)
                .valor(rs.getString("VALOR"))
                .build();
    }
}
