package cl.bancochile.plataformacomercial.controllimitestaller.service.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Atributo;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.CategoriaSeleccionable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ConsultarFiltrosTipoLimitesResponse;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ConsultarTipoLimitesRequest;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ConsultarTipoLimitesResponse;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.CrearTipoLimiteRequest;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Filtro;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariableLimite;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ResumenAtributos;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimite;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimiteFull;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableAtributo;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableLimite;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
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
import cl.bancochile.plataformacomercial.controllimitestaller.service.TipoLimiteService;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.TipoLimiteVersion;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.CategoriaAtributoEnum;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.TipoValorVariableEnum;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_CAMBIO_ESTADO_TIPO_LIMITE;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_ESTADO_NOPERMITIDO;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_ESTADO_NOPERMITIDO_ELIMINAR;
import static cl.bancochile.plataformacomercial.controllimitestaller.util.TallerAssertUtil.assertTrue;
import static cl.bancochile.plataformacomercial.controllimitestaller.util.TallerMantenedorUtil.getCategoriaAtributo;
import static cl.bancochile.plataformacomercial.controllimitestaller.util.ToolTipsUtil.VARIABLE_TOOLTIP_VENC_MAX_OP;
import static cl.bancochile.plataformacomercial.controllimitestaller.util.ToolTipsUtil.getTooltipsFechasMaxMin;
import static cl.bancochile.plataformacomercial.controllimitestaller.util.ToolTipsUtil.getTooltipsVencMaxOperaciones;
import static cl.bancochile.plataformacomercial.controllimitestaller.util.ToolTipsUtil.isVariableLlevaTooltip;
import static cl.bancochile.plataformacomercial.lib.controllimites.common.util.JSonUtil.convertObjectToJson;

@Service
public class TipoLimiteServiceImpl implements TipoLimiteService {

    private static final Integer VERSION_INICIAL = 1;
    private static final List<String> EXCEPTION_SELECCIONABLE
            = Arrays.asList("GLS101", "MMC170", "PUT162", "CDE181", "CLC194");
    private static final String VAR_TRAMOS = "CTR127";
    private static final String VAR_MONEDA_COMENTARIO = "CDE181";
    private static final String VAR_MONEDA_INSTRUMENTO = "CLC194";

    private static final Logger LOGGER = LoggerFactory.getLogger((TipoLimiteServiceImpl.class));

    @Autowired
    private ObtenerAtributosFiltroRepository obtenerAtributosFiltroRepository;
    @Autowired
    private ObtenerFamiliasLimitesFiltroRepository obtenerFamiliasLimitesFiltroRepository;
    @Autowired
    private ObtenerNombresTipoLimitesFiltroRepository obtenerNombresTipoLimitesFiltroRepository;
    @Autowired
    private ObtenerSubtiposFiltroRepository obtenerSubtiposFiltroRepository;
    @Autowired
    private ObtenerTipoLimitesRepository obtenerTipoLimitesRepository;
    @Autowired
    private ObtenerResumenAtributosRepository obtenerResumenAtributosRepository;
    @Autowired
    private CrearTipoLimiteRepository crearTipoLimiteRepository;
    @Autowired
    private CrearTipoLimiteVersionRepository crearTipoLimiteVersionRepository;
    @Autowired
    private ObtenerAtributosTipoLimiteRepository obtenerAtributosRepository;
    @Autowired
    private ObtenerVariablesAtributosTipoLimiteRepository obtenerVariablesAtributosRepository;
    @Autowired
    private ObtenerItemsVariablesAtributosTipoLimiteRepository obtenerItemsVariablesAtributosRepository;
    @Autowired
    private ObtenerInfoNuevoTipoLimiteRepository obtenerInfoNuevoTipoLimiteRepository;
    @Autowired
    private ObtenerCategoriasAtributosTipoLimiteRepository obtenerCategoriasAtributosTipoLimiteRepository;
    @Autowired
    private ObtenerTipoLimitePorIdRepository obtenerTipoLimitePorIdRepository;
    @Autowired
    private ObtenerConfiguracionTipoLimiteRepository obtenerConfiguracionTipoLimiteRepository;
    @Autowired
    private EliminarAtributoTipoLimiteRepository eliminarAtributoTipoLimiteRepository;
    @Autowired
    private EditarCategoriaTipoLimiteRepository editarCategoriaTipoLimiteRepository;
    @Autowired
    private EliminarVariableTipoLimiteRepository eliminarVariableTipoLimiteRepository;
    @Autowired
    private ActualizarVariableTipoLimiteRepository actualizarVariableTipoLimiteRepository;
    @Autowired
    private ActualizarItemVariablesTipoLimiteRepository actualizarItemVariablesTipoLimiteRepository;
    @Autowired
    private AgregarAtributoTipoLimiteVersionRepository agregarAtributoTipoLimiteVersionRepository;
    @Autowired
    private AgregarVariablesTipoLimiteVersionRepository agregarVariablesTipoLimiteVersionRepository;
    @Autowired
    private AgregarItemVariablesTipoLimiteVersionRepository agregarItemVariablesTipoLimiteVersionRepository;
    @Autowired
    private ActualizaEstadoTipoLimiteVersionRepository actualizaEstadoTipoLimiteVersionRepository;
    @Autowired
    private ActualizaEstadoTipoLimite2Repository actualizaEstadoTipoLimite2Repository;
    @Autowired
    private ObtenerVersionActivaTipoLimiteRepository obtenerVersionActivaTipoLimiteRepository;
    @Autowired
    private ActualizarVersionTipoLimiteRepository actualizarVersionTipoLimiteRepository;
    @Autowired
    private EliminarTipoLimiteRepository eliminarTipoLimiteRepository;

