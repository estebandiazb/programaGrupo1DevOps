package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.Variable;
import io.jsonwebtoken.lang.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VariableRowMapperTest {

    @Test
    public void testRowMapper() throws Exception {
        RowMapper<Variable> mapper = new VariableRowMapper();
        ResultSet rs = mock(ResultSet.class);
        when(rs.getLong("ID")).thenReturn(1L);
        when(rs.getString("NOMBRE")).thenReturn("nombre");
        when(rs.getInt("CANTIDAD")).thenReturn(1);
        Assert.notNull(mapper.mapRow(rs, 1));
    }
}
