package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ObtenerRatingVigenteRepositoryImplTest extends AbstractRepositoyImplTest{

    @InjectMocks
    private ObtenerRatingVigenteRepositoryImpl obtenerRatingVigenteRepositoryImpl;

    @Test
    public void ejecutar() throws PlataformaBaseException {
        setup();
        obtenerRatingVigenteRepositoryImpl.ejecutar("DIAS_RATING");
    }

    @Test(expected = Exception.class)
    public void ejecutarFail() throws PlataformaBaseException {
        setupNOK();
        obtenerRatingVigenteRepositoryImpl.ejecutar(null);
    }

}