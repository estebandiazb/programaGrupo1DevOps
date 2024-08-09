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
public class ActualizarMotivoNoRatingRespositoryImplTest extends AbstractRepositoyImplTest {

    @InjectMocks
    private ActualizarMotivoNoRatingRepositoryImpl actualizarMotivoNoRatingRepository;

    @Test
    public void ejecutar() throws PlataformaBaseException {
        actualizarMotivoNoRatingRepository.ejecutar(new MotivoNoRating());
        actualizarMotivoNoRatingRepository.ejecutar(new MotivoNoRating(), "aaaa", "bbbb");
    }

    @Test(expected = TallerException.class)
    public void ejecutarFail() throws PlataformaBaseException {
        setupNOK();
        actualizarMotivoNoRatingRepository.ejecutar(new MotivoNoRating());
    }
}
