package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.CategoriaSeleccionable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.ResultSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoriaSeleccionableMapperTest {

    @InjectMocks
    private CategoriaSeleccionableMapper mapper;

    @Test
    public void mapRow() throws Exception {
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        when(resultSet.getLong(anyString()))
                .thenReturn(1000L);
        when(resultSet.getString(anyString()))
                .thenReturn("BASICO");
        when(resultSet.getInt(anyString()))
                .thenReturn(0);
        CategoriaSeleccionable categoriaSeleccionable = mapper.mapRow(resultSet, 0);
        assertNotNull(categoriaSeleccionable);
        assertFalse(categoriaSeleccionable.isSeleccionado());
    }

    @Test
    public void mapRow2() throws Exception {
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        when(resultSet.getLong(anyString()))
                .thenReturn(1000L);
        when(resultSet.getString(anyString()))
                .thenReturn("AVANZADO");
        when(resultSet.getInt(anyString()))
                .thenReturn(1);

        CategoriaSeleccionable categoriaSeleccionable = mapper.mapRow(resultSet, 0);
        assertNotNull(categoriaSeleccionable);
        assertTrue(categoriaSeleccionable.isSeleccionado());
    }
}