package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.ParametroMac;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AtributoParametroMacMapper implements RowMapper<ParametroMac> {

    @Override
    public ParametroMac mapRow(ResultSet resultSet, int i) throws SQLException {
        return new ParametroMac.Builder()
                .id(resultSet.getLong("ID"))
                .parametro(resultSet.getString("PARAMETRO"))
                .valor(resultSet.getLong("VALOR"))
                .build();
    }
}