    @Override
    public ConsultarFiltrosTipoLimitesResponse consultarFiltroTipoLimites()
            throws PlataformaBaseException {

        return new ConsultarFiltrosTipoLimitesResponse.Builder()
                .atributos(ordenarPorNombreFiltro(obtenerAtributosFiltroRepository.ejecutar()))
                .familias(ordenarPorNombreFiltro(obtenerFamiliasLimitesFiltroRepository.ejecutar()))
                .nombres(ordenarPorNombreFiltro(obtenerNombresTipoLimitesFiltroRepository.ejecutar()))
                .subtipos(ordenarPorNombreFiltro(obtenerSubtiposFiltroRepository.ejecutar()))
                .estados(obtenerEstadosFiltro())
                .build();
    }

    private List<Filtro> ordenarPorNombreFiltro(List<Filtro> listado) {
        return listado.stream()
                    .sorted(Comparator.comparing(
                            Filtro::getNombre,
                            Comparator.nullsFirst(String.CASE_INSENSITIVE_ORDER)))
                    .collect(Collectors.toList());
    }

    @Override
    public ConsultarTipoLimitesResponse consultarTipoLimites(ConsultarTipoLimitesRequest request)
            throws PlataformaBaseException {
        List<TipoLimite> tipoLimites = obtenerTipoLimitesRepository.ejecutar(request);
        for (TipoLimite tipoLimite : tipoLimites) {
            tipoLimite.setOpciones(tipoLimite.getEstado().getOpcionesDisponibles());
            tipoLimite.setResumenAtributos(obtenerResumenAtributosRepository.ejecutar(tipoLimite.getIdVersion()));
            tipoLimite.setCantidadAtributos(getCantidadAtributos(tipoLimite.getResumenAtributos()));
        }
        return new ConsultarTipoLimitesResponse.Builder()
                .tipoLimites(tipoLimites)
                .build();
    }

    private long getCantidadAtributos(ResumenAtributos resumenAtributos){
        return resumenAtributos.getBasicos() + resumenAtributos.getAvanzados() +
                resumenAtributos.getNormativos() + resumenAtributos.getSinCategoria();
    }

    private TipoLimiteFull consultarInfoBasicaVersionTipoLimite(Long idVersion) {

        return obtenerTipoLimitePorIdRepository.ejecutar(idVersion);
    }

    @Override
    public TipoLimiteFull obtenerConfiguracionNuevoTipoLimite(CrearTipoLimiteRequest request)
            throws PlataformaBaseException {

        String codigoTipoLimite = obtenerCodigoTipoLimite(request.getIdFamiliaLimite(), request.getPrefijo());

        List<Atributo> atributos = obtenerAtributosTipoLimite(null);

        atributos = atributos.stream()
                .filter(atributo -> atributo.isObligatorio())
                .collect(Collectors.toList());

        return new TipoLimiteFull.Builder()
                .id(0L)
                .idTipoLimite(0L)
                .nombre(null)
                .descripcion(null)
                .codigo(codigoTipoLimite)
                .version(VERSION_INICIAL)
                .estado(EstadoTipoLimiteEnum.BORRADOR)
                .atributos(atributos)
                .familiaLimite(request.getIdFamiliaLimite())
                .prefijo(request.getPrefijo())
                .build();
    }

    private String obtenerCodigoTipoLimite(long idFamiliaLimite, String prefijo) throws PlataformaBaseException {
        prefijo = prefijo.toUpperCase();
        long correlativo = obtenerInfoNuevoTipoLimiteRepository
                .ejecutar(idFamiliaLimite, prefijo);

        return StringUtils.join( prefijo,
                                 String.format("%04d", correlativo));
    }

    @Override
    public TipoLimiteFull obtenerConfiguracionVersionTipoLimite(long idVersion) throws
            PlataformaBaseException {

        TipoLimiteFull tipoLimiteVersion = consultarInfoBasicaVersionTipoLimite(idVersion);
        List<Atributo> atributos = obtenerAtributosTipoLimite(tipoLimiteVersion.getId());

        tipoLimiteVersion.setAtributos(atributos);

        return tipoLimiteVersion;
    }

    @Override
    public List<Atributo> obtenerAtributosTipoLimite(Long idTipoLimiteVersion) throws PlataformaBaseException {
        List<Atributo> atributos = obtenerAtributosRepository.ejecutar(idTipoLimiteVersion);
        List<String> atributosExcluidos = Arrays.asList("TO136", "FT138");

        atributos = atributos.stream()
                .filter(atributo -> !atributosExcluidos.contains(atributo.getCodigo()))
                .collect(Collectors.toList());

        asignarVariablesCategorias(atributos, idTipoLimiteVersion);
        return atributos;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, timeout = 30, rollbackFor = PlataformaBaseException.class)
    public Long guardarConfiguracion(TipoLimiteFull request, String usuario) throws PlataformaBaseException {

        long idVersionTipoLimite;

        if(request.getId() == 0 ) {
            request.setUsuarioCreacion(usuario);
            idVersionTipoLimite = crearNuevoTipoLimite(request);
        } else {
            request.setUsuarioModificacion(usuario);

            TipoLimiteFull infoVersionTipoLimite = consultarInfoBasicaVersionTipoLimite(request.getId());

            EstadoTipoLimiteEnum estado = infoVersionTipoLimite.getEstado();
            request.setEstado(estado);

            switch (estado){
                case ACTIVO:
                case HISTORICO:
                    idVersionTipoLimite = crearNuevaVersionTipoLimite(request);
                    break;
                case BORRADOR:
                case EN_PROCESO:
                    idVersionTipoLimite = actualizaVersionTipoLimite(request);
                    break;
                default:
                    throw new TallerException(MSG_ERROR_ESTADO_NOPERMITIDO);
            }
        }

        return idVersionTipoLimite;
    }

