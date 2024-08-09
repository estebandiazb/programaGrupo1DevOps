package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarMotivoNoRatingRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EliminarMotivoNoRatingRepositoryTest extends AbstractRepositoyImplTest {
    @InjectMocks
    private EliminarMotivosNoRatingRepositoryImpl repository;
    @Test
    public void ejecutar() throws PlataformaBaseException {
        repository.ejecutar(1L);}

    @Test(expected = PlataformaBaseException.class)
    public void ejecutarNOK() throws PlataformaBaseException {
        setupNOK();
        repository.ejecutar(1L);}
}
