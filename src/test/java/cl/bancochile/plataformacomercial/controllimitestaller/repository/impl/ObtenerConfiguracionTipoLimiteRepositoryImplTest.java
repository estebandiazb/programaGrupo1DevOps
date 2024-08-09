package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariableLimite;
import cl.bancochile.plataformacomercial.controllimitestaller.fixture.VariableLimiteFixture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ObtenerConfiguracionTipoLimiteRepositoryImplTest extends AbstractRepositoyImplTest {

    @InjectMocks
    private ObtenerConfiguracionTipoLimiteRepositoryImpl repository;

    @Test
    public void ejecutar() throws PlataformaBaseException {
        Map<String, Object> customMap = new LinkedHashMap<>();
        customMap.put("OUT_VARIABLES", VariableLimiteFixture.getConfiguracionLimite());
        customMap.put("OUT_VARIABLES_ITEM", VariableLimiteFixture.getItemsVariable(
                new ItemVariableLimite.Builder()
                        .id(3L)
                        .idVariableItem(2L)
                        .valor("Valor 10")
                        .seleccionado(Boolean.TRUE)
                        .build(),
                new ItemVariableLimite.Builder()
                        .id(4L)
                        .idVariableItem(3L)
                        .valor("Valor 11")
                        .seleccionado(Boolean.TRUE)
                        .build()));

        when(simpleJdbcCall.execute(any(SqlParameterSource.class)))
                .thenReturn(getResultOK(customMap));

        repository.ejecutar(1L);
    }

    @Test(expected = Exception.class)
    public void ejecutarFail() throws PlataformaBaseException {
        setupNOK();
        repository.ejecutar(1L);
    }
}
