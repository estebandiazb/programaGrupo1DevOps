package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;


import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.CategoriaAtributoEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.ResultSet;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AtributoRowMapperTest {

    @InjectMocks
    private AtributoRowMapper mapper;

    @Test
    public void mapRow() throws Exception {
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        when(resultSet.getString("CATEGORIA"))
                .thenReturn(null)
                .thenReturn(CategoriaAtributoEnum.BASICO.getDescripcion());
        when(resultSet.getLong("ID_ATRIBUTO"))
                .thenReturn(1L);
        when(resultSet.getString("COD_ATRIBUTO"))
                .thenReturn("COD");
        when(resultSet.getString("NOMBRE_ATRIBUTO"))
                .thenReturn("nombre");
        when(resultSet.getString("DESCRIPCION"))
                .thenReturn("descripcion");
        when(resultSet.getInt("OBLIGATORIO"))
                .thenReturn(1)
                .thenReturn(0);

        assertNotNull(mapper.mapRow(resultSet, 0));
        assertNotNull(mapper.mapRow(resultSet, 0));
    }
}
