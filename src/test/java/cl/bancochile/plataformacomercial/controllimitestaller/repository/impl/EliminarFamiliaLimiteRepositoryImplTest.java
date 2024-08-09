package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EliminarFamiliaLimiteRepositoryImplTest extends AbstractRepositoyImplTest {
    @InjectMocks
    private EliminarFamiliaLimiteRepositoryImpl repository;

    @Test
    public void ejecutar() throws PlataformaBaseException {
        repository.ejecutar(1, "test");
    }

    @Test(expected = PlataformaBaseException.class)
    public void ejecutarNOK() throws PlataformaBaseException {
        setupNOK();
        repository.ejecutar(1, "test");
    }
}