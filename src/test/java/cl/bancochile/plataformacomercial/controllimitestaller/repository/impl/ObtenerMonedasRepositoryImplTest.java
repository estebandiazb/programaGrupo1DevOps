package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class ObtenerMonedasRepositoryImplTest extends AbstractRepositoyImplTest {

    @InjectMocks
    private ObtenerMonedasRepositoryImpl repository;

    @Test
    public void ejecutar() throws PlataformaBaseException {
        assertNull(repository.ejecutar());
    }
}