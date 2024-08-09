package cl.bancochile.plataformacomercial.controllimitestaller.service.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimiteFull;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ValidacionResponse;
import cl.bancochile.plataformacomercial.controllimitestaller.fixture.PerfilUserFixture;
import cl.bancochile.plataformacomercial.controllimitestaller.fixture.ValidacionFixture;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ActualizaEstadoTipoLimiteVersionRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerTipoLimitePorIdRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.service.TipoLimiteService;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.CategoriaAtributoEnum;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;
import javafx.util.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ValidacionServiceImplTest {

    @InjectMocks
    private ValidacionServiceImpl service;

    @Mock
    private TipoLimiteService tipoLimiteService;
    @Mock
    private ActualizaEstadoTipoLimiteVersionRepository repository;
    @Mock
    private ObtenerTipoLimitePorIdRepository obtenerTipoLimitePorIdRepository;

    @Test
    public void consultarFiltroTipoLimites() throws PlataformaBaseException {

        TipoLimiteFull request = new TipoLimiteFull.Builder()
                .atributos(ValidacionFixture.getAtributosValidacion("CriterioVencMaxCurse3",
                        false,
                        "Si",
                        "No",
                        Arrays.asList(new Pair("VC122", CategoriaAtributoEnum.AVANZADO),
                                new Pair("ML103", CategoriaAtributoEnum.BASICO),
                                new Pair("VL121", CategoriaAtributoEnum.BASICO),
                                new Pair("RE128", CategoriaAtributoEnum.BASICO),
                                new Pair("PL104", CategoriaAtributoEnum.BASICO),
                                new Pair("PO123", CategoriaAtributoEnum.BASICO),
                                new Pair("PM125", CategoriaAtributoEnum.BASICO),
                                new Pair("CP126", CategoriaAtributoEnum.BASICO),
                                new Pair("CU117", CategoriaAtributoEnum.BASICO)
                        )))
                .build();

        when(tipoLimiteService.guardarConfiguracion(any(TipoLimiteFull.class), anyString())).thenReturn(1L);
        doNothing().when(repository).ejecutar(anyLong(), any(EstadoTipoLimiteEnum.class), anyString());
        when(obtenerTipoLimitePorIdRepository.ejecutar(anyLong())).thenReturn(new TipoLimiteFull());


        ValidacionResponse response = service.validacion(request, PerfilUserFixture.getPerfilUser());

        assertNotNull(response);
    }

    @Test
    public void consultarFiltroTipoLimites2() throws PlataformaBaseException {

        TipoLimiteFull request = new TipoLimiteFull.Builder()
                .atributos(ValidacionFixture.getAtributosValidacion("CriterioVencMaxCurse1",
                        true,
                        "Si",
                        "Si",
                        Arrays.asList(new Pair("VC122", CategoriaAtributoEnum.AVANZADO),
                                new Pair("ML103", CategoriaAtributoEnum.BASICO),
                                new Pair("VL121", CategoriaAtributoEnum.BASICO),
                                new Pair("RE128", CategoriaAtributoEnum.BASICO),
                                new Pair("PL104", CategoriaAtributoEnum.BASICO),
                                new Pair("PO123", CategoriaAtributoEnum.BASICO),
                                new Pair("PM125", CategoriaAtributoEnum.BASICO),
                                new Pair("CP126", CategoriaAtributoEnum.BASICO),
                                new Pair("CU117", CategoriaAtributoEnum.BASICO)
                        )))
                .build();

        when(tipoLimiteService.guardarConfiguracion(any(TipoLimiteFull.class), anyString())).thenReturn(1L);
        doNothing().when(repository).ejecutar(anyLong(), any(EstadoTipoLimiteEnum.class), anyString());
        when(obtenerTipoLimitePorIdRepository.ejecutar(anyLong())).thenReturn(new TipoLimiteFull());

        ValidacionResponse response = service.validacion(request, PerfilUserFixture.getPerfilUser());

        assertNotNull(response);
    }

    @Test
    public void consultarFiltroTipoLimites3() throws PlataformaBaseException {

        TipoLimiteFull request = new TipoLimiteFull.Builder()
                .atributos(ValidacionFixture.getAtributosValidacion("CriterioVencMaxCurse2",
                        true,
                        "Si",
                        "No",
                        Arrays.asList(new Pair("VC122", CategoriaAtributoEnum.AVANZADO),
                                new Pair("ML103", CategoriaAtributoEnum.BASICO),
                                new Pair("VL121", CategoriaAtributoEnum.BASICO),
                                new Pair("RE128", CategoriaAtributoEnum.BASICO),
                                new Pair("PL104", CategoriaAtributoEnum.BASICO),
                                new Pair("PO123", CategoriaAtributoEnum.BASICO),
                                new Pair("PM125", CategoriaAtributoEnum.BASICO),
                                new Pair("CP126", CategoriaAtributoEnum.BASICO),
                                new Pair("CU117", CategoriaAtributoEnum.BASICO)
                        )))
                .build();

        when(tipoLimiteService.guardarConfiguracion(any(TipoLimiteFull.class), anyString())).thenReturn(1L);
        doNothing().when(repository).ejecutar(anyLong(), any(EstadoTipoLimiteEnum.class), anyString());
        when(obtenerTipoLimitePorIdRepository.ejecutar(anyLong())).thenReturn(new TipoLimiteFull());

        ValidacionResponse response = service.validacion(request, PerfilUserFixture.getPerfilUser());

        assertNotNull(response);
    }

    @Test
    public void consultarFiltroTipoLimites4() throws PlataformaBaseException {

        TipoLimiteFull request = new TipoLimiteFull.Builder()
                .atributos(ValidacionFixture.getAtributosValidacion("CriterioVencMaxCurse4",
                        true,
                        "No",
                        "No",
                        Arrays.asList(new Pair("VC122", CategoriaAtributoEnum.AVANZADO),
                                new Pair("ML103", CategoriaAtributoEnum.BASICO),
                                new Pair("VL121", CategoriaAtributoEnum.BASICO),
                                new Pair("RE128", CategoriaAtributoEnum.BASICO),
                                new Pair("PL104", CategoriaAtributoEnum.BASICO),
                                new Pair("PO123", CategoriaAtributoEnum.BASICO),
                                new Pair("PM125", CategoriaAtributoEnum.BASICO),
                                new Pair("CP126", CategoriaAtributoEnum.BASICO),
                                new Pair("CU117", CategoriaAtributoEnum.BASICO)
                        )))
                .build();

        when(tipoLimiteService.guardarConfiguracion(any(TipoLimiteFull.class), anyString())).thenReturn(1L);
        doNothing().when(repository).ejecutar(anyLong(), any(EstadoTipoLimiteEnum.class), anyString());
        when(obtenerTipoLimitePorIdRepository.ejecutar(anyLong())).thenReturn(new TipoLimiteFull());

        ValidacionResponse response = service.validacion(request, PerfilUserFixture.getPerfilUser());

        assertNotNull(response);
    }

    @Test
    public void consultarFiltroTipoLimites5() throws PlataformaBaseException {

        TipoLimiteFull request = new TipoLimiteFull.Builder()
                .atributos(ValidacionFixture.getAtributosValidacion("CriterioVencMaxCurse5",
                        true,
                        "No",
                        "Si",
                        Arrays.asList(new Pair("VC122", CategoriaAtributoEnum.AVANZADO),
                                new Pair("ML103", CategoriaAtributoEnum.BASICO),
                                new Pair("VL121", CategoriaAtributoEnum.BASICO),
                                new Pair("RE128", CategoriaAtributoEnum.BASICO),
                                new Pair("PL104", CategoriaAtributoEnum.BASICO),
                                new Pair("PO123", CategoriaAtributoEnum.BASICO),
                                new Pair("PM125", CategoriaAtributoEnum.BASICO),
                                new Pair("CP126", CategoriaAtributoEnum.BASICO),
                                new Pair("CU117", CategoriaAtributoEnum.BASICO)
                        )))
                .build();

        when(tipoLimiteService.guardarConfiguracion(any(TipoLimiteFull.class), anyString())).thenReturn(1L);
        doNothing().when(repository).ejecutar(anyLong(), any(EstadoTipoLimiteEnum.class), anyString());
        when(obtenerTipoLimitePorIdRepository.ejecutar(anyLong())).thenReturn(new TipoLimiteFull());

        ValidacionResponse response = service.validacion(request, PerfilUserFixture.getPerfilUser());

        assertNotNull(response);
    }

    @Test
    public void consultarFiltroTipoLimites6() throws PlataformaBaseException {

        TipoLimiteFull request = new TipoLimiteFull.Builder()
                .atributos(ValidacionFixture.getAtributosValidacion("CriterioVencMaxCurse7",
                        false,
                        "",
                        "",
                        Arrays.asList(new Pair("VC122", CategoriaAtributoEnum.AVANZADO),
                                new Pair("ML103", CategoriaAtributoEnum.BASICO),
                                new Pair("VL121", CategoriaAtributoEnum.BASICO),
                                new Pair("RE128", CategoriaAtributoEnum.BASICO),
                                new Pair("PL104", CategoriaAtributoEnum.BASICO),
                                new Pair("PO123", CategoriaAtributoEnum.BASICO),
                                new Pair("PM125", CategoriaAtributoEnum.BASICO),
                                new Pair("CP126", CategoriaAtributoEnum.BASICO),
                                new Pair("CU117", CategoriaAtributoEnum.BASICO)
                        )))
                .build();

        when(tipoLimiteService.guardarConfiguracion(any(TipoLimiteFull.class), anyString())).thenReturn(1L);
        doNothing().when(repository).ejecutar(anyLong(), any(EstadoTipoLimiteEnum.class), anyString());
        when(obtenerTipoLimitePorIdRepository.ejecutar(anyLong())).thenReturn(new TipoLimiteFull());

        ValidacionResponse response = service.validacion(request, PerfilUserFixture.getPerfilUser());

        assertNotNull(response);
    }

    @Test
    public void validacionVencimientoMaxCurseCriterio1OK() throws PlataformaBaseException {

        TipoLimiteFull request = new TipoLimiteFull.Builder()
                .atributos(ValidacionFixture
                        .getAtributosValidacion("CriterioVencMaxCurse1",
                                true,
                                "",
                                "",
                                Arrays.asList(new Pair("VC122", CategoriaAtributoEnum.AVANZADO),
                                        new Pair("ML103", CategoriaAtributoEnum.BASICO),
                                        new Pair("VL121", CategoriaAtributoEnum.BASICO),
                                        new Pair("RE128", CategoriaAtributoEnum.BASICO),
                                        new Pair("PO123", CategoriaAtributoEnum.BASICO),
                                        new Pair("PM125", CategoriaAtributoEnum.BASICO),
                                        new Pair("CP126", CategoriaAtributoEnum.BASICO),
                                        new Pair("CU117", CategoriaAtributoEnum.BASICO)
                                )))
                .build();

        when(tipoLimiteService.guardarConfiguracion(any(TipoLimiteFull.class), anyString())).thenReturn(1L);
        doNothing().when(repository).ejecutar(anyLong(), any(EstadoTipoLimiteEnum.class), anyString());
        when(obtenerTipoLimitePorIdRepository.ejecutar(anyLong())).thenReturn(new TipoLimiteFull());

        ValidacionResponse response = service.validacion(request, PerfilUserFixture.getPerfilUser());

        assertNotNull(response);
    }

    @Test
    public void validacionVencimientoMaxCurseCriterio3OK() throws PlataformaBaseException {

        TipoLimiteFull request = new TipoLimiteFull.Builder()
                .atributos(ValidacionFixture
                        .getAtributosValidacion("CriterioVencMaxCurse3",
                                true,
                                "",
                                "",
                                Arrays.asList(new Pair("VC122", CategoriaAtributoEnum.AVANZADO),
                                        new Pair("ML103", CategoriaAtributoEnum.BASICO),
                                        new Pair("VL121", CategoriaAtributoEnum.BASICO),
                                        new Pair("RE128", CategoriaAtributoEnum.BASICO),
                                        new Pair("PO123", CategoriaAtributoEnum.BASICO),
                                        new Pair("PM125", CategoriaAtributoEnum.BASICO),
                                        new Pair("CP126", CategoriaAtributoEnum.BASICO),
                                        new Pair("CU117", CategoriaAtributoEnum.BASICO)
                                )))
                .build();

        when(tipoLimiteService.guardarConfiguracion(any(TipoLimiteFull.class), anyString())).thenReturn(1L);
        doNothing().when(repository).ejecutar(anyLong(), any(EstadoTipoLimiteEnum.class), anyString());
        when(obtenerTipoLimitePorIdRepository.ejecutar(anyLong())).thenReturn(new TipoLimiteFull());

        ValidacionResponse response = service.validacion(request, PerfilUserFixture.getPerfilUser());

        assertNotNull(response);
    }

    @Test
    public void validacionVencimientoMaxCurseCriterio2OK() throws PlataformaBaseException {

        TipoLimiteFull request = new TipoLimiteFull.Builder()
                .atributos(ValidacionFixture
                        .getAtributosValidacion("CriterioVencMaxCurse2",
                                true,
                                "",
                                "",
                                Arrays.asList(new Pair("VC122", CategoriaAtributoEnum.AVANZADO),
                                        new Pair("ML103", CategoriaAtributoEnum.BASICO),
                                        new Pair("VL121", CategoriaAtributoEnum.BASICO),
                                        new Pair("RE128", CategoriaAtributoEnum.BASICO),
                                        new Pair("PL104", CategoriaAtributoEnum.BASICO),
                                        new Pair("PM125", CategoriaAtributoEnum.BASICO),
                                        new Pair("CP126", CategoriaAtributoEnum.BASICO),
                                        new Pair("CU117", CategoriaAtributoEnum.BASICO)
                                )))
                .build();

        when(tipoLimiteService.guardarConfiguracion(any(TipoLimiteFull.class), anyString())).thenReturn(1L);
        doNothing().when(repository).ejecutar(anyLong(), any(EstadoTipoLimiteEnum.class), anyString());
        when(obtenerTipoLimitePorIdRepository.ejecutar(anyLong())).thenReturn(new TipoLimiteFull());

        ValidacionResponse response = service.validacion(request, PerfilUserFixture.getPerfilUser());

        assertNotNull(response);
    }

    @Test
    public void validacionVencimientoMaxCurseCriterio4OK() throws PlataformaBaseException {

        TipoLimiteFull request = new TipoLimiteFull.Builder()
                .atributos(ValidacionFixture
                        .getAtributosValidacion("CriterioVencMaxCurse4",
                                true,
                                "",
                                "Si",
                                Arrays.asList(new Pair("VC122", CategoriaAtributoEnum.AVANZADO),
                                        new Pair("ML103", CategoriaAtributoEnum.BASICO),
                                        new Pair("VL121", CategoriaAtributoEnum.BASICO),
                                        new Pair("RE128", CategoriaAtributoEnum.BASICO),
                                        new Pair("PL104", CategoriaAtributoEnum.BASICO),
                                        new Pair("PM125", CategoriaAtributoEnum.BASICO),
                                        new Pair("CP126", CategoriaAtributoEnum.BASICO),
                                        new Pair("CU117", CategoriaAtributoEnum.BASICO)
                                )))
                .build();

        when(tipoLimiteService.guardarConfiguracion(any(TipoLimiteFull.class), anyString())).thenReturn(1L);
        doNothing().when(repository).ejecutar(anyLong(), any(EstadoTipoLimiteEnum.class), anyString());
        when(obtenerTipoLimitePorIdRepository.ejecutar(anyLong())).thenReturn(new TipoLimiteFull());

        ValidacionResponse response = service.validacion(request, PerfilUserFixture.getPerfilUser());

        assertNotNull(response);
    }




}