    private long crearNuevoTipoLimite(TipoLimiteFull infoNuevoTipoLimite) throws PlataformaBaseException {

        String codigo =
                obtenerCodigoTipoLimite(infoNuevoTipoLimite.getIdFamiliaLimite(), infoNuevoTipoLimite.getPrefijo());

        assertTrue(MsgErrorEnum.MSG_ERROR_CODIGO_NO_CORRESPONDE, codigo.equals(infoNuevoTipoLimite.getCodigo()));

        TipoLimite tipoLimite = crearTipoLimiteRepository.ejecutar(infoNuevoTipoLimite.getPrefijo().toUpperCase());

        infoNuevoTipoLimite.setIdTipoLimite(tipoLimite.getId());
        long idVersionNuevoTipoLimite = crearTipoLimiteVersionRepository.ejecutar(infoNuevoTipoLimite);

        guardarAtributosTipoLimite(idVersionNuevoTipoLimite, infoNuevoTipoLimite.getAtributos());

        return idVersionNuevoTipoLimite;
    }

    private long crearNuevaVersionTipoLimite(TipoLimiteFull nuevaVersion) throws PlataformaBaseException {

        long idVersionNuevoTipoLimite = crearTipoLimiteVersionRepository.ejecutar(nuevaVersion);

        guardarAtributosTipoLimite(idVersionNuevoTipoLimite, nuevaVersion.getAtributos());

        return idVersionNuevoTipoLimite;
    }

    private void guardarAtributosTipoLimite(long idVersionTipoLimite, List<Atributo> atributos)
            throws PlataformaBaseException {
        for(Atributo atributo: atributos) {
            agregarAtributoTipoLimiteVersionRepository.ejecutar(idVersionTipoLimite, atributo);

            guardarVariablesTipoLimite(idVersionTipoLimite, atributo);
        }
    }

    private void guardarVariablesTipoLimite(long idVersionTipoLimite, Atributo atributo)
            throws PlataformaBaseException {

        CategoriaAtributoEnum categoria = getCategoriaAtributo(atributo);

        for (VariableAtributo variableAtributo : atributo.getVariables()) {

            setTooltipVariable(variableAtributo, categoria);

            if(TipoValorVariableEnum.SELECCIONABLE.equals(variableAtributo.getTipoValor())) {
                asignacionVariablesSeleccionable(idVersionTipoLimite, variableAtributo);
            } else {
                // Validacion y asignacion boolean values
                if (null != variableAtributo.getValor() &&
                        TipoValorVariableEnum.BOOLEAN.getId() == variableAtributo.getTipoValor().getId()){
                    variableAtributo.setValor((Boolean)variableAtributo.getValor() ? 1 : 0);
                }
                // Se agregan las opciones que vienen en el objeto VariableAtributo
                agregarVariablesTipoLimiteVersionRepository.ejecutar(idVersionTipoLimite, variableAtributo);
            }
        }
    }

    private void setTooltipVariable(VariableAtributo variableAtributo, CategoriaAtributoEnum categoria){
        if(CategoriaAtributoEnum.BASICO.equals(categoria) && isVariableLlevaTooltip(variableAtributo.getCodigo())){
            variableAtributo.setTooltip(getTooltipsFechasMaxMin(variableAtributo));
        }

        if(VARIABLE_TOOLTIP_VENC_MAX_OP.equals(variableAtributo.getCodigo())){
            variableAtributo.setTooltip(getTooltipsVencMaxOperaciones(variableAtributo, categoria));
        }
    }

    private void asignacionVariablesSeleccionable(long idVersion, VariableAtributo variableAtributo)
            throws PlataformaBaseException{
        /*
            Creacion
            Por cada logica se asocia el array de ItemVariables a cada variable
         */
        long idVariableTipoLimite;
        if (EXCEPTION_SELECCIONABLE.contains(variableAtributo.getCodigo())) {
            // Validacion caso especial grilla productos con multiples variables
            if ("GLS101".equals(variableAtributo.getCodigo()) && !variableAtributo.isSeleccionado()){
                return;
            }
            // Obtencion del array proveniente del Object valor
            List<ItemVariable> valor = getItemVariable(variableAtributo.getValor());
            variableAtributo.setValor(null);

            // Asignacion de variable
            idVariableTipoLimite = agregarVariablesTipoLimiteVersionRepository.ejecutar(idVersion,
                    variableAtributo);
            guardarItemVariableTipoLimite(valor, idVariableTipoLimite);
        } else {
            // Asignacion de variable
            idVariableTipoLimite = agregarVariablesTipoLimiteVersionRepository.ejecutar(idVersion,
                    variableAtributo);

            // Asignacion tramos caja derivados
            if (VAR_TRAMOS.equals(variableAtributo.getCodigo())){
                for (ItemVariable item : variableAtributo.getItems()){
                    item.setValor(item.getValor() == null ? null : convertObjectToJson(item.getValor()));
                }
                guardarItemVariableTipoLimite(variableAtributo.getItems(), idVariableTipoLimite);
                return;
            }

            // Se asigna solo items que se encuentren con flag seleccionado
            List<ItemVariable> items = variableAtributo.getItems().stream()
                    .filter(ItemVariable::isSeleccionado).collect(Collectors.toList());
            guardarItemVariableTipoLimite(items, idVariableTipoLimite);
        }
    }

