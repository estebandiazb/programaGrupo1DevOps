package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ParametroMac;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ActualizaRatingVigenteRepositoryImplTest extends AbstractRepositoyImplTest {

    @InjectMocks
    private ActualizaRatingVigenteRepositoryImpl actualizaRatingVigenteRepositoryImpl;

    @Test
    public void ejecutar() throws PlataformaBaseException {
        setup();
        ParametroMac parametroMac = new ParametroMac.Builder()
                .id(1L)
                .valor(21L)
                .build();
        actualizaRatingVigenteRepositoryImpl.ejecutar(parametroMac);
    }

    @Test(expected = Exception.class)
    public void ejecutarFail() throws PlataformaBaseException {
        setupNOK();
        actualizaRatingVigenteRepositoryImpl.ejecutar(new ParametroMac());
    }

}