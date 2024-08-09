package cl.bancochile.plataformacomercial.controllimitestaller.controller;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.MotivoNoRating;
import cl.bancochile.plataformacomercial.controllimitestaller.service.TextosService;
import cl.bancochile.plataformacomercial.lib.controllimites.common.domain.Bitacora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller contenedor de controladores para textos
 */
@RestController
@RequestMapping(value = "/textos")
public class TextosController {

    @Autowired
    private TextosService textosService;

    /**
     * Devuelve listado de motivos no rating en estado activado
     *
     * @return List<MotivoNoRating> listado de morivos
     * @throws PlataformaBaseException si existe error
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/motivos-no-rating", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public List<MotivoNoRating> obtenerMotivosNoRating() throws PlataformaBaseException {
        return textosService.obtenerMotivosNoRating();
    }

    /**
     * Agrega un motivo de no rating
     *
     * @param motivo informacion motivo no rating
     * @param perfilUser informacion del usuario en sesion
     * @throws PlataformaBaseException si existe error
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/motivos-no-rating/agregar", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public void agregarMotivosNoRating(@RequestBody MotivoNoRating motivo, PerfilUser perfilUser)
            throws PlataformaBaseException {
        textosService.agregarMotivosNoRating(motivo, perfilUser);
    }

    /**
     * Eliminacion listado de motivos no rating
     *
     * @param idMotivoNoRating  identificador del motivo no rating
     * @throws PlataformaBaseException si existe error
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/motivos-no-rating/{idMotivoNoRating}", method = RequestMethod.DELETE,
            produces = "application/json;charset=UTF-8")
    public void eliminar(@PathVariable Long idMotivoNoRating)  throws PlataformaBaseException {
        textosService.eliminar(idMotivoNoRating);
    }

    /**
     * Actualizacion orden de listado de motivos no rating
     *
     * @param motivosNoRating  listado motivos no rating
     * @throws PlataformaBaseException si existe error
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/motivos-no-rating/orden", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public void actualizarOrden(@RequestBody List<MotivoNoRating> motivosNoRating) throws PlataformaBaseException {
        textosService.actualizarOrden(motivosNoRating);
    }

    /**
     * Actualizacion motivo no rating
     *
     * @param motivoNoRating  identificador del motivo no rating
     * @param perfilUser informacion del usuario quien realiza la accion
     * @throws PlataformaBaseException si existe error
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/motivos-no-rating", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public void actualizarMotivo(@RequestBody MotivoNoRating motivoNoRating, PerfilUser perfilUser)
            throws PlataformaBaseException {
        textosService.actualizarMotivo(motivoNoRating, perfilUser);
    }

    /**
     * Actualizacion motivo no rating
     *
     * @param idMotivoNoRating id de motivo no rating
     * @return List<Bitacora> response
     * @throws PlataformaBaseException si existe error
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/motivos-no-rating/bitacora/{idMotivoNoRating}", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public List<Bitacora> obtenerMotivoNoRatingBitacora(@PathVariable Long idMotivoNoRating)
            throws PlataformaBaseException {
        return textosService.obtenerMotivoNoRatingBitacora(idMotivoNoRating);
    }

}
