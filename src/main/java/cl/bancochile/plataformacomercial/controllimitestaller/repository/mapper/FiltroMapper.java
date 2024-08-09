package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.Filtro;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FiltroMapper implements RowMapper<Filtro> {

    @Override
    public Filtro mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Filtro.Builder()
                .id(resultSet.getLong("OUT_ID"))
                .codigo(resultSet.getString("OUT_CODIGO"))
                .nombre(resultSet.getString("OUT_NOMBRE"))
                .build();
    }
}
