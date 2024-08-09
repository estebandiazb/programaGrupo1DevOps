package cl.bancochile.plataformacomercial.controllimitestaller.service.impl;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ReasignarLimiteRequest;
import cl.bancochile.plataformacomercial.controllimitestaller.fixture.FamiliaLimiteFixture;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.CrearFamiliaLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarFamiliaLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ModificarFamiliaLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerTipoLimitePorIdFamiliaRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ReasignarFamiliaLimiteRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.FamiliaLimite;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.TipoLimiteVersion;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.repository.ObtenerFamiliaLimiteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.internal.util.Assert;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FamiliaLimiteServiceImplTest {

    @InjectMocks
    private FamiliaLimiteServiceImpl service;
    @Mock
    private CrearFamiliaLimiteRepository crearFamiliaLimiteRepository;
    @Mock
    private ModificarFamiliaLimiteRepository modificarFamiliaLimiteRepository;
    @Mock
    private ObtenerFamiliaLimiteRepository obtenerFamiliasLimitesRepository;
    @Mock
    private ObtenerTipoLimitePorIdFamiliaRepository obtenerTipoLimitePorIdFamiliaRepository;
    @Mock
    private EliminarFamiliaLimiteRepository eliminarFamiliaLimiteRepository;
    @Mock
    private ReasignarFamiliaLimiteRepository reasignarFamiliaLimiteRepository;
    @Mock
    private PerfilUser perfilUser;

    @Test
    public void crear() throws PlataformaBaseException {
        assertNotNull(service.crear(FamiliaLimiteFixture.getFamiliaLimite("test"), perfilUser));
    }

    @Test(expected = PlataformaBaseException.class)
    public void crearNOK1() throws PlataformaBaseException {
        assertNotNull(service.crear(FamiliaLimiteFixture.getFamiliaLimite("test"), null));
    }

    @Test(expected = PlataformaBaseException.class)
    public void crearNOK2() throws PlataformaBaseException {
        assertNotNull(service.crear(null, perfilUser));
    }

    @Test(expected = PlataformaBaseException.class)
    public void crearNOK3() throws PlataformaBaseException {
        assertNotNull(service.crear(new FamiliaLimite(), perfilUser));
    }

    @Test
    public void guardar() throws PlataformaBaseException {
        service.guardar(FamiliaLimiteFixture.getFamiliaLimite("Familia 1"), perfilUser);
    }

    @Test
    public void eliminar() throws PlataformaBaseException {
        service.eliminar(1L, perfilUser);
    }

    @Test(expected = PlataformaBaseException.class)
    public void eliminarNOK1() throws PlataformaBaseException {
        service.eliminar(1L, null);
    }

    @Test(expected = PlataformaBaseException.class)
    public void eliminarNOK2() throws PlataformaBaseException {
        service.eliminar(0L, perfilUser);
    }

    @Test(expected = PlataformaBaseException.class)
    public void eliminarNOK3() throws PlataformaBaseException {
        service.eliminar(null, perfilUser);
    }

    @Test
    public void reasignar() throws PlataformaBaseException {
        service.reasignar(new ReasignarLimiteRequest(), perfilUser);
    }

    @Test
    public void obtenerFamiliasLimites() throws PlataformaBaseException {
        when(obtenerFamiliasLimitesRepository.ejecutar(anyLong()))
                .thenReturn(new ArrayList<FamiliaLimite>());
        Assert.notNull(service.obtenerFamiliaLimite(1L));
    }

    @Test
    public void obtenerFamiliaLimitePorId() throws PlataformaBaseException {
        when(obtenerFamiliasLimitesRepository.ejecutar(anyLong()))
                .thenReturn(new ArrayList<FamiliaLimite>())
                .thenReturn(FamiliaLimiteFixture.getFamiliasLimites())
        ;
        when(obtenerTipoLimitePorIdFamiliaRepository.ejecutar(anyLong()))
                .thenReturn(new ArrayList<TipoLimiteVersion>());

        Assert.notNull(service.obtenerFamiliaLimitePorId(1L));
        Assert.notNull(service.obtenerFamiliaLimitePorId(2L));
    }

}
