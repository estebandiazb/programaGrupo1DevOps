package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.ResultSet;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemVariableFamiliaRowMapperTest {

    @InjectMocks
    private ItemVariableFamiliaRowMapper mapper;

    @Test
    public void mapRow() throws Exception {
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        when(resultSet.getLong("ID"))
                .thenReturn(1L);
        when(resultSet.getString("Valor"))
                .thenReturn("Valor");

        assertNotNull(mapper.mapRow(resultSet, 0));
    }
}
