package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariableLimite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ActualizarItemVariablesTipoLimiteRepositoryImplTest extends AbstractRepositoyImplTest {

    @InjectMocks
    private ActualizarItemVariablesTipoLimiteRepositoryImpl repository;

    @Test
    public void ejecutar() throws PlataformaBaseException {
        setup();
        repository.ejecutar(new ItemVariableLimite.Builder()
                .id(1L)
                .idVariableItem(1L)
                .seleccionado(Boolean.TRUE)
                .valor("Valor")
                .build());
        repository.ejecutar(new ItemVariableLimite.Builder()
                .id(1L)
                .idVariableItem(1L)
                .seleccionado(Boolean.FALSE)
                .valor("Valor")
                .build());
    }

    @Test(expected = Exception.class)
    public void ejecutarFail() throws PlataformaBaseException {
        setupNOK();
        repository.ejecutar(new ItemVariableLimite.Builder()
                .id(1L)
                .idVariableItem(1L)
                .seleccionado(Boolean.TRUE)
                .valor("Valor")
                .build());
    }
}