    @SuppressWarnings("unchecked")
    private List<ItemVariable> getItemVariable(Object valorVariable){
        List<ItemVariable> itemVariableList = new ArrayList<>();
        if (valorVariable instanceof ArrayList){
            List<LinkedHashMap<String, Object>> array = (ArrayList) valorVariable;
            itemVariableList.addAll(setItemVariable(array));
        }
        return itemVariableList;
    }

    private List<ItemVariable> setItemVariable(List<LinkedHashMap<String, Object>> array){
        List<ItemVariable> itemsVariables = new ArrayList<>();

        for(Object map : array){
            if (map instanceof ItemVariable){
                itemsVariables.add((ItemVariable) map);
            }else {
                LinkedHashMap<String, Object> item = (LinkedHashMap) map;
                itemsVariables.add(new ItemVariable.Builder()
                        .id(((Integer) item.get("id")).longValue())
                        .valor(item.get("valor"))
                        .seleccionado((Boolean) item.get("seleccionado"))
                        .build());
            }
        }
        return itemsVariables;
    }

    private void guardarItemVariableTipoLimite(List<ItemVariable> itemVariableList, long idVariableTipoLimite)
            throws PlataformaBaseException {
        for(ItemVariable item: itemVariableList) {
            agregarItemVariablesTipoLimiteVersionRepository.ejecutar(idVariableTipoLimite, item);
        }
    }

    private long actualizaVersionTipoLimite(TipoLimiteFull request) throws PlataformaBaseException{

        // Modificacion datos version limite
        editarVersionTipoLimite(request);

        // Obtencion configuracion del tipo de limite y datos guardados del tipo de limite
        List<VariableLimite> variablesGuardadas
                = obtenerConfiguracionTipoLimiteRepository.ejecutar(request.getId());
        List<Atributo> atributos =  obtenerAtributosTipoLimite(request.getId());
        List<CategoriaSeleccionable> categoriasGuardadas
                = obtenerCategoriasAtributosTipoLimiteRepository.ejecutar(request.getId());

        // Asignacion de categorias a atributos
        getAsignacionCategorias(atributos, categoriasGuardadas);

        // Listado atributos guardados
        List<String> atributosGuardadosList = getAtributos(variablesGuardadas);

        // Guardar nueva configuracion de limite
        guardarVariables(request, atributosGuardadosList, variablesGuardadas, atributos);

        if(EstadoTipoLimiteEnum.EN_PROCESO == request.getEstado()){
            actualizaEstadoTipoLimiteVersionRepository.ejecutar(request.getId(),
                                                         EstadoTipoLimiteEnum.BORRADOR,
                                                         request.getUsuarioModificacion());
        }
        return request.getId();
    }

    private void getAsignacionCategorias(List<Atributo> atributos, List<CategoriaSeleccionable> categoriasGuardadas) {
        for (Atributo atributo: atributos){
           List<CategoriaSeleccionable> categorias = categoriasGuardadas.stream()
                   .filter(categoria -> categoria.getIdAtributo().equals(atributo.getId()))
                   .collect(Collectors.toList());

           atributo.setCategorias(categorias);
        }
    }

    private void editarVersionTipoLimite(TipoLimiteFull request)
            throws PlataformaBaseException {
        actualizarVersionTipoLimiteRepository.ejecutar(request);
    }

    private List<String> getAtributos(List<VariableLimite> variablesGuardadas){
        return variablesGuardadas.stream()
                .map(VariableLimite::getCodigoAtributo)
                .distinct()
                .collect(Collectors.toList());
    }

    private void guardarVariables(final TipoLimiteFull request,
                                  final List<String> atributosGuardadosList,
                                  final List<VariableLimite> variablesGuardadas,
                                  final List<Atributo> atributos)
            throws PlataformaBaseException{

        // Se obtiene particion con atributos a agregar
        List<Atributo> atributosAAgregar = request.getAtributos().stream()
                .filter(atributo -> !atributosGuardadosList.contains(atributo.getCodigo()))
                .collect(Collectors.toList());

        // Se obtiene particion con atributos a editar y eliminar
        Map<Boolean, List<String>> particionAtributos = atributosGuardadosList.stream()
                .collect(
                        Collectors.partitioningBy(request.getAtributos().stream()
                                .map(Atributo::getCodigo)
                                .collect(Collectors.toList())
                                ::contains));

        // Obtencion atributos a editar
        List<String> atributosAEditar = particionAtributos.get(Boolean.TRUE);
        // Obtencion atributos a eliminar
        List<String> atributosAEliminar = particionAtributos.get(Boolean.FALSE);

        guardarAtributosTipoLimite(request.getId(), atributosAAgregar);
        editarAtributos(atributosAEditar, variablesGuardadas, atributos, request);
        eliminarAtributos(atributosAEliminar, request.getId());
    }

    private void editarAtributos(List<String> atributosAEditar,
                                 final List<VariableLimite> atributosGuardados,
                                 final List<Atributo> atributos,
                                 final TipoLimiteFull request) throws PlataformaBaseException {
        // Obtencion atributos a editar
        List<Atributo> atributosRequest = request.getAtributos().stream()
                .filter(atributo -> atributosAEditar.contains(atributo.getCodigo()))
                .collect(Collectors.toList());

        // Listado Categorias por editar
        List<Atributo> listadoAEditar = new ArrayList<>();

        for (Atributo atributo : atributosRequest){
            // Limpieza en caso de ser Grilla de Producto
            limpiezaVariablesGrillaProducto(atributo);

            // Obtencion atributo seleccionado en caso de existir
            Optional<Atributo> atributoCategoria = atributos.stream()
                    .filter(atributoGuardado -> atributo.getId() == atributoGuardado.getId()).findFirst();

            // Se agrega al listado de actualizacion de categorias
            atributoCategoria.ifPresent(atributoSeleccionable
                    -> asignacionCategoria(atributo, atributoSeleccionable, listadoAEditar));

            // Obtencion listado de variables asignadas por atributo
            List<VariableLimite> variablesAtributo = atributosGuardados.stream()
                    .filter(variable -> variable.getCodigoAtributo().equals(atributo.getCodigo()))
                    .collect(Collectors.toList());

            actualizaVariables(atributo, variablesAtributo);
        }

        // Actualizacion de categorias
        actualizaCategorias(listadoAEditar, request.getId());
    }

    private void limpiezaVariablesGrillaProducto(Atributo atributo){
        if ("GP101".equals(atributo.getCodigo()) && atributo.getVariables() != null){
            atributo.getVariables()
                    .removeIf(variable -> !variable.isSeleccionado());
        }
    }

    private void actualizaVariables(Atributo atributo, List<VariableLimite> variablesAtributo)
            throws PlataformaBaseException {

        List<VariableLimite> variablesAEditar = new ArrayList<>();

        for (VariableLimite variableGuardada : variablesAtributo){
            // Buscar variable ingresada
            Optional<VariableAtributo> variableIngresada = atributo.getVariables().stream()
                    .filter(variable -> variableGuardada.getCodigoVariable().equals(variable.getCodigo()))
                    .findFirst();

            CategoriaAtributoEnum esCategoriaBasica = getCategoriaAtributo(atributo);

            if (variableIngresada.isPresent()){
                // Por cada variable guardada evalua si existe modificacion con datos ingresados
                asignacionVariablesAEditar( variableGuardada,
                                            variableIngresada.get(),
                                            variablesAEditar,
                                            esCategoriaBasica);

                // Se obtiene items variables a agregar
                List<ItemVariable> itemVariablesPorAgregar = variableIngresada.get().getItems().stream()
                        .filter(item -> variableGuardada.getItems().stream()
                                .noneMatch(itemIngresada -> item.getValor().equals(itemIngresada.getValor())))
                        .collect(Collectors.toList());

                // Se obtiene particion con ids de items variables a editar y eliminar
                Map<Boolean, List<ItemVariableLimite>> particionItemVariables = variableGuardada.getItems().stream()
                        .collect(
                                Collectors.partitioningBy(variable -> variableIngresada.get().getItems().stream()
                                        .map(ItemVariable::getValor)
                                        .collect(Collectors.toList())
                                            .contains(variable.getValor())));

                // Obtencion items variables a editar
                List<ItemVariableLimite> atributosAEditar = particionItemVariables.get(Boolean.TRUE);

                // Obtencion items variables a eliminar
                List<ItemVariableLimite> atributosAEliminar = particionItemVariables.get(Boolean.FALSE);

                // Agregar items variables
                guardarItemVariableTipoLimite(itemVariablesPorAgregar, variableGuardada.getId());
                // Editar items variables
                actualizarItemsVariables(atributosAEditar, variableIngresada.get().getItems());
                // Eliminar items variables
                eliminarItemsVariablesTipoLimite(atributosAEliminar);
            }
        }
        actualizaVariablesTipoLimite(variablesAEditar);
    }

    private void asignacionVariablesAEditar(VariableLimite variableGuardada,
                                            VariableAtributo variableIngresada,
                                            List<VariableLimite> variablesAEditar,
                                            CategoriaAtributoEnum categoriaAtributo) throws PlataformaBaseException {

        if(TipoValorVariableEnum.SELECCIONABLE.equals(variableIngresada.getTipoValor())) {
            // Asignacion datos a variable guardada a modificar
            asignacionVariablesSeleccionable(variableGuardada, variableIngresada);
        } else {
            // Validacion y asignacion boolean values
            if (null != variableIngresada.getValor() &&
                    TipoValorVariableEnum.BOOLEAN == variableIngresada.getTipoValor()){
                variableIngresada.setValor((Boolean)variableIngresada.getValor() ? 1 : 0);
            }
        }

        if (isVariableModificada(variableGuardada, variableIngresada)){
            // Se define tooltip por defecto cuando el atributo es basico
            if(isVariableLlevaTooltip(variableIngresada.getCodigo())
                    || VARIABLE_TOOLTIP_VENC_MAX_OP.equals(variableIngresada.getCodigo())){
                setTooltipVariable(variableIngresada, categoriaAtributo);
            }

            variableGuardada.setTooltip(variableIngresada.getTooltip());
            variableGuardada.setValor(variableIngresada.getValor());
            variableGuardada.setIdVariableAtributo(variableIngresada.getId());
            variablesAEditar.add(variableGuardada);
        }
    }

    private void asignacionVariablesSeleccionable(VariableLimite variableGuardada, VariableAtributo variableIngresada)
            throws PlataformaBaseException {
        // Edicion
        List<ItemVariable> items;
        // Validacion Casos especiales, asignacion de items a variable ingresada
        if (EXCEPTION_SELECCIONABLE.contains(variableGuardada.getCodigoVariable())) {
            // Obtencion del array proveniente del Object valor
            items = getItemVariable(variableIngresada.getValor());
            variableIngresada.setValor(null);
            variableIngresada.setItems(items);
        } else if (VAR_TRAMOS.equals(variableGuardada.getCodigoVariable())) {
            for (ItemVariable item : variableIngresada.getItems()){
                item.setValor(item.getValor() == null ? null : convertObjectToJson(item.getValor()));
            }
        } else {
            // Se asigna solo items que se encuentren con flag seleccionado
            items = variableIngresada.getItems().stream()
                    .filter(ItemVariable::isSeleccionado).collect(Collectors.toList());
            variableIngresada.setItems(items);
        }
    }

    private void actualizarItemsVariables(List<ItemVariableLimite> itemVariablesGuardados,
                                          List<ItemVariable> itemVariablesIngresados) throws PlataformaBaseException {
        List<ItemVariableLimite> itemVariablesAGuardar = new ArrayList<>();
        for (ItemVariableLimite itemVariableGuardado : itemVariablesGuardados){

            // Buscar el item variable en los ingresados, para encontrar la referencia se ocupa idVariableItem
            Optional<ItemVariable> itemVariableIngresado = itemVariablesIngresados.stream()
                    .filter(item -> itemVariableGuardado.getIdVariableItem() == item.getId()).findFirst();

            // En caso de existir se actualiza los datos del item variable guardado y se actualiza
            if (itemVariableIngresado.isPresent() &&
                isItemVariableModificado(itemVariableGuardado, itemVariableIngresado.get())){
                    itemVariableGuardado.setValor(itemVariableIngresado.get().getValor());
                    itemVariableGuardado.setSeleccionado(itemVariableIngresado.get().isSeleccionado());
                    itemVariablesAGuardar.add(itemVariableGuardado);
            }
        }
        actualizarItemsVariablesTipoLimite(itemVariablesAGuardar);
    }

    private boolean isItemVariableModificado(ItemVariableLimite itemVariableGuardada,
                                             ItemVariable itemVariableIngresada){
        return itemVariableGuardada.getValor() != itemVariableIngresada.getValor()
                || itemVariableGuardada.isSeleccionado() != itemVariableIngresada.isSeleccionado();
    }

    private void actualizarItemsVariablesTipoLimite(List<ItemVariableLimite> itemVariables)
            throws PlataformaBaseException {
        for (ItemVariableLimite itemVariable: itemVariables){
            actualizarItemVariablesTipoLimiteRepository.ejecutar(itemVariable);
        }
    }

    private void eliminarItemsVariablesTipoLimite(List<ItemVariableLimite> itemVariables)
            throws PlataformaBaseException {
        for (ItemVariableLimite itemVariable: itemVariables){
            eliminarVariableTipoLimiteRepository.ejecutar(itemVariable);
        }
    }

    private void actualizaVariablesTipoLimite(List<VariableLimite> variablesTipoLimite)
            throws PlataformaBaseException {
        for (VariableLimite variable: variablesTipoLimite){
            actualizarVariableTipoLimiteRepository.ejecutar(variable);
        }
    }

    private boolean isVariableModificada(VariableLimite variableGuardada, VariableAtributo variableIngresada){
        return variableGuardada.getValor() != variableIngresada.getValor()
                || !StringUtils.equals(variableGuardada.getTooltip(),variableIngresada.getTooltip());
    }

    private void asignacionCategoria(Atributo atributo, final Atributo atributoGuardado,
                                     List<Atributo> listadoAEditar) {
        // Validacion modificacion atributo
        if (!atributoGuardado.getCategorias().equals(atributo.getCategorias()) ||
                !StringUtils.equals(atributoGuardado.getComentario(),atributo.getComentario())) {

            // Se agrega a lista por modificar la categoria ingresada por usuario
            listadoAEditar.add(new Atributo.Builder()
                    .id(atributo.getId())
                    .categorias(atributo.getCategorias())
                    .comentario(atributo.getComentario())
                    .build());
        }
    }

    private void actualizaCategorias(final List<Atributo> listadoAEditar, Long idTipoLimite)
            throws PlataformaBaseException {
        for (Atributo atributo: listadoAEditar){

            Optional<CategoriaSeleccionable> categoria = atributo.getCategorias().stream()
                    .filter(CategoriaSeleccionable::isSeleccionado)
                    .findFirst();

            if (categoria.isPresent()){
                editarCategoriaTipoLimiteRepository
                        .ejecutar(idTipoLimite, atributo.getId(), categoria.get(), atributo.getComentario());
            } else {
                editarCategoriaTipoLimiteRepository
                        .ejecutar(idTipoLimite, atributo.getId(), null, atributo.getComentario());
            }
        }
    }

    private void eliminarAtributos(List<String> atributosAEliminar, Long idTipoLimite) throws PlataformaBaseException {
        for (String codigoAtributo : atributosAEliminar) {
            eliminarAtributoTipoLimiteRepository.ejecutar(idTipoLimite, codigoAtributo);
        }
    }


    private void asignarVariablesCategorias(List<Atributo> atributos, Long idTipoLimite)
            throws PlataformaBaseException {

        List<VariableAtributo> variables = obtenerVariablesAtributosRepository.ejecutar(idTipoLimite);
        List<ItemVariable> itemsVariables = obtenerItemsVariablesAtributosRepository.ejecutar(idTipoLimite);
        List<CategoriaSeleccionable> categorias = obtenerCategoriasAtributosTipoLimiteRepository.ejecutar(idTipoLimite);

        for (final Atributo atributo: atributos) {

            List<CategoriaSeleccionable> categoriasSeleccionables = new ArrayList<>(categorias);
            categoriasSeleccionables = categoriasSeleccionables.stream()
                    .filter(categoria -> atributo.getId() == categoria.getIdAtributo())
                    .collect(Collectors.toList());

            List<VariableAtributo> variablesAtributos = new ArrayList<>(variables);
            variablesAtributos = variablesAtributos.stream()
                    .filter(variableAtributo -> atributo.getId() == variableAtributo.getIdAtributo())
                    .collect(Collectors.toList());

            asignarItemsVariables(variablesAtributos, itemsVariables);
            atributo.setVariables(variablesAtributos);
            atributo.setCategorias(categoriasSeleccionables);
        }
    }

    private void asignarItemsVariables(List<VariableAtributo> variables, final List<ItemVariable> itemsVariables) {

        for(final VariableAtributo variable: variables){
            // Items totales para la configuracion
            List<ItemVariable> items = itemsVariables.stream()
                    .filter(item -> Objects.equals(item.getIdVariable(), variable.getId()))
                    .collect(Collectors.toList());

            // Asignacion de seleccion para registros asignados en el items
            List<ItemVariable> valor = getValorItemVariable(itemsVariables, variable);

            // Asignacion item guardados por el usuario
            for (ItemVariable item : items){
                item.setSeleccionado(item.isAsignado());
            }

            // Asignaciones si es una variable especial
            if (!valor.isEmpty() && isExceptionVariable(variable)){
                variable.setValor(valor);
                variable.setSeleccionado(Boolean.TRUE);
            }

            // Asignacion valores comentario
            if (VAR_MONEDA_COMENTARIO.equals(variable.getCodigo())
                    || VAR_MONEDA_INSTRUMENTO.equals(variable.getCodigo())){
                variable.setValor(items);
            }

            variable.setItems(items);
        }
    }

    private boolean isExceptionVariable(VariableAtributo variable) {
        return EXCEPTION_SELECCIONABLE.contains(variable.getCodigo());
    }

    private List<ItemVariable> getValorItemVariable(List<ItemVariable> valorItemVariables, VariableAtributo variable) {
        return valorItemVariables.stream()
                .map(ItemVariable::new)
                .filter(item -> Objects.equals(item.getIdVariable(), variable.getId()) && item.isAsignado())
                .collect(Collectors.toList());
    }

    public static List<EstadoTipoLimiteEnum> obtenerEstadosFiltro() {
        List<EstadoTipoLimiteEnum> estados = new ArrayList<>();
        estados.add(EstadoTipoLimiteEnum.ACTIVO);
        estados.add(EstadoTipoLimiteEnum.BORRADOR);
        estados.add(EstadoTipoLimiteEnum.EN_PROCESO);
        estados.add(EstadoTipoLimiteEnum.HISTORICO);
        return estados;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, timeout = 30, rollbackFor = PlataformaBaseException.class)
    public TipoLimiteVersion actualizaEstadoTipoLimite(TipoLimiteVersion tipoLimiteVersion) throws
            PlataformaBaseException {

        switch (tipoLimiteVersion.getEstado()){
            case ACTIVO:
                activarVersionTipoLimite(tipoLimiteVersion);
                break;
            case HISTORICO:
                historizarVersionTipoLimite(tipoLimiteVersion);
                break;
            default:
                throw new TallerException(MSG_ERROR_CAMBIO_ESTADO_TIPO_LIMITE.getMensaje(),
                        MSG_ERROR_CAMBIO_ESTADO_TIPO_LIMITE.getCodigo());
        }

        // Version modificada
        TipoLimiteFull detalleFull = obtenerConfiguracionVersionTipoLimite(tipoLimiteVersion.getId());

        tipoLimiteVersion.setId(detalleFull.getId());
        tipoLimiteVersion.setEstado(detalleFull.getEstado());
        tipoLimiteVersion.setUsuarioModificacion(detalleFull.getUsuarioModificacion());
        tipoLimiteVersion.setFechaActualizacion(detalleFull.getFechaActualizacion());
        return tipoLimiteVersion;
    }

    private void activarVersionTipoLimite(TipoLimiteVersion tipoLimiteVersion) throws PlataformaBaseException {

        // Se obtiene la version activa si existe
        long idVersionActiva = obtenerVersionActivaTipoLimiteRepository.ejecutar(tipoLimiteVersion.getId());

        actualizaEstadoTipoLimiteVersionRepository.ejecutar(tipoLimiteVersion.getId(),
                                                            EstadoTipoLimiteEnum.ACTIVO,
                                                            tipoLimiteVersion.getUsuarioModificacion());

        LOGGER.info( String.format("Activando tipo de limite %s"
                                    , tipoLimiteVersion.getNombre()));

        if(idVersionActiva != 0L){
            // Si existe version activa, se pasa a historico
            actualizaEstadoTipoLimiteVersionRepository.ejecutar(idVersionActiva,
                                                                EstadoTipoLimiteEnum.HISTORICO,
                                                                tipoLimiteVersion.getUsuarioModificacion());
        } else {
            // De lo contrario, se activa el Tipo de Limite
            TipoLimite tipoLimite = new TipoLimite.Builder()
                    .id(tipoLimiteVersion.getIdTipoLimite())
                    .estado(EstadoTipoLimiteEnum.ACTIVO)
                    .build();

            actualizaEstadoTipoLimite2Repository.ejecutar(tipoLimite);
        }

        eliminarVersionesNoActivadas(tipoLimiteVersion);
    }

    private void eliminarVersionesNoActivadas(TipoLimiteVersion tipoLimiteVersion) throws PlataformaBaseException {
        // Obtener versiones Borrador y En Proceso
        ConsultarTipoLimitesRequest request = new ConsultarTipoLimitesRequest.Builder()
                .estados(Arrays.asList(EstadoTipoLimiteEnum.BORRADOR, EstadoTipoLimiteEnum.EN_PROCESO))
                .codigo(tipoLimiteVersion.getCodigo())
                .build();

        List<TipoLimite> tiposLimitesBorradorEnProceso = obtenerTipoLimitesRepository.ejecutar(request);

        for(TipoLimite tipoLimite : tiposLimitesBorradorEnProceso) {

            if(tipoLimiteVersion.getIdTipoLimite() == tipoLimite.getId()) {
                LOGGER.info(String.format("Eliminando version %d en estado %s"
                                            , tipoLimite.getVersion()
                                            , tipoLimite.getEstado().getNombre()));
                eliminarTipoLimite(tipoLimite.getIdVersion());
            }
        }
    }

    private void historizarVersionTipoLimite(TipoLimiteVersion tipoLimiteVersion) throws PlataformaBaseException {

        // Version
        actualizaEstadoTipoLimiteVersionRepository.ejecutar(tipoLimiteVersion.getId(),
                                                            EstadoTipoLimiteEnum.HISTORICO,
                                                            tipoLimiteVersion.getUsuarioModificacion());

        // Tipo Limite
        TipoLimite tipoLimite = new TipoLimite.Builder()
                .id(tipoLimiteVersion.getIdTipoLimite())
                .estado(EstadoTipoLimiteEnum.HISTORICO)
                .build();

        actualizaEstadoTipoLimite2Repository.ejecutar(tipoLimite);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, timeout = 30, rollbackFor = PlataformaBaseException.class)
    public Long copiaTipoLimite(TipoLimiteFull copiaTipoLimite, String usuario) throws PlataformaBaseException{

        long idCopiaTipoLimite = 1L;

        if(copiaTipoLimite.getEstado().equals(EstadoTipoLimiteEnum.EN_PROCESO) ||
                copiaTipoLimite.getEstado().equals(EstadoTipoLimiteEnum.ACTIVO) ||
                copiaTipoLimite.getEstado().equals(EstadoTipoLimiteEnum.BORRADOR) ||
                copiaTipoLimite.getEstado().equals(EstadoTipoLimiteEnum.HISTORICO)) {

            List<Atributo> atributos = obtenerAtributosTipoLimite(copiaTipoLimite.getId());

            String codigo =
                    obtenerCodigoTipoLimite(copiaTipoLimite.getIdFamiliaLimite(), copiaTipoLimite.getPrefijo());
            copiaTipoLimite.setAtributos(atributos);
            copiaTipoLimite.setCodigo(codigo);
            copiaTipoLimite.setIdTipoLimite(Long.valueOf(codigo.substring(4,codigo.length())));
            // seteamos los nuevos valores.
            copiaTipoLimite.setUsuarioCreacion(usuario);
            copiaTipoLimite.setEstado(EstadoTipoLimiteEnum.BORRADOR);

            idCopiaTipoLimite = crearNuevoTipoLimite(copiaTipoLimite);
        }
        return idCopiaTipoLimite;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, timeout = 30, rollbackFor = PlataformaBaseException.class)
    public void eliminarTipoLimite(Long idTipoLimite)
            throws PlataformaBaseException{
        LOGGER.info("Se eliminara un Tipo de Limite y sus Items...");
        TipoLimiteFull detalleLimite = obtenerTipoLimitePorIdRepository.ejecutar(idTipoLimite);

        if (detalleLimite.getEstado().equals(EstadoTipoLimiteEnum.BORRADOR) ||
                detalleLimite.getEstado().equals(EstadoTipoLimiteEnum.EN_PROCESO)){
            eliminarTipoLimiteRepository.ejecutar(idTipoLimite);
        }else {
            throw new PlataformaBaseException(
                    MSG_ERROR_ESTADO_NOPERMITIDO_ELIMINAR.getMensaje(),
            new Throwable(MSG_ERROR_ESTADO_NOPERMITIDO_ELIMINAR.getMensaje()),
                    MSG_ERROR_ESTADO_NOPERMITIDO_ELIMINAR.getCodigo()
            );
        }
    }
}
