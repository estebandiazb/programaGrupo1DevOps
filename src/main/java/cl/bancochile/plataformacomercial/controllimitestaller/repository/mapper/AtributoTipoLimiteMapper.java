package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.Atributo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AtributoTipoLimiteMapper implements RowMapper<Atributo> {

    @Override
    public Atributo mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Atributo.Builder()
                .id(resultSet.getLong("ID"))
                .codigo(resultSet.getString("COD_ATRIBUTO"))
                .nombre(resultSet.getString("NOMBRE_ATRIBUTO"))
                .comentario(resultSet.getString("COMENTARIO"))
                .categorias(null)
                .obligatorio(resultSet.getInt("OBLIGATORIO") == 1)
                .build();
    }
}
