package cl.bancochile.plataformacomercial.controllimitestaller.controller;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Variable;
import cl.bancochile.plataformacomercial.controllimitestaller.service.SubTipoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SubTipoControllerTest {

    @InjectMocks
    private SubTipoController controller;

    @Mock
    private SubTipoService subTipoService;

    @Test
    public void creacionFamiliaSubtipos() throws PlataformaBaseException {
        when(subTipoService.crearFamiliaSubtipo(anyString())).thenReturn(new Variable());
        controller.creacionFamiliaSubtipos(new Variable.Builder()
                .build());
    }

    @Test
    public void guardarSubtipos() throws PlataformaBaseException {
        controller.guardarSubtipos(new Variable.Builder().build());
    }

    @Test
    public void testObtieneFamiliaSubtipos() throws Exception {
        when(subTipoService.obtenerFamiliasSubtipo())
                .thenReturn(new ArrayList<Variable>());
        assertNotNull(controller.obtieneFamiliaSubtipos());
    }

    @Test
    public void testObtieneSubtiposPorId() throws Exception {
        when(subTipoService.obtenerItemPorId(anyLong()))
                .thenReturn(new ArrayList<ItemVariable>());
        assertNotNull(controller.obtieneSubtiposPorId(1L));
    }

    @Test
    public void testEliminaFamiliaSubtipo() throws Exception {
        doNothing().when(subTipoService).eliminaFamiliaSubtipo(anyLong());
        controller.eliminaFamiliaSubtipo(1L);
    }
}