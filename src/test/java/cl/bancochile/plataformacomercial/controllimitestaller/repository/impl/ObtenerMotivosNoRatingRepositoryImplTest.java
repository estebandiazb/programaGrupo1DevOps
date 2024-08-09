package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.SimpleDaoException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ObtenerMotivosNoRatingRepositoryImplTest extends AbstractRepositoyImplTest {

    @InjectMocks
    private ObtenerMotivosNoRatingRepositoryImpl obtenerMotivosNoRatingRepository;

    @Test
    public void ejecutar(){
        obtenerMotivosNoRatingRepository.ejecutar();
    }

    @Test(expected = SimpleDaoException.class)
    public void ejecutarFail(){
        setupNOK();
        obtenerMotivosNoRatingRepository.ejecutar();
    }

}
