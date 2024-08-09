package cl.bancochile.plataformacomercial.controllimitestaller.controller;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ReasignarLimiteRequest;
import cl.bancochile.plataformacomercial.controllimitestaller.service.FamiliaLimiteService;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.FamiliaLimite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FamiliaLimiteControllerTest {

    @InjectMocks
    private FamiliaLimiteController controller;

    @Mock
    private FamiliaLimiteService familiaLimiteService;

    @Mock
    PerfilUser perfilUser;

    @Test
    public void guardar() throws PlataformaBaseException {
        controller.modificar(new FamiliaLimite(), perfilUser);
    }

    @Test
    public void reasignar() throws PlataformaBaseException {
        controller.reasignar(new ReasignarLimiteRequest(), perfilUser);
    }

    @Test
    public void testObtenerFamiliasLimites() throws Exception {
        when(familiaLimiteService.obtenerFamiliaLimite(anyLong()))
                .thenReturn(new ArrayList<FamiliaLimite>());
        assertNotNull(controller.obtieneFamiliasLimites());
    }

    @Test
    public void testObtenerTipoLimitePorId() throws Exception {
        when(familiaLimiteService.obtenerFamiliaLimitePorId(anyLong()))
                .thenReturn(new FamiliaLimite());
        assertNotNull(controller.obtieneFamiliaLimitePorId(1L));
    }

    @Test
    public void crear() throws PlataformaBaseException {
        when(familiaLimiteService.crear(any(FamiliaLimite.class), any(PerfilUser.class))).thenReturn(new FamiliaLimite());
        assertNotNull(controller.crear(new FamiliaLimite(), perfilUser));
    }

    @Test
    public void eliminar() throws PlataformaBaseException {
        controller.eliminar(1L, perfilUser);
    }
}
