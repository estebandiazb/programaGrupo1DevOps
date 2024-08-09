package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableLimite;
import io.jsonwebtoken.lang.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VariableLimiteRowMapperTest {

    @Test
    public void testRowMapper() throws Exception {

        RowMapper<VariableLimite> mapper = new VariableLimiteRowMapper();
        ResultSet rs = mock(ResultSet.class);
        when(rs.getLong("ID_VARIABLE_TIPO_LIMITE"))
                .thenReturn(1L);
        when(rs.getString("TOOLTIP"))
                .thenReturn("tooltip");
        when(rs.getString("VALOR"))
                .thenReturn("valor");
        when(rs.getString("CODIGO_VARIABLE"))
                .thenReturn("001");
        when(rs.getString("CODIGO_ATRIBUTO"))
                .thenReturn("CRT127");

        Assert.notNull(mapper.mapRow(rs, 1));
    }
}
