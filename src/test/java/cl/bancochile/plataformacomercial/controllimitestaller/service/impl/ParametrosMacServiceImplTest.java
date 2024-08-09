package cl.bancochile.plataformacomercial.controllimitestaller.service.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.fixture.ParametroMacFixture;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerRatingVigenteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ParametrosMacServiceImplTest {

    @InjectMocks
    private ParametrosMacServiceImpl parametrosMacService;

    @Mock
    private ObtenerRatingVigenteRepository obtenerRatingVigenteRepository;

    @Test
    public void obtenerParametrosMac() throws PlataformaBaseException {
        assertNotNull(parametrosMacService.obtenerParametrosMac());
    }

    @Test
    public void obtenerRatingVigente() throws PlataformaBaseException {
        when(obtenerRatingVigenteRepository.ejecutar(anyString())).thenReturn(ParametroMacFixture.getParametroMac2());
        assertNotNull(parametrosMacService.obtenerRatingVigente(anyString()));
    }
}