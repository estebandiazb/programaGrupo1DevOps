package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import io.jsonwebtoken.lang.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemVariableRowMapperTest {

    @Test
    public void testRowMapper() throws Exception {
        RowMapper<ItemVariable> mapper = new ItemVariableRowMapper();
        ResultSet rs = mock(ResultSet.class);
        when(rs.getLong("ID"))
                .thenReturn(1L);
        when(rs.getString("VALOR"))
                .thenReturn("valor")
                .thenReturn("CTR127");
        when(rs.getInt("ASIGNADO"))
                .thenReturn(0)
                .thenReturn(1);
        when(rs.getInt("SELECCIONADO"))
                .thenReturn(0)
                .thenReturn(1);
        Assert.notNull(mapper.mapRow(rs, 1));
        Assert.notNull(mapper.mapRow(rs, 1));
    }
}
