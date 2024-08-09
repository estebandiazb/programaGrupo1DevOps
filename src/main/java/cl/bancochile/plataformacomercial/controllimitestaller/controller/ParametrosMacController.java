package cl.bancochile.plataformacomercial.controllimitestaller.controller;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ParametroMac;
import cl.bancochile.plataformacomercial.controllimitestaller.service.ParametrosMacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller contenedor de controladores para parametros mac
 */
@RestController
@RequestMapping(value = "/parametros-mac")
public class ParametrosMacController {

    @Autowired
    private ParametrosMacService parametrosMacService;

    /**
     * consulta obtiene parametros mac
     *
     * @return parametro mac
     * @throws PlataformaBaseException si existe error
     * @see ParametroMac
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public ParametroMac obtenerParametrosMac()
            throws PlataformaBaseException {
        return this.parametrosMacService.obtenerParametrosMac();
    }

    /**
     * consulta obtiene rating vigente
     *
     * @param parametro variable parametro
     * @return lista de parametro mac
     * @throws PlataformaBaseException si existe error
     * @see <List<ParametroMac>>
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/rating-vigente/{parametro}", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public List<ParametroMac> obtenerRatingVigente(@PathVariable String parametro)
            throws PlataformaBaseException {
        return this.parametrosMacService.obtenerRatingVigente(parametro);
    }

    /**
     * actualiza valor rating vigente
     *
     * @param parametroMac parametros mac
     * @param perfilUser datos de usuario
     * @throws PlataformaBaseException controla Errores
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/rating-vigente", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public void actualizaRatingVigente(@RequestBody ParametroMac parametroMac,PerfilUser perfilUser)
            throws PlataformaBaseException {
        this.parametrosMacService.actualizaRatingVigente(parametroMac, perfilUser);
    }

}
