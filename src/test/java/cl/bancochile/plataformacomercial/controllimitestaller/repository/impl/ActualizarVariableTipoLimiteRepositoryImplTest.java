package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableLimite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class ActualizarVariableTipoLimiteRepositoryImplTest extends AbstractRepositoyImplTest {

    @InjectMocks
    private ActualizarVariableTipoLimiteRepositoryImpl repository;

    @Test
    public void ejecutar() throws PlataformaBaseException {
        setup();
        repository.ejecutar(new VariableLimite.Builder()
                .id(1L)
                .idVariableAtributo(1L)
                .codigoVariable("CODVARIABLE")
                .items(new ArrayList<>())
                .tooltip("Tooltip")
                .valor("Valor")
                .build());
    }

    @Test(expected = Exception.class)
    public void ejecutarFail() throws PlataformaBaseException {
        setupNOK();
        repository.ejecutar(new VariableLimite.Builder()
                .id(1L)
                .idVariableAtributo(1L)
                .codigoVariable("CODVARIABLE")
                .items(new ArrayList<>())
                .tooltip("Tooltip")
                .valor("Valor")
                .build());
    }
}
