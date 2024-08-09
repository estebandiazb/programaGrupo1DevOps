package cl.bancochile.plataformacomercial.controllimitestaller.service.impl;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.MonedaBanco;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ValorMonedaBanco;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarMonedaRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.GuardarMonedaRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.GuardarValorMonedaRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerMonedaRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerMonedasRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerValorMonedaRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.api.sgt.domains.SgtMoneda;
import cl.bancochile.plataformacomercial.lib.controllimites.api.sgt.services.ApiSgtService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static cl.bancochile.plataformacomercial.controllimitestaller.fixture.MonedaFixture.getMonedaBanco;
import static cl.bancochile.plataformacomercial.controllimitestaller.fixture.MonedaFixture.getMonedasBanco;
import static cl.bancochile.plataformacomercial.controllimitestaller.fixture.MonedaFixture.getMonedasBancoEmpty;
import static cl.bancochile.plataformacomercial.controllimitestaller.fixture.MonedaFixture.getValorMonedaBanco;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MonedaBancoServiceImplTest {

    @InjectMocks
    private MonedaBancoServiceImpl monedaBancoService;

    @Mock
    private ObtenerMonedasRepository obtenerMonedasRepository;

    @Mock
    private ApiSgtService apiSgtService;

    @Mock
    private ObtenerValorMonedaRepository obtenerValorMonedaRepository;

    @Mock
    private GuardarMonedaRepository guardarMonedaRepository;

    @Mock
    private EliminarMonedaRepository eliminarMonedaRepository;

    @Mock
    private ObtenerMonedaRepository obtenerMonedaRepository;

    @Mock
    private GuardarValorMonedaRepository guardarValorMonedaRepository;

    @Mock
    private PerfilUser perfilUser;

    @Test
    public void obtencionMonedas() throws PlataformaBaseException {
        when(obtenerMonedasRepository.ejecutar())
                .thenReturn(getMonedasBanco())
                .thenReturn(getMonedasBancoEmpty());
        assertNotNull(monedaBancoService.obtencionMonedas());
        assertNotNull(monedaBancoService.obtencionMonedas());
    }

    @Test
    public void obtencionMonedasSgt() throws PlataformaBaseException {
        List<SgtMoneda> monedas = new ArrayList<>();
        monedas.add(new SgtMoneda.Builder()
                        .codigoBanco("1")
                        .codigo("CLP")
                        .nombre("PESOS")
                        .simbolo("CH$")
                .build());
        when(apiSgtService.getTablaMoneda()).thenReturn(monedas);
        assertNotNull(monedaBancoService.obtencionMonedasSgt());
    }

    @Test
    public void guardarMonedas() {
        assertNotNull(guardarMonedasExec(getMonedasBanco(), perfilUser));
        assertNull(guardarMonedasExec(getMonedasBancoEmpty(), perfilUser));
        assertNull(guardarMonedasExec(null, perfilUser));
        assertNull(guardarMonedasExec(getMonedasBanco(), null));
    }

    @Test
    public void eliminacionMoneda() {
        eliminarMonedaExec(0, perfilUser);
        eliminarMonedaExec(1, perfilUser);
        eliminarMonedaExec(1, null);
    }

    @Test
    public void guardarValorMoneda() throws PlataformaBaseException {
        guardarValorMonedaExec(getValorMonedaBanco(1), perfilUser);
        guardarValorMonedaExec(null, perfilUser);
        guardarValorMonedaExec(getValorMonedaBanco(1), null);
        guardarValorMonedaExec(getValorMonedaBanco(0), perfilUser);

        when(obtenerMonedaRepository.ejecutar(anyLong()))
                .thenReturn(getMonedaBanco("CLF", 98));
        guardarValorMonedaExec(getValorMonedaBanco(98), perfilUser);

        when(obtenerMonedaRepository.ejecutar(anyLong()))
                .thenReturn(getMonedaBanco("USD", 11));
        guardarValorMonedaExec(getValorMonedaBanco(11), perfilUser);

        when(obtenerValorMonedaRepository.ejecutar(anyString()))
                .thenReturn(getValorMonedaBanco(96, BigDecimal.ZERO));
        when(obtenerMonedaRepository.ejecutar(anyLong()))
                .thenReturn(getMonedaBanco("EUR", 96));
        guardarValorMonedaExec(getValorMonedaBanco(96), perfilUser);

        when(obtenerValorMonedaRepository.ejecutar(anyString()))
                .thenReturn(getValorMonedaBanco(96, BigDecimal.TEN));
        when(obtenerMonedaRepository.ejecutar(anyLong()))
                .thenReturn(getMonedaBanco("EUR", 96));
        guardarValorMonedaExec(getValorMonedaBanco(96), perfilUser);
    }

    private List<MonedaBanco> guardarMonedasExec(List<MonedaBanco> monedas, PerfilUser perfilUser) {
        try {
            return monedaBancoService.guardarMonedas(monedas, perfilUser);
        } catch (Exception ex) { // NOSONAR
            return null;
        }
    }

    private void eliminarMonedaExec(long idMoneda, PerfilUser perfilUser) {
        try {
            monedaBancoService.eliminacionMoneda(idMoneda, perfilUser);
        } catch (Exception ex) { // NOSONAR
        }
    }

    private ValorMonedaBanco guardarValorMonedaExec(ValorMonedaBanco valorMonedaBanco, PerfilUser perfilUser) {
        try {
            return monedaBancoService.guardarValorMoneda(valorMonedaBanco, perfilUser);
        } catch (Exception ex) { // NOSONAR
            return null;
        }
    }
}