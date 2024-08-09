package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.internal.util.Assert;

@RunWith(MockitoJUnitRunner.class)
public class ObtenerFamiliaSubtipoPorIdRepositoryImplTest extends AbstractRepositoyImplTest {

    @InjectMocks
    private ObtenerFamiliaSubtipoPorIdRepositoryImpl repository;

    @Test
    public void ejecutar() throws PlataformaBaseException {
        setup();
        Assert.notNull(repository.ejecutar(1L));
    }

    @Test(expected = Exception.class)
    public void ejecutarFail() throws PlataformaBaseException {
        setupNOK();
        Assert.notNull(repository.ejecutar(1L));
    }
}
