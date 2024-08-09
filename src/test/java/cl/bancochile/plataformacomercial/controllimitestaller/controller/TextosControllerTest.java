package cl.bancochile.plataformacomercial.controllimitestaller.controller;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.impl.PerfilUserImpl;
import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.MotivoNoRating;
import cl.bancochile.plataformacomercial.controllimitestaller.fixture.BitacoraFixture;
import cl.bancochile.plataformacomercial.controllimitestaller.service.TextosService;
import io.jsonwebtoken.lang.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TextosControllerTest {

    @InjectMocks
    private TextosController textosController;

    @Mock
    private TextosService textosService;

    @Test
    public void obtenerMotivosNoRating() throws PlataformaBaseException {
        when(textosService.obtenerMotivosNoRating()).thenReturn(new ArrayList<>());
        Assert.notNull(textosController.obtenerMotivosNoRating());
    }

    @Test(expected = Exception.class)
    public void obtenerMotivosNoRatingFail() throws PlataformaBaseException {
        when(textosService.obtenerMotivosNoRating()).thenThrow(Exception.class);
        textosController.obtenerMotivosNoRating();
    }

    @Test
    public void agregarMotivosNoRating() throws PlataformaBaseException {
        doNothing().when(textosService).agregarMotivosNoRating(any(MotivoNoRating.class), any(PerfilUser.class));
        textosController.agregarMotivosNoRating(new MotivoNoRating.Builder().build(), new PerfilUserImpl());
    }

    @Test
    public void actualizarMotivosNoRatingOrden() throws PlataformaBaseException {
        doNothing().when(textosService).actualizarOrden(any(ArrayList.class));
        textosController.actualizarOrden(new ArrayList<>());
    }

    @Test(expected = Exception.class)
    public void actualizarMotivosNoRatingOrdenFail() throws PlataformaBaseException {
        doThrow(new Exception()).when(textosService).actualizarOrden(any(ArrayList.class));
        textosController.actualizarOrden(new ArrayList<>());
    }

    @Test
    public void actualizarMotivosNoRating() throws PlataformaBaseException {
        doNothing().when(textosService).actualizarMotivo(any(MotivoNoRating.class), any(PerfilUser.class));
        textosController.actualizarMotivo(new MotivoNoRating.Builder().build(), new PerfilUserImpl());
    }

    @Test(expected = Exception.class)
    public void actualizarMotivosNoRatingFail() throws PlataformaBaseException {
        doThrow(new Exception()).when(textosService).actualizarMotivo(any(MotivoNoRating.class), any(PerfilUser.class));
        textosController.actualizarMotivo(new MotivoNoRating(), new PerfilUserImpl());
    }

    @Test
    public void eliminarMotivosNoReting()throws PlataformaBaseException {
        doNothing().when(textosService).eliminar(anyLong());
        textosController.eliminar(1L);
    }

    @Test(expected = Exception.class)
    public void eliminarMotivosNoRetingFail()throws PlataformaBaseException {
        doThrow(new Exception()).when(textosService).eliminar(anyLong());
        textosController.eliminar(1L);
    }

    @Test
    public void obtenerMotivoNoRatingBitacora()throws PlataformaBaseException {
        when(textosService.obtenerMotivoNoRatingBitacora(anyLong())).thenReturn(BitacoraFixture.getMotivosNoRatingBitacora());
        textosController.obtenerMotivoNoRatingBitacora(1L);
    }

}
