package cl.bancochile.plataformacomercial.controllimitestaller.controller;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.service.MonedaBancoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static cl.bancochile.plataformacomercial.controllimitestaller.fixture.MonedaFixture.getMonedasBanco;
import static cl.bancochile.plataformacomercial.controllimitestaller.fixture.MonedaFixture.getValorMonedaBanco;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MonedasControllerTest {

    @InjectMocks
    private MonedasController controller;

    @Mock
    private MonedaBancoService monedaBancoService;

    @Mock
    private PerfilUser perfilUser;

    @Test
    public void obtencionMonedas() throws PlataformaBaseException {
        when(monedaBancoService.obtencionMonedas()).thenReturn(getMonedasBanco());
        assertNotNull(controller.obtencionMonedas());
    }

    @Test
    public void obtencionMonedasSgt() throws PlataformaBaseException {
        when(monedaBancoService.obtencionMonedasSgt()).thenReturn(getMonedasBanco());
        assertNotNull(controller.obtencionMonedasSgt());
    }

    @Test
    public void eliminacionMoneda() throws PlataformaBaseException {
        controller.eliminacionMoneda(1L, perfilUser);
    }

    @Test
    public void guardarMonedas() throws PlataformaBaseException {
        controller.guardarMonedas(getMonedasBanco(), perfilUser);
    }

    @Test
    public void guardarValorMoneda() throws PlataformaBaseException {
        controller.guardarValorMoneda(getValorMonedaBanco(11), perfilUser);
    }
}