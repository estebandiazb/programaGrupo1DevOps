package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.ResultSet;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AtributoTipoLimiteMapperTest {

    @InjectMocks
    private AtributoTipoLimiteMapper mapper;

    @Test
    public void mapRow() throws Exception {
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        when(resultSet.getInt(anyString()))
                .thenReturn(0)
                .thenReturn(1);
        when(resultSet.getLong(anyString()))
                .thenReturn(2L);
        when(resultSet.getString(anyString()))
                .thenReturn("test2");
        assertNotNull(mapper.mapRow(resultSet, 0));
        assertNotNull(mapper.mapRow(resultSet, 0));
    }
}