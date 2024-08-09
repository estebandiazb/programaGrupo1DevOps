package cl.bancochile.plataformacomercial.controllimitestaller.controller;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.impl.PerfilUserImpl;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ParametroMac;
import cl.bancochile.plataformacomercial.controllimitestaller.service.ParametrosMacService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static cl.bancochile.plataformacomercial.controllimitestaller.fixture.ParametroMacFixture.getParametroMac;
import static cl.bancochile.plataformacomercial.controllimitestaller.fixture.ParametroMacFixture.getParametroMac2;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ParametrosMacControllerTest {

    @InjectMocks
    private ParametrosMacController parametrosMacController;

    @Mock
    private ParametrosMacService parametrosMacService;

    @Test
    public void obtenerParametrosMac() throws PlataformaBaseException {
        when(parametrosMacService.obtenerParametrosMac()).thenReturn(getParametroMac());
        assertNotNull(parametrosMacController.obtenerParametrosMac());
    }

    @Test
    public void obtenerRatingVigente() throws PlataformaBaseException {
        when(parametrosMacService.obtenerRatingVigente(anyString())).thenReturn(getParametroMac2());
        assertNotNull(parametrosMacController.obtenerRatingVigente(anyString()));
    }

    @Test
    public void actualizaRatingVigente() throws PlataformaBaseException {
        parametrosMacController.actualizaRatingVigente(new ParametroMac.Builder().build(), new PerfilUserImpl());
    }
}