package cl.bancochile.plataformacomercial.controllimitestaller.controller;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.MonedaBanco;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimiteFull;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ValidacionResponse;
import cl.bancochile.plataformacomercial.controllimitestaller.service.ValidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller contenedor de controladores para subtipos
 */
@RestController
@RequestMapping(value = "/validacion")
public class ValidacionController {

    @Autowired
    private ValidacionService validacionService;

    /**
     * Eliminar moneda taller
     *
     * @param request   datos tipo limite
     * @param perfilUser informacion del usuario quien realiza la accion
     * @return ValidacionResponse
     * @throws PlataformaBaseException si existe error
     * @see ValidacionResponse
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/validar",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ValidacionResponse validacion(@RequestBody TipoLimiteFull request, PerfilUser perfilUser)
            throws PlataformaBaseException {
        return validacionService.validacion(request, perfilUser);
    }

}
