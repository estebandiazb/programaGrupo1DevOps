package cl.bancochile.plataformacomercial.controllimitestaller.controller;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ConsultarFiltrosTipoLimitesResponse;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ConsultarTipoLimitesRequest;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ConsultarTipoLimitesResponse;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.CrearTipoLimiteRequest;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimiteFull;
import cl.bancochile.plataformacomercial.controllimitestaller.service.TipoLimiteService;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.TipoLimiteVersion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TipoLimitesControllerTest {

    @InjectMocks
    private TipoLimitesController controller;

    @Mock
    private TipoLimiteService tipoLimiteService;

    @Mock
    private PerfilUser perfilUser;

    @Test
    public void consultarFiltros() throws Exception {
        when(tipoLimiteService.consultarFiltroTipoLimites())
                .thenReturn(new ConsultarFiltrosTipoLimitesResponse());
        assertNotNull(controller.consultarFiltros());
    }

    @Test
    public void consultarTipoLimites() throws Exception {
        when(tipoLimiteService.consultarTipoLimites(any(ConsultarTipoLimitesRequest.class)))
                .thenReturn(new ConsultarTipoLimitesResponse());
        assertNotNull(controller.consultarTipoLimites(new ConsultarTipoLimitesRequest()));
    }

    @Test
    public void consultarConfiguracionNuevoTipoLimite() throws Exception {
        when(tipoLimiteService.obtenerConfiguracionNuevoTipoLimite(any(CrearTipoLimiteRequest.class)))
                .thenReturn(new TipoLimiteFull());
        assertNotNull(controller.obtenerTipoLimiteNuevo(new CrearTipoLimiteRequest()));
    }

    @Test
    public void consultarConfiguracionVersionTipoLimite() throws Exception {
        when(tipoLimiteService.obtenerConfiguracionVersionTipoLimite(anyLong()))
                .thenReturn(new TipoLimiteFull());
        assertNotNull(controller.obtenerConfiguracionTipoLimite(1L));
    }

    @Test
    public void consultarAtributosBasicos() throws Exception {
        when(tipoLimiteService.obtenerAtributosTipoLimite(anyLong()))
                .thenReturn(new ArrayList<>());
        assertNotNull(controller.obtenerAtributos());
    }

    @Test
    public void guardarTipoLimite() throws Exception {
        when(tipoLimiteService.guardarConfiguracion(any(TipoLimiteFull.class), anyString()))
                .thenReturn(1L);
        assertNotNull(controller.guardarTipoLimite(new TipoLimiteFull(), perfilUser));
    }

    @Test
    public void copiaTipoLimite() throws Exception {
        when(tipoLimiteService.copiaTipoLimite(any(TipoLimiteFull.class), anyString()))
                .thenReturn(1L);
        assertNotNull(controller.copiaTipoLimite(new TipoLimiteFull(), perfilUser));
    }

    @Test
    public void activaDesactivaTipoLimite() throws Exception {
        when(tipoLimiteService.actualizaEstadoTipoLimite(any(TipoLimiteVersion.class)))
                .thenReturn(new TipoLimiteVersion());
        assertNotNull(controller.activaDesactivaTipoLimite(new TipoLimiteVersion(), perfilUser));
    }

    @Test
    public void eliminarTipoLimite() throws Exception {
        doNothing().when(tipoLimiteService).eliminarTipoLimite(anyLong());

        controller.eliminarTipoLimite(1L);
    }

}