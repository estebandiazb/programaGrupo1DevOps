package cl.bancochile.plataformacomercial.controllimitestaller.service.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Atributo;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.CategoriaSeleccionable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ConsultarFiltrosTipoLimitesResponse;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ConsultarTipoLimitesRequest;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.CrearTipoLimiteRequest;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Filtro;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariableLimite;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimite;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimiteFull;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableAtributo;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableLimite;
import cl.bancochile.plataformacomercial.controllimitestaller.fixture.AtributoFixture;
import cl.bancochile.plataformacomercial.controllimitestaller.fixture.CategoriaSeleccionableFixture;
import cl.bancochile.plataformacomercial.controllimitestaller.fixture.ItemVariableFixture;
import cl.bancochile.plataformacomercial.controllimitestaller.fixture.TipoLimiteFixture;
import cl.bancochile.plataformacomercial.controllimitestaller.fixture.TipoLimiteFullFixture;
import cl.bancochile.plataformacomercial.controllimitestaller.fixture.VariableAtributoFixture;
import cl.bancochile.plataformacomercial.controllimitestaller.fixture.VariableLimiteFixture;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ActualizaEstadoTipoLimite2Repository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ActualizaEstadoTipoLimiteVersionRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ActualizarItemVariablesTipoLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ActualizarVariableTipoLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ActualizarVersionTipoLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.AgregarAtributoTipoLimiteVersionRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.AgregarItemVariablesTipoLimiteVersionRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.AgregarVariablesTipoLimiteVersionRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.CrearTipoLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.CrearTipoLimiteVersionRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EditarCategoriaTipoLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarAtributoTipoLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarTipoLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.EliminarVariableTipoLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerAtributosFiltroRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerAtributosTipoLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerCategoriasAtributosTipoLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerConfiguracionTipoLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerFamiliasLimitesFiltroRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerInfoNuevoTipoLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerItemsVariablesAtributosTipoLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerNombresTipoLimitesFiltroRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerResumenAtributosRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerSubtiposFiltroRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerTipoLimitePorIdRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerTipoLimitesRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerVariablesAtributosTipoLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerVersionActivaTipoLimiteRepository;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static cl.bancochile.plataformacomercial.controllimitestaller.fixture.FiltrosFixture.getFiltrosDesordenados;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TipoLimiteServiceImplTest {

    @InjectMocks
    private TipoLimiteServiceImpl service;

    @Mock
    private ObtenerAtributosFiltroRepository obtenerAtributosFiltroRepository;
    @Mock
    private ObtenerFamiliasLimitesFiltroRepository obtenerFamiliasLimitesFiltroRepository;
    @Mock
    private ObtenerNombresTipoLimitesFiltroRepository obtenerNombresTipoLimitesFiltroRepository;
    @Mock
    private ObtenerSubtiposFiltroRepository obtenerSubtiposFiltroRepository;
    @Mock
    private ObtenerTipoLimitesRepository obtenerTipoLimitesRepository;
    @Mock
    private ObtenerResumenAtributosRepository obtenerResumenAtributosRepository;
    @Mock
    private CrearTipoLimiteRepository crearTipoLimiteRepository;
    @Mock
    private CrearTipoLimiteVersionRepository crearTipoLimiteVersionRepository;
    @Mock
    private ObtenerInfoNuevoTipoLimiteRepository obtenerInfoNuevoTipoLimiteRepository;
    @Mock
    private ObtenerAtributosTipoLimiteRepository obtenerAtributosTipoLimiteRepository;
    @Mock
    private ObtenerVariablesAtributosTipoLimiteRepository obtenerVariablesTipoLimiteRepository;
    @Mock
    private ObtenerItemsVariablesAtributosTipoLimiteRepository obtenerItemsVariablesTipoLimiteRepository;
    @Mock
    private ObtenerCategoriasAtributosTipoLimiteRepository obtenerCategoriasAtributosTipoLimiteRepository;
    @Mock
    private ObtenerConfiguracionTipoLimiteRepository obtenerConfiguracionTipoLimiteRepository;
    @Mock
    private EliminarAtributoTipoLimiteRepository eliminarAtributoTipoLimiteRepository;
    @Mock
    private EditarCategoriaTipoLimiteRepository editarCategoriaTipoLimiteRepository;
    @Mock
    private EliminarVariableTipoLimiteRepository eliminarVariableTipoLimiteRepository;
    @Mock
    private ActualizarVariableTipoLimiteRepository actualizarVariableTipoLimiteRepository;
    @Mock
    private ActualizarItemVariablesTipoLimiteRepository actualizarItemVariablesTipoLimiteRepository;
    @Mock
    private ObtenerTipoLimitePorIdRepository obtenerTipoLimitePorIdRepository;
    @Mock
    private AgregarAtributoTipoLimiteVersionRepository agregarAtributoTipoLimiteVersionRepository;
    @Mock
    private AgregarVariablesTipoLimiteVersionRepository agregarVariablesTipoLimiteVersionRepository;
    @Mock
    private AgregarItemVariablesTipoLimiteVersionRepository agregarItemVariablesTipoLimiteVersionRepository;
    @Mock
    private ActualizarVersionTipoLimiteRepository actualizarVersionTipoLimiteRepository;
    @Mock
    private ActualizaEstadoTipoLimiteVersionRepository actualizaEstadoTipoLimiteVersionRepository;
    @Mock
    private ActualizaEstadoTipoLimite2Repository actualizaEstadoTipoLimite2Repository;
    @Mock
    private ObtenerVersionActivaTipoLimiteRepository obtenerVersionActivaTipoLimiteRepository;
    @Mock
    private EliminarTipoLimiteRepository eliminarTipoLimiteRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        when(obtenerTipoLimitesRepository.ejecutar(any(ConsultarTipoLimitesRequest.class)))
                .thenReturn(new ArrayList<>());
        doNothing()
                .when(eliminarTipoLimiteRepository)
                .ejecutar(anyLong());
        doNothing()
                .when(actualizaEstadoTipoLimite2Repository)
                .ejecutar(any(TipoLimite.class));
        doNothing()
                .when(actualizaEstadoTipoLimiteVersionRepository)
                .ejecutar(any(Long.class), any(EstadoTipoLimiteEnum.class), any(String.class));
    }



    @Test
    public void consultarFiltroTipoLimites() throws PlataformaBaseException {

        when(obtenerAtributosFiltroRepository.ejecutar())
                .thenReturn(getFiltrosDesordenados());
        when(obtenerFamiliasLimitesFiltroRepository.ejecutar())
                .thenReturn(getFiltrosDesordenados());
        when(obtenerNombresTipoLimitesFiltroRepository.ejecutar())
                .thenReturn(getFiltrosDesordenados());
        when(obtenerSubtiposFiltroRepository.ejecutar())
                .thenReturn(getFiltrosDesordenados());

        ConsultarFiltrosTipoLimitesResponse response = service.consultarFiltroTipoLimites();

        assertNotNull(response);

        List<Filtro> atributos = response.getAtributos();

        assertEquals(null, atributos.get(0).getNombre());
        assertEquals("A", atributos.get(1).getNombre());
        assertEquals("b", atributos.get(2).getNombre());
        assertEquals("C", atributos.get(3).getNombre());
        assertEquals("D", atributos.get(4).getNombre());
        assertEquals("E", atributos.get(5).getNombre());
    }

    @Test
    public void consultarTipoLimites() throws PlataformaBaseException {
        when(obtenerTipoLimitesRepository.ejecutar(any(ConsultarTipoLimitesRequest.class)))
                .thenReturn(new ArrayList<>())
                .thenReturn(TipoLimiteFixture.getTipoLimites());
        when(obtenerResumenAtributosRepository.ejecutar(anyLong())).thenReturn(TipoLimiteFixture.getResumenAtributos());
        assertNotNull(service.consultarTipoLimites(new ConsultarTipoLimitesRequest()));
        assertNotNull(service.consultarTipoLimites(new ConsultarTipoLimitesRequest()));
    }

    @Test
    public void crearNuevoTipoLimite() throws PlataformaBaseException {

        List<Atributo> atributos = AtributoFixture.getAtributos();

        when(crearTipoLimiteRepository.ejecutar(anyString()))
                .thenReturn(TipoLimiteFixture.getTipoLimite("Tipo limite 1", EstadoTipoLimiteEnum.BORRADOR));

        when(crearTipoLimiteVersionRepository.ejecutar(any(TipoLimiteFull.class)))
                .thenReturn(1L);
        when(obtenerInfoNuevoTipoLimiteRepository.ejecutar(anyLong(), anyString()))
                .thenReturn(2l);
        when(obtenerCategoriasAtributosTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(Arrays.asList(new CategoriaSeleccionable.Builder()
                        .idAtributo(atributos.get(0).getId())
                        .seleccionado(true)
                        .build()))
                .thenReturn(Arrays.asList(new CategoriaSeleccionable.Builder()
                        .idAtributo(100L)
                        .seleccionado(false)
                        .build()));

        List<VariableAtributo> variables = VariableAtributoFixture.getVariablesAtributos();
        List<ItemVariable> items = ItemVariableFixture.getItemsVariables();

        variables.get(0).setItems(items);
        atributos.get(0).setVariables(variables);

        TipoLimiteFull request = new TipoLimiteFull.Builder()
                .id(0L)
                .idTipoLimite(0L)
                .prefijo("AAAA")
                .familiaLimite(1)
                .codigo("AAAA0002")
                .atributos(atributos)
                .estado(EstadoTipoLimiteEnum.BORRADOR)
                .build();

        service.guardarConfiguracion(request, "usuario");

        verify(crearTipoLimiteRepository, times(1))
                .ejecutar(anyString());
        verify(crearTipoLimiteVersionRepository, times(1))
                .ejecutar(any(TipoLimiteFull.class));
        verify(agregarAtributoTipoLimiteVersionRepository, times(atributos.size()))
                .ejecutar(anyLong(), any(Atributo.class));
        verify(agregarVariablesTipoLimiteVersionRepository, times(variables.size()))
                .ejecutar(anyLong(), any(VariableAtributo.class));
    }

    @Test
    public void crearNuevaVersionTipoLimite() throws PlataformaBaseException {
        List<Atributo> atributos = AtributoFixture.getAtributos();

        when(crearTipoLimiteRepository.ejecutar(anyString()))
                .thenReturn(TipoLimiteFixture.getTipoLimite("Tipo limite 1", EstadoTipoLimiteEnum.BORRADOR));
        when(crearTipoLimiteVersionRepository.ejecutar(any(TipoLimiteFull.class)))
                .thenReturn(1L);
        when(obtenerInfoNuevoTipoLimiteRepository.ejecutar(anyLong(), anyString()))
                .thenReturn(2l);
        when(obtenerCategoriasAtributosTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(Arrays.asList(new CategoriaSeleccionable.Builder()
                        .idAtributo(atributos.get(0).getId())
                        .seleccionado(true)
                        .build()))
                .thenReturn(Arrays.asList(new CategoriaSeleccionable.Builder()
                        .idAtributo(100L)
                        .seleccionado(false)
                        .build()));

        TipoLimiteFull tipoLimiteFull = TipoLimiteFullFixture.getTipoLimiteFull(1l);
        tipoLimiteFull.setEstado(EstadoTipoLimiteEnum.ACTIVO);
        when(obtenerTipoLimitePorIdRepository.ejecutar(anyLong()))
                .thenReturn(tipoLimiteFull);

        List<VariableAtributo> variables = VariableAtributoFixture.getVariablesAtributos();
        List<ItemVariable> items = ItemVariableFixture.getItemsVariables();

        variables.get(0).setItems(items);
        atributos.get(0).setVariables(variables);
        atributos.get(0).setCategorias(CategoriaSeleccionableFixture.getCategorias());

        TipoLimiteFull request = new TipoLimiteFull.Builder()
                .id(1l)
                .idTipoLimite(1l)
                .prefijo("AAAA")
                .familiaLimite(1)
                .codigo("AAAA0002")
                .atributos(atributos)
                .estado(EstadoTipoLimiteEnum.ACTIVO)
                .build();

        service.guardarConfiguracion(request, "usuario");

        verify(crearTipoLimiteRepository, times(0))
                .ejecutar(anyString());
        verify(crearTipoLimiteVersionRepository, times(1))
                .ejecutar(any(TipoLimiteFull.class));
        verify(agregarAtributoTipoLimiteVersionRepository, times(atributos.size()))
                .ejecutar(anyLong(), any(Atributo.class));
        verify(agregarVariablesTipoLimiteVersionRepository, times(variables.size()))
                .ejecutar(anyLong(), any(VariableAtributo.class));
    }

    @Test
    public void consultarNuevoTipoLimite() throws PlataformaBaseException {
        when(obtenerInfoNuevoTipoLimiteRepository.ejecutar(anyLong(), anyString()))
                .thenReturn(1L);
        when(obtenerAtributosTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(AtributoFixture.getAtributos());
        when(obtenerVariablesTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(VariableAtributoFixture.getVariablesAtributos());
        when(obtenerItemsVariablesTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(ItemVariableFixture.getItemsVariables());

        CrearTipoLimiteRequest request = new CrearTipoLimiteRequest();
        request.setIdFamiliaLimite(1);
        request.setPrefijo("AAAA");
        TipoLimiteFull tipoLimite = service.obtenerConfiguracionNuevoTipoLimite(request);

        assertEquals("AAAA0001", tipoLimite.getCodigo());
        assertEquals(2, tipoLimite.getAtributos().get(0).getVariables().size());
        assertEquals(1, tipoLimite.getAtributos().get(1).getVariables().size());
    }

    @Test
    public void editarConfiguracionTipoLimite() throws Exception {
        when(obtenerConfiguracionTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(VariableLimiteFixture.getConfiguracionLimite());
        when(obtenerCategoriasAtributosTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(CategoriaSeleccionableFixture.getCategorias());
        when(obtenerAtributosTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(AtributoFixture.getAtributos());
        when(obtenerVariablesTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(VariableAtributoFixture.getVariablesAtributos());
        when(obtenerItemsVariablesTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(ItemVariableFixture.getItemsVariables());
        when(obtenerTipoLimitePorIdRepository.ejecutar(anyLong()))
                .thenReturn(TipoLimiteFullFixture.getTipoLimiteFull(1l));
        doNothing().when(actualizarVersionTipoLimiteRepository).ejecutar(any(TipoLimiteFull.class));
        doNothing().when(agregarItemVariablesTipoLimiteVersionRepository).ejecutar(anyLong(),any(ItemVariable.class));
        doNothing().when(actualizarItemVariablesTipoLimiteRepository).ejecutar(any(ItemVariableLimite.class));
        doNothing().when(eliminarVariableTipoLimiteRepository).ejecutar(any(ItemVariableLimite.class));
        doNothing().when(actualizarVariableTipoLimiteRepository).ejecutar(any(VariableLimite.class));
        doNothing().when(editarCategoriaTipoLimiteRepository).ejecutar(anyLong(), anyLong(), any(CategoriaSeleccionable.class), anyString());
        doNothing().when(eliminarAtributoTipoLimiteRepository).ejecutar(anyLong(), anyString());

        assertNotNull(service.guardarConfiguracion(TipoLimiteFullFixture.getTipoLimiteFull(1L), "usuario"));
    }

    @Test
    public void editarConfiguracionTipoLimiteEnProceso() throws Exception {
        when(obtenerVariablesTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(VariableAtributoFixture.getVariablesAtributos());
        when(obtenerItemsVariablesTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(ItemVariableFixture.getItemsVariables());

        TipoLimiteFull tipoLimiteFull = TipoLimiteFullFixture.getTipoLimiteFull(1l);
        tipoLimiteFull.setEstado(EstadoTipoLimiteEnum.EN_PROCESO);
        when(obtenerTipoLimitePorIdRepository.ejecutar(anyLong()))
                .thenReturn(tipoLimiteFull);
        when(obtenerConfiguracionTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(VariableLimiteFixture.getConfiguracionLimite());
        when(obtenerCategoriasAtributosTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(CategoriaSeleccionableFixture.getCategorias());
        when(obtenerAtributosTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(AtributoFixture.getAtributos());

        doNothing().when(actualizarVersionTipoLimiteRepository).ejecutar(any(TipoLimiteFull.class));
        doNothing().when(agregarItemVariablesTipoLimiteVersionRepository).ejecutar(anyLong(),any(ItemVariable.class));
        doNothing().when(actualizarItemVariablesTipoLimiteRepository).ejecutar(any(ItemVariableLimite.class));
        doNothing().when(eliminarVariableTipoLimiteRepository).ejecutar(any(ItemVariableLimite.class));
        doNothing().when(actualizarVariableTipoLimiteRepository).ejecutar(any(VariableLimite.class));
        doNothing().when(editarCategoriaTipoLimiteRepository).ejecutar(anyLong(), anyLong(), any(CategoriaSeleccionable.class), anyString());
        doNothing().when(eliminarAtributoTipoLimiteRepository).ejecutar(anyLong(), anyString());
        doNothing().when(actualizaEstadoTipoLimiteVersionRepository).ejecutar(anyLong(), any(EstadoTipoLimiteEnum.class), anyString());

        assertNotNull(service.guardarConfiguracion(TipoLimiteFullFixture.getTipoLimiteFull(1L), "usuario"));
    }

    @Test
    public void obtenerConfiguracionTipoLimiteTestOk() throws PlataformaBaseException {

        TipoLimiteFull infoTipoLimite = new TipoLimiteFull.Builder()
                .id(1L)
                .version(1)
                .nombre("TL Nuevo")
                .codigo("LBLB1010")
                .idTipoLimite(1L)
                .usuarioCreacion("amayo")
                .fechaCreacion("27/10/2020")
                .estado(EstadoTipoLimiteEnum.BORRADOR)
                .descripcion("Borrador en proceso")
                .build();

        when(obtenerTipoLimitePorIdRepository.ejecutar(anyLong()))
                .thenReturn(infoTipoLimite);
        when(obtenerAtributosTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(AtributoFixture.getAtributos());
        when(obtenerVariablesTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(VariableAtributoFixture.getVariablesAtributos());
        when(obtenerItemsVariablesTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(ItemVariableFixture.getItemsVariables());
        TipoLimiteFull tipoLimite = service.obtenerConfiguracionVersionTipoLimite(1L);

        assertNotNull(tipoLimite);
    }

    @Test
    public void actualizaEstadoLimiteTest() throws PlataformaBaseException{
        TipoLimiteFull tipoLimiteFull = new TipoLimiteFull.Builder()
                .id(1L)
                .version(1)
                .nombre("TL Nuevo")
                .codigo("LBLB1010")
                .idTipoLimite(1L)
                .usuarioCreacion("amayo")
                .fechaCreacion("27/10/2020")
                .estado(EstadoTipoLimiteEnum.ACTIVO)
                .descripcion("Borrador en proceso")
                .build();

        when(obtenerTipoLimitePorIdRepository.ejecutar(anyLong()))
                .thenReturn(tipoLimiteFull);
        when(obtenerVersionActivaTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(1L);

        service.actualizaEstadoTipoLimite(tipoLimiteFull);

    }

    @Test
    public void actualizaEstadoTipoLimiteTestActivaConOtrosEnProceso() throws PlataformaBaseException{
        Long ID_TIPO_LIMITE = 2L;
        TipoLimiteFull tipoLimiteFull = new TipoLimiteFull.Builder()
                .id(1L)
                .version(1)
                .nombre("TL Nuevo")
                .codigo("LBLB1010")
                .idTipoLimite(ID_TIPO_LIMITE)
                .usuarioCreacion("amayo")
                .fechaCreacion("27/10/2020")
                .estado(EstadoTipoLimiteEnum.ACTIVO)
                .descripcion("Borrador en proceso")
                .build();

        when(obtenerVersionActivaTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(1L);
        when(obtenerTipoLimitePorIdRepository.ejecutar(anyLong()))
                .thenReturn(tipoLimiteFull);

        List<TipoLimite> versionesBorradorEnProceso = TipoLimiteFixture.getTipoLimites2(ID_TIPO_LIMITE);
        when(obtenerTipoLimitesRepository.ejecutar(any(ConsultarTipoLimitesRequest.class)))
                .thenReturn(versionesBorradorEnProceso);

        when(obtenerTipoLimitePorIdRepository.ejecutar(anyLong()))
                .thenReturn(TipoLimiteFullFixture
                        .getTipoLimiteFull(1L, ID_TIPO_LIMITE, EstadoTipoLimiteEnum.BORRADOR))
                .thenReturn(TipoLimiteFullFixture
                        .getTipoLimiteFull(2L, ID_TIPO_LIMITE, EstadoTipoLimiteEnum.BORRADOR))
                .thenReturn(TipoLimiteFullFixture
                        .getTipoLimiteFull(3L, ID_TIPO_LIMITE, EstadoTipoLimiteEnum.EN_PROCESO))
                .thenReturn(TipoLimiteFullFixture
                        .getTipoLimiteFull(4L, ID_TIPO_LIMITE, EstadoTipoLimiteEnum.EN_PROCESO))
                .thenReturn(tipoLimiteFull);
        doNothing()
                .when(eliminarTipoLimiteRepository)
                .ejecutar(anyLong());

        service.actualizaEstadoTipoLimite(tipoLimiteFull);

        verify(eliminarTipoLimiteRepository, times(versionesBorradorEnProceso.size()))
                .ejecutar(anyLong());
        verify(obtenerTipoLimitePorIdRepository, times(5))
                .ejecutar(anyLong());
    }

    @Test
    public void eliminarTipoLimiteTest() throws PlataformaBaseException{

        when(obtenerTipoLimitePorIdRepository.ejecutar(anyLong()))
                .thenReturn(TipoLimiteFullFixture.getTipoLimiteFull(1L));

        service.eliminarTipoLimite(1l);
    }

    @Test
    public void copiaTipoLimiteTest() throws PlataformaBaseException {

        List<Atributo> atributos = AtributoFixture.getAtributos();

        when(crearTipoLimiteRepository.ejecutar(anyString()))
                .thenReturn(TipoLimiteFixture.getTipoLimite("Tipo limite 1", EstadoTipoLimiteEnum.BORRADOR));
        when(crearTipoLimiteVersionRepository.ejecutar(any(TipoLimiteFull.class)))
                .thenReturn(1L);
        when(obtenerInfoNuevoTipoLimiteRepository.ejecutar(anyLong(), anyString()))
                .thenReturn(2l);
        when(obtenerCategoriasAtributosTipoLimiteRepository.ejecutar(anyLong()))
                .thenReturn(Arrays.asList(new CategoriaSeleccionable.Builder()
                        .idAtributo(atributos.get(0).getId())
                        .seleccionado(true)
                        .build()))
                .thenReturn(Arrays.asList(new CategoriaSeleccionable.Builder()
                        .idAtributo(100L)
                        .seleccionado(false)
                        .build()));

        TipoLimiteFull tipoLimiteFull = TipoLimiteFullFixture.getTipoLimiteFull(1l);
        tipoLimiteFull.setEstado(EstadoTipoLimiteEnum.ACTIVO);
        when(obtenerTipoLimitePorIdRepository.ejecutar(anyLong()))
                .thenReturn(tipoLimiteFull);

        TipoLimiteFull copiatipoLimite = new TipoLimiteFull.Builder()
                .id(1L)
                .version(1)
                .nombre("TL Nuevo")
                .codigo("LBLB1010")
                .prefijo("LBLB")
                .atributos(atributos)
                .idTipoLimite(1L)
                .usuarioCreacion("amayo")
                .fechaCreacion("27/10/2020")
                .estado(EstadoTipoLimiteEnum.ACTIVO)
                .descripcion("Borrador en proceso")
                .build();

        service.copiaTipoLimite(copiatipoLimite, "mmena");

        verify(crearTipoLimiteVersionRepository, times(1))
                .ejecutar(any(TipoLimiteFull.class));
    }


    
}