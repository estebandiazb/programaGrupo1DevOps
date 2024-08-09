package cl.bancochile.plataformacomercial.controllimitestaller.controller;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ReasignarLimiteRequest;
import cl.bancochile.plataformacomercial.controllimitestaller.service.FamiliaLimiteService;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.FamiliaLimite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller contenedor de servicios REST para familia de limites
 */
@RestController
@RequestMapping(value = "/familia-limites")
public class FamiliaLimiteController {

    @Autowired
    private FamiliaLimiteService familiaLimiteService;

    /**
     * Creacion Familia de limite
     *
     * @param familiaLimite informacion familia sub tipo
     * @param perfilUser    informacion del usuario quien realiza la accion
     * @return FamiliaLimite informaacion de la familia limite creada
     * @throws PlataformaBaseException si existe error
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/crear", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public FamiliaLimite crear(@RequestBody FamiliaLimite familiaLimite, PerfilUser perfilUser)
            throws PlataformaBaseException {
        return familiaLimiteService.crear(familiaLimite, perfilUser);
    }

    /**
     * Modificacion Familia de limites
     *
     * @param familiaLimite informacion familia sub tipo
     * @param perfilUser    informacion del usuario quien realiza la accion
     * @throws PlataformaBaseException si existe error
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/guardar", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public void modificar(@RequestBody FamiliaLimite familiaLimite, PerfilUser perfilUser)
            throws PlataformaBaseException {
        familiaLimiteService.guardar(familiaLimite, perfilUser);
    }

    /**
     * Eliminacion Familia de limites
     *
     * @param idFamilia  identificador de la familia de limite a eliminar
     * @param perfilUser informacion del usuario quien realiza la accion
     * @throws PlataformaBaseException si existe error
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/eliminar/{idFamilia}", method = RequestMethod.DELETE,
            produces = "application/json;charset=UTF-8")
    public void eliminar(@PathVariable Long idFamilia, PerfilUser perfilUser)
            throws PlataformaBaseException {
        familiaLimiteService.eliminar(idFamilia, perfilUser);
    }

    /**
     * Cambio de familia de limites para un tipo de limite
     *
     * @param reasignarLimiteRequest informacion familia sub tipo
     * @param perfilUser             informacion del usuario quien realiza la accion
     * @throws PlataformaBaseException si existe error
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/reasignar", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public void reasignar(@RequestBody ReasignarLimiteRequest reasignarLimiteRequest, PerfilUser perfilUser)
            throws PlataformaBaseException {
        familiaLimiteService.reasignar(reasignarLimiteRequest, perfilUser);
    }

    /**
     * consulta obtiene familias de limites
     *
     * @return Listado de familias de limites
     * @throws PlataformaBaseException si existe error
     * @see ResponseEntity < List <FamiliaLimite>
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public List<FamiliaLimite> obtieneFamiliasLimites()
            throws PlataformaBaseException {
        return this.familiaLimiteService.obtenerFamiliaLimite(null);
    }

    /**
     * consulta obtiene subtipos por id
     *
     * @param idFamilia id familia
     * @return Listado de tipos de limites
     * @throws PlataformaBaseException si existe error
     * @see ResponseEntity < List <TipoLimiteVersion>
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/{idFamilia}", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public FamiliaLimite obtieneFamiliaLimitePorId(@PathVariable Long idFamilia)
            throws PlataformaBaseException {
        return this.familiaLimiteService.obtenerFamiliaLimitePorId(idFamilia);
    }

}
