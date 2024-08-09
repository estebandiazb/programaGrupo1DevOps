package cl.bancochile.plataformacomercial.controllimitestaller.service.impl;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.impl.PerfilUserImpl;
import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.MotivoNoRating;
import cl.bancochile.plataformacomercial.controllimitestaller.fixture.BitacoraFixture;
import cl.bancochile.plataformacomercial.controllimitestaller.fixture.MotivoNoRatingFixture;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ActualizarMotivoNoRatingRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.AgregarMotivoNoRatingRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarMotivoNoRatingRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerMotivosNoRatingRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.common.domain.Bitacora;
import cl.bancochile.plataformacomercial.lib.controllimites.common.repository.CrearRegistroBitacoraCommonRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.common.repository.ObtenerRegistroBitacoraCommonRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TextosServiceImplTest {

    @InjectMocks
    private TextosServiceImpl textosService;
    @Mock
    private ObtenerMotivosNoRatingRepository obtenerMotivosNoRatingRepository;
    @Mock
    private AgregarMotivoNoRatingRepository agregarMotivoNoRatingRepository;
    @Mock
    private ActualizarMotivoNoRatingRepository actualizarMotivoNoRatingRepository;
    @Mock
    private EliminarMotivoNoRatingRepository eliminarMotivoNoRatingRepository;
    @Mock
    private CrearRegistroBitacoraCommonRepository crearRegistroBitacoraCommonRepository;
    @Mock
    private ObtenerRegistroBitacoraCommonRepository obtenerRegistroBitacoraCommonRepository;

    @Test
    public void obtenerMotivosNoRating() throws PlataformaBaseException {
        when(obtenerMotivosNoRatingRepository.ejecutar()).thenReturn(MotivoNoRatingFixture.getMotivosNoRating());
        List<MotivoNoRating> salida = textosService.obtenerMotivosNoRating();
        Assert.assertEquals(salida.size(), 2);
    }

    @Test(expected = Exception.class)
    public void obtenerMotivosNoRatingFail() throws PlataformaBaseException {
        when(obtenerMotivosNoRatingRepository.ejecutar()).thenThrow(Exception.class);
        textosService.obtenerMotivosNoRating();
    }

    @Test
    public void agregarMotivosNoRating() throws PlataformaBaseException {
        when(agregarMotivoNoRatingRepository.ejecutar(any(MotivoNoRating.class), any(PerfilUser.class))).thenReturn(1L);
        doNothing().when(crearRegistroBitacoraCommonRepository).crearRegistroBitacora(any(Bitacora.class));

        textosService.agregarMotivosNoRating(new MotivoNoRating(), new PerfilUserImpl());
    }

    @Test
    public void actualizarOrden() throws PlataformaBaseException {
        doNothing().when(actualizarMotivoNoRatingRepository).ejecutar(any(MotivoNoRating.class));
        textosService.actualizarOrden(MotivoNoRatingFixture.getMotivosNoRating());
    }

    @Test(expected = Exception.class)
    public void actualizarOrdenFail() throws PlataformaBaseException {
        doNothing().when(actualizarMotivoNoRatingRepository).ejecutar(any(MotivoNoRating.class));
        textosService.actualizarOrden(null);
    }

    @Test
    public void actualizarMotivo() throws PlataformaBaseException {
        when(actualizarMotivoNoRatingRepository.ejecutar(any(MotivoNoRating.class), anyString(), anyString())).thenReturn(1L);
        doNothing().when(crearRegistroBitacoraCommonRepository).crearRegistroBitacora(any(Bitacora.class));
        textosService.actualizarMotivo(new MotivoNoRating(), new PerfilUserImpl());
    }
    @Test
    public void eliminarMotivo()throws PlataformaBaseException {
        doNothing().when(eliminarMotivoNoRatingRepository).ejecutar(anyLong());
        textosService.eliminar(1L);
    }

    @Test(expected = Exception.class)
    public void eliminarMotivoFail()throws PlataformaBaseException {
        doThrow(Exception.class).when(eliminarMotivoNoRatingRepository).ejecutar(anyLong());
        textosService.eliminar(1L);
    }

    @Test
    public void obtenerBitacora() throws PlataformaBaseException {
        when(obtenerRegistroBitacoraCommonRepository.obtenerRegistroBitacora(any(Bitacora.class))).thenReturn(BitacoraFixture.getMotivosNoRatingBitacora());
        textosService.obtenerMotivoNoRatingBitacora(1L);
    }
}

