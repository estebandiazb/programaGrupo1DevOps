package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.impl.PerfilUserImpl;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.MotivoNoRating;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AgregarMotivoNoRatingRepositoryImplTest extends AbstractRepositoyImplTest{

    @InjectMocks
    private AgregarMotivoNoRatingRepositoryImpl agregarMotivoNoRatingRepository;

    @Test
    public void ejecutar() throws PlataformaBaseException {

        agregarMotivoNoRatingRepository.ejecutar(new MotivoNoRating(), new PerfilUserImpl());
    }

    @Test(expected = TallerException.class)
    public void ejecutarfail() throws PlataformaBaseException {

        setupNOK();
        agregarMotivoNoRatingRepository.ejecutar(new MotivoNoRating(), new PerfilUserImpl());
    }

}
