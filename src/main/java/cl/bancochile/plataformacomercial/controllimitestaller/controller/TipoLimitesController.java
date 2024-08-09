package cl.bancochile.plataformacomercial.controllimitestaller.controller;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Atributo;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ConsultarFiltrosTipoLimitesResponse;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ConsultarTipoLimitesRequest;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ConsultarTipoLimitesResponse;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.CrearTipoLimiteRequest;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimiteFull;
import cl.bancochile.plataformacomercial.controllimitestaller.service.TipoLimiteService;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.TipoLimiteVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller contenedor de servicios REST para tipos de limites
 */
@RestController
@RequestMapping(value = "tipo-limites")
public class TipoLimitesController {

    @Autowired
    private TipoLimiteService tipoLimiteService;

    /**
     * Consultar filtros usados en la busqueda de tipos de limites
     *
     * @return ConsultarFiltrosTipoLimitesResponse
     * @throws PlataformaBaseException si hay error
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/filtros", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public ConsultarFiltrosTipoLimitesResponse consultarFiltros()
            throws PlataformaBaseException {
        return tipoLimiteService.consultarFiltroTipoLimites();
    }

    /**
     * Consultar tipos de limites de acuerdo a los criterios dados
     *
     * @param request criterios para busqueda de tipos de limites
     * @return ConsultarFiltrosTipoLimitesResponse
     * @throws PlataformaBaseException si hay error
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/listado", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public ConsultarTipoLimitesResponse consultarTipoLimites(@RequestBody ConsultarTipoLimitesRequest request)
            throws PlataformaBaseException {
        return tipoLimiteService.consultarTipoLimites(request);
    }

    /**
     * Obtener configuracion para un Tipo de Limite nuevo
     *
     * @param request del tipo de limite
     * @return TipoLimiteFull
     * @throws PlataformaBaseException si hay error
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/configuracion/nuevo",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public TipoLimiteFull obtenerTipoLimiteNuevo(@RequestBody CrearTipoLimiteRequest request)
            throws PlataformaBaseException {

        return tipoLimiteService.obtenerConfiguracionNuevoTipoLimite(request);
    }

    /**
     * Obtener configuracion para un Tipo de Limite particular
     *
     * @param idVersionTipoLimite id de version del tipo de limite
     * @return TipoLimiteFull
     * @throws PlataformaBaseException si hay error
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/configuracion/{idVersionTipoLimite}",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public TipoLimiteFull obtenerConfiguracionTipoLimite(@PathVariable long idVersionTipoLimite)
            throws PlataformaBaseException {

        return tipoLimiteService.obtenerConfiguracionVersionTipoLimite(idVersionTipoLimite);
    }

    /**
     * Obtener todos los atributos
     * @return Todos los atributos
     * @throws PlataformaBaseException si hay error
     * @see List<Atributo>
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/configuracion/atributos",
            method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public List<Atributo> obtenerAtributos()
            throws PlataformaBaseException {

        return tipoLimiteService.obtenerAtributosTipoLimite(null);
    }

    /**
     * Guardar la configuracion de un Tipo de Limite
     *
     * @param request objeto de entrada
     * @param perfilUser informacion del usuario
     * @return Long
     * @throws PlataformaBaseException si hay error
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/configuracion/", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Long guardarTipoLimite(@RequestBody TipoLimiteFull request, PerfilUser perfilUser)
            throws PlataformaBaseException {

        return tipoLimiteService.guardarConfiguracion(request, perfilUser.getUsuario());
    }

    /**
     * Activa o Desactiva un limite.
     *
     * @param request del tipo de limite
     * @param perfil usuario conectado
     * @return TipoLimiteVersion
     * @throws PlataformaBaseException si hay error
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/configuracion/actualiza-estado",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public TipoLimiteVersion activaDesactivaTipoLimite(@RequestBody TipoLimiteVersion request, PerfilUser perfil)
            throws PlataformaBaseException {

        request.setUsuarioModificacion(perfil.getUsuario());
        return tipoLimiteService.actualizaEstadoTipoLimite(request);
    }

    /**
     * Copia Tipo de limite por ID
     *
     * @param request objeto tipo de limite
     * @param perfil usuario conectado
     * @return TipoLimiteFull
     * @throws PlataformaBaseException si hay error
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/configuracion/copia-tipo-limite",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public Long copiaTipoLimite(@RequestBody TipoLimiteFull request, PerfilUser perfil)
            throws PlataformaBaseException {

        return tipoLimiteService.copiaTipoLimite(request, perfil.getUsuario());
    }

    /**
     * Eliminar Limites.
     * @param idTipoLimite id del Tipo de Limite
     * @throws PlataformaBaseException controla Errores
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/configuracion/eliminar-limite/{idTipoLimite}",
            method = RequestMethod.DELETE,
            produces = "application/json;charset=UTF-8")
    public void eliminarTipoLimite(@PathVariable Long idTipoLimite)
            throws PlataformaBaseException {

         tipoLimiteService.eliminarTipoLimite(idTipoLimite);
    }
}
