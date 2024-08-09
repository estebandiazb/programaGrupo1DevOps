package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EliminarTipoLimiteRepositoryImplTest extends AbstractRepositoyImplTest{

    @InjectMocks
    private EliminarTipoLimiteRepositoryImpl eliminarLimiteRepository;

    @Test
    public void ejecutar() throws PlataformaBaseException{
        eliminarLimiteRepository.ejecutar(1);
    }

    @Test(expected = Exception.class)
    public void ejecutaNOK() throws PlataformaBaseException{
        setupNOK();
        eliminarLimiteRepository.ejecutar(11);
    }
}
