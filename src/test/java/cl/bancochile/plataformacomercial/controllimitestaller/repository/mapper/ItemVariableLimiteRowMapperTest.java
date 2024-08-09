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
public class ItemVariableLimiteRowMapperTest {

    @InjectMocks
    private ItemVariableLimiteRowMapper mapper;

    @Test
    public void mapRow() throws Exception {
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        when(resultSet.getLong("ID_ITEM_VARIABLE_TL"))
                .thenReturn(1L);
        when(resultSet.getLong("ID_VARIABLE_TIPO_LIMITE"))
                .thenReturn(1L);
        when(resultSet.getLong("ID_VARIABLE_ITEM"))
                .thenReturn(1L);
        when(resultSet.getString("VALOR"))
                .thenReturn("Valor");
        when(resultSet.getInt("SELECCIONADO"))
                .thenReturn(1)
                .thenReturn(0);

        assertNotNull(mapper.mapRow(resultSet, 0));
        assertNotNull(mapper.mapRow(resultSet, 0));
    }
}
