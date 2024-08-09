package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.TramoCajaDerivados;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.ResultSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemsVariableAtributoTipoLimiteMapperTest {

    @InjectMocks
    private ItemVariableRowMapper mapper;

    @Test
    public void mapRowDistintosValoresTest() throws Exception {

        ResultSet resultSet = Mockito.mock(ResultSet.class);
        when(resultSet.getLong("ID"))
                .thenReturn(3L);
        when(resultSet.getLong("ID_VARIABLE"))
                .thenReturn(3L);
        when(resultSet.getInt("SELECCIONADO"))
                .thenReturn(0)
                .thenReturn(1);
        when(resultSet.getString("COD_VARIABLE"))
                .thenReturn("CTR127")
                .thenReturn("PES009")
                .thenReturn("PES009");
        when(resultSet.getString("VALOR"))
                .thenReturn("{\"id\": 1, \"nombre\": \"Tramo 1\", \"desde\": null, \"hasta\":null}")
                .thenReturn("Si")
                .thenReturn(null);

        ItemVariable itemVariable =  mapper.mapRow(resultSet, 0);
        assertNotNull(itemVariable);
        assertTrue(itemVariable.getValor() instanceof TramoCajaDerivados);
        assertFalse(itemVariable.isSeleccionado());

        ItemVariable itemVariable2 =  mapper.mapRow(resultSet, 0);
        assertNotNull(itemVariable2);
        assertTrue(itemVariable2.getValor() instanceof String);
        assertTrue(itemVariable2.isSeleccionado());

        ItemVariable itemVariable3 =  mapper.mapRow(resultSet, 0);
        assertNotNull(itemVariable3);
        assertEquals(null, itemVariable3.getValor());
    }
}