package cl.bancochile.plataformacomercial.controllimitestaller.service.impl;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Atributo;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.AtributoValidacion;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimiteFull;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ValidacionResponse;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableAtributo;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ActualizaEstadoTipoLimiteVersionRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerTipoLimitePorIdRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.service.TipoLimiteService;
import cl.bancochile.plataformacomercial.controllimitestaller.service.ValidacionService;
import cl.bancochile.plataformacomercial.controllimitestaller.util.ValidacionUtil;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.CategoriaAtributoEnum;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_CAMPOS_INCOMPLETOS;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_CLEAN_UP;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_CURSES_PARCIALES;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_MONEDAS_CURSE;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_MONTO_LIM_CLEAN_UP;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_PERFIL_USER;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_PLAZO;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_PLAZO_FMC;
import static cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum.MSG_ERROR_PLAZO_MAX_OPERACIONES;
import static cl.bancochile.plataformacomercial.controllimitestaller.util.TallerAssertUtil.assertTrue;
import static cl.bancochile.plataformacomercial.controllimitestaller.util.TallerMantenedorUtil.getCategoriaAtributo;
import static cl.bancochile.plataformacomercial.controllimitestaller.util.ValidacionUtil.objectToString;

@Service
public class ValidacionServiceImpl implements ValidacionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidacionServiceImpl.class);
    private static final String ATRIBUTO_MONTO_LIMITE = "ML103";
    private static final String ATRIBUTO_MONEDA_CURSE = "PM125";
    private static final String ATRIBUTO_FECHA_MAX_CURSE = "VL121";
    private static final String ATRIBUTO_PLAZO = "PL104";
    private static final String ATRIBUTO_VENCIMIENTO_MAX_CURSE = "VC122";
    private static final String ATRIBUTO_REUTILIZABLE = "RE128";
    private static final String ATRIBUTO_CURSES_PARCIALES = "CP126";
    private static final String ATRIBUTO_CLEAN_UP = "CU117";
    private static final String ATRIBUTO_PLAZO_LIMITE = "PL104";
    private static final String ATRIBUTO_PLAZO_MAX_OPERACIONES = "PO123";
    private static final String VARIABLE_FECHA_CRITERIO = "VFC213";
    private static final String VARIABLE_DOBLE_LOGICA = "VFC207";
    private static final String FECHA_CRITERIO_1 = "Fecha Vencimiento MAC + Plazo";
    private static final String FECHA_CRITERIO_2 = "Fecha Vencimiento MAC + Plazo Operaciones";
    private static final String FECHA_CRITERIO_3 = "Fecha Máx Curse + Plazo";
    private static final String FECHA_CRITERIO_4 = "Fecha Máx Curse + Plazo Operaciones";

    @Autowired
    private TipoLimiteService tipoLimiteService;
    @Autowired
    private ActualizaEstadoTipoLimiteVersionRepository actualizaEstadoTipoLimiteVersionRepository;
    @Autowired
    private ObtenerTipoLimitePorIdRepository obtenerTipoLimitePorIdRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, timeout = 30, rollbackFor = PlataformaBaseException.class)
    public ValidacionResponse validacion(TipoLimiteFull request, PerfilUser perfilUser)
            throws PlataformaBaseException {

        LOGGER.info("Validando Version Tipo Limite...");


        assertTrue(MSG_ERROR_PERFIL_USER, perfilUser != null);

        Long idVersionTipoLimite = tipoLimiteService.guardarConfiguracion(request, perfilUser.getUsuario());
        ValidacionResponse response = valida(request.getAtributos());

        if(response.isValidado()){
            actualizaEstadoTipoLimiteVersionRepository.ejecutar(idVersionTipoLimite,
                                                                EstadoTipoLimiteEnum.EN_PROCESO,
                                                                perfilUser.getUsuario());
        }

        TipoLimiteFull tipoLimiteFull = obtenerTipoLimitePorIdRepository.ejecutar(idVersionTipoLimite);

        response.setId(idVersionTipoLimite);
        response.setIdTipoLimite(tipoLimiteFull.getIdTipoLimite());

        return response;
    }

    private ValidacionResponse valida(List<Atributo> atributos){

        List<AtributoValidacion> response = ValidacionUtil.creaResponse(atributos);

        validaConfiguracion(atributos, response);
        validaVencimientoMaxCurse(atributos, response);
        validaMontoLimite(atributos, response);
        validaFechaMaxCurse(atributos, response);
        validaReutilizable(atributos, response);
        validaCleanUp(atributos, response);

        return new ValidacionResponse.Builder()
                .validado(ValidacionUtil.isValidado(response))
                .atributos(response)
                .build();
    }

    private void validaConfiguracion(List<Atributo> atributos, List<AtributoValidacion> response){

        for (Atributo atributo : atributos){
            if (!ValidacionUtil.validaExisteCategoriaSeleccionada(atributo.getCategorias())){
                actualizaValidacionAtributo(response, atributo.getCodigo(), Boolean.FALSE,
                        MSG_ERROR_CAMPOS_INCOMPLETOS.getMensaje());
            }
        }
    }

    private void validaVencimientoMaxCurse(List<Atributo> atributos, List<AtributoValidacion> response){

        Atributo vencMaxCurse = ValidacionUtil.getAtributo(atributos, ATRIBUTO_VENCIMIENTO_MAX_CURSE);

        if(vencMaxCurse != null && !CategoriaAtributoEnum.BASICO.equals(getCategoriaAtributo(vencMaxCurse))){
            VariableAtributo fechaCriterio =
                    ValidacionUtil.getVariable(vencMaxCurse.getVariables(), VARIABLE_FECHA_CRITERIO);
            ItemVariable criterioSeleccionado = ValidacionUtil.getItemSeleccionado(fechaCriterio.getItems());
            if(criterioSeleccionado != null){
                validaCriteriosVencimientoMaxCurse(criterioSeleccionado, vencMaxCurse,
                        atributos, response);
            }else{
                actualizaValidacionAtributo(response, vencMaxCurse.getCodigo(),
                        Boolean.FALSE, MSG_ERROR_CAMPOS_INCOMPLETOS.getMensaje());
            }
        }
    }

    private void validaCriteriosVencimientoMaxCurse(ItemVariable criterioSeleccionado, Atributo vencMaxCurse,
                                                    List<Atributo> atributos, List<AtributoValidacion> response){

        Atributo atributo;

        if(FECHA_CRITERIO_1.equals(objectToString(criterioSeleccionado.getValor())) ||
                FECHA_CRITERIO_3.equals(objectToString(criterioSeleccionado.getValor()))){
            atributo = ValidacionUtil.getAtributo(atributos, ATRIBUTO_PLAZO_LIMITE);
            if(atributo == null){
                actualizaValidacionAtributo(response, vencMaxCurse.getCodigo(),
                        Boolean.FALSE, MSG_ERROR_PLAZO.getMensaje());
            }
        }else if(FECHA_CRITERIO_2.equals(objectToString(criterioSeleccionado.getValor())) ||
                FECHA_CRITERIO_4.equals(objectToString(criterioSeleccionado.getValor()))){
            atributo = ValidacionUtil.getAtributo(atributos, ATRIBUTO_PLAZO_MAX_OPERACIONES);
            if(atributo == null){
                actualizaValidacionAtributo(response, vencMaxCurse.getCodigo(), Boolean.FALSE,
                        MSG_ERROR_PLAZO_MAX_OPERACIONES.getMensaje());
            }
        }
    }

    private void validaMontoLimite(List<Atributo> atributos, List<AtributoValidacion> response) {

        Atributo monto = ValidacionUtil.getAtributo(atributos, ATRIBUTO_MONTO_LIMITE);

        if(monto != null){
            Atributo monedaCurse = ValidacionUtil.getAtributo(atributos, ATRIBUTO_MONEDA_CURSE);
            if(monedaCurse == null){
                actualizaValidacionAtributo(response, monto.getCodigo(),
                        Boolean.FALSE, MSG_ERROR_MONEDAS_CURSE.getMensaje());
            }
        }
    }

    private void validaCleanUp(List<Atributo> atributos, List<AtributoValidacion> response) {

        Atributo cleanUp = ValidacionUtil.getAtributo(atributos, ATRIBUTO_CLEAN_UP);

        if(cleanUp != null){
            Atributo monto = ValidacionUtil.getAtributo(atributos, ATRIBUTO_MONTO_LIMITE);
            if(monto == null){
                actualizaValidacionAtributo(response, cleanUp.getCodigo(),
                        Boolean.FALSE, MSG_ERROR_MONTO_LIM_CLEAN_UP.getMensaje());
            }
        }
    }

    private void validaFechaMaxCurse(List<Atributo> atributos, List<AtributoValidacion> response) {
        Atributo fechaMaxCurse = ValidacionUtil.getAtributo(atributos, ATRIBUTO_FECHA_MAX_CURSE);

        if(fechaMaxCurse != null){
            validaDobleLogica(fechaMaxCurse, atributos, response);
        }
    }

    private void validaDobleLogica(Atributo fechaMaxCurse, List<Atributo> atributos,
                                   List<AtributoValidacion> response) {

        VariableAtributo dobleLogica =
                ValidacionUtil.getVariable(fechaMaxCurse.getVariables(), VARIABLE_DOBLE_LOGICA);
        if (dobleLogica != null && "1".equals(objectToString(dobleLogica.getValor()))){
            Atributo plazo = ValidacionUtil.getAtributo(atributos, ATRIBUTO_PLAZO);
            if(plazo == null){
                actualizaValidacionAtributo(response, fechaMaxCurse.getCodigo(),
                        Boolean.FALSE, MSG_ERROR_PLAZO_FMC.getMensaje());
            }
        }
    }

    private void validaReutilizable(List<Atributo> atributos, List<AtributoValidacion> response) {
        Atributo reutilizable = ValidacionUtil.getAtributo(atributos, ATRIBUTO_REUTILIZABLE);
        ItemVariable itemSeleccionado;

        if (reutilizable != null) {
            itemSeleccionado = ValidacionUtil.getItemSeleccionado(reutilizable.getVariables().get(0).getItems());
            if (itemSeleccionado != null) {
                validaCriterioReutilizable(objectToString(itemSeleccionado.getValor()), atributos, reutilizable,
                        response);
            }else{
                actualizaValidacionAtributo(response, reutilizable.getCodigo(),
                        Boolean.FALSE, MSG_ERROR_CAMPOS_INCOMPLETOS.getMensaje());
            }
        }
    }

    private void validaCriterioReutilizable(String valor, List<Atributo> atributos,
                                            Atributo reutilizable, List<AtributoValidacion> response){
        if ("Si".equals(valor)) {
            Atributo cursesParciales = ValidacionUtil.getAtributo(atributos, ATRIBUTO_CURSES_PARCIALES);
            if (cursesParciales != null) {
                validaCursesParciales(cursesParciales, response, reutilizable);
            }
        }else{
            Atributo cleanUp = ValidacionUtil.getAtributo(atributos, ATRIBUTO_CLEAN_UP);
            if (cleanUp != null) {
                actualizaValidacionAtributo(response, reutilizable.getCodigo(),
                        Boolean.FALSE, MSG_ERROR_CLEAN_UP.getMensaje());
                actualizaValidacionAtributo(response, cleanUp.getCodigo(),
                        Boolean.FALSE, MSG_ERROR_CLEAN_UP.getMensaje());
            }
        }
    }

    private void validaCursesParciales(Atributo cursesParciales,
                                       List<AtributoValidacion> response,
                                       Atributo reutilizable){
        ItemVariable itemSeleccionado =
                ValidacionUtil.getItemSeleccionado(cursesParciales.getVariables().get(0).getItems());
        if (itemSeleccionado != null) {
            if ("No".equals(objectToString(itemSeleccionado.getValor()))) {
                actualizaValidacionAtributo(response, cursesParciales.getCodigo(), Boolean.FALSE,
                        MSG_ERROR_CURSES_PARCIALES.getMensaje());
                actualizaValidacionAtributo(response, reutilizable.getCodigo(), Boolean.FALSE,
                        MSG_ERROR_CURSES_PARCIALES.getMensaje());
            }
        }else{
            actualizaValidacionAtributo(response, reutilizable.getCodigo(),
                    Boolean.FALSE, MSG_ERROR_CAMPOS_INCOMPLETOS.getMensaje());
        }
    }

    private static void actualizaValidacionAtributo(List<AtributoValidacion> response,
                                             String codAtributo,
                                             Boolean validado,
                                             String mensaje){
        for (AtributoValidacion atributoValidacion : response){
            if(codAtributo.equals(atributoValidacion.getCodAtributo()) && atributoValidacion.isValidado()){
                atributoValidacion.setValidado(validado);
                atributoValidacion.setMensaje(mensaje);
            }
        }
    }
}
