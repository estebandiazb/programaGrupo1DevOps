package cl.bancochile.plataformacomercial.controllimitestaller.repository.mapper;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableAtributo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.ResultSet;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VariableAtributoTipoLimiteMapperTest {

    @InjectMocks
    private VariableAtributoTipoLimiteMapper mapper;

    @Test
    public void mapRow() throws Exception {

        ResultSet resultSet = Mockito.mock(ResultSet.class);
        when(resultSet.getString("VALOR"))
                .thenReturn("1")
                .thenReturn("2")
                .thenReturn("[{ \"id\": 9, \"valor\": \"Mixto\", \"seleccionado\": false }]");
        when(resultSet.getString("CODIGO"))
                .thenReturn("AAAA")
                .thenReturn("AAAAA")
                .thenReturn("GLS101");
        when(resultSet.getLong("ID"))
                .thenReturn(100L);
        when(resultSet.getLong("ID_ATRIBUTO"))
                .thenReturn(100L);
        when(resultSet.getString("NOMBRE"))
                .thenReturn("Nombre");
        when(resultSet.getInt("TIPO_DATO"))
                .thenReturn(1)
                .thenReturn(5)
                .thenReturn(1);
        when(resultSet.getString("TOOLTIP"))
                .thenReturn("Lalala");

        VariableAtributo variableAtributo = mapper.mapRow(resultSet, 0);
        Object valor = variableAtributo.getValor();
        assertNotNull(variableAtributo);
        assertTrue(valor instanceof String);

        VariableAtributo variableAtributo2 = mapper.mapRow(resultSet, 0);
        Object valor2 = variableAtributo2.getValor();
        assertNotNull(variableAtributo2);
        assertTrue(valor2 instanceof Boolean);

        VariableAtributo variableAtributo3 = mapper.mapRow(resultSet, 0);
        Object valor3 = variableAtributo3.getValor();
        assertNotNull(variableAtributo3);
        assertTrue(valor3 instanceof List);

        List items2 = (List) valor3;
        assertTrue(!items2.isEmpty() && items2.get(0) instanceof ItemVariable );
    }
}