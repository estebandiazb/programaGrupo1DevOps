package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ObtenerAtributosFiltroRepositoryImplTest extends AbstractRepositoyImplTest {
    @InjectMocks
    private ObtenerAtributosFiltroRepositoryImpl repository;

    @Test
    public void ejecutar() throws PlataformaBaseException {
        repository.ejecutar();
    }
}