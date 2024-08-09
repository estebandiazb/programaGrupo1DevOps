package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ConsultarTipoLimitesRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ObtenerTipoLimitesRepositoryImplTest extends AbstractRepositoyImplTest {

    @InjectMocks
    private ObtenerTipoLimitesRepositoryImpl repository;

    @Test
    public void ejecutar() throws PlataformaBaseException {
        repository.ejecutar(new ConsultarTipoLimitesRequest());
    }
}