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
public class AtributoParametroMacMapperTest {

    @InjectMocks
    private AtributoParametroMacMapper atributoParametroMacMapper;

    @Test
    public void mapRow() throws Exception {
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        when(resultSet.getLong("ID"))
                .thenReturn(1L);
        when(resultSet.getString("PARAMETRO"))
                .thenReturn("DIAS_RATING");
        when(resultSet.getLong("VALOR"))
                .thenReturn(21L);
        assertNotNull(atributoParametroMacMapper.mapRow(resultSet, 0));
    }
}