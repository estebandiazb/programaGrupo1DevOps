package cl.bancochile.plataformacomercial.controllimitestaller.controller;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Variable;
import cl.bancochile.plataformacomercial.controllimitestaller.service.SubTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller contenedor de controladores para subtipos
 */
@RestController
@RequestMapping(value = "/subtipos")
public class SubTipoController {

    @Autowired
    private SubTipoService subTipoService;

    /**
     * Creacion de Familia SubTipos en Variables Transversales
     *
     * @param familiaSubtipo informacion familia sub tipo
     * @return Id familia creada
     * @throws PlataformaBaseException si existe error
     * @see Variable salida de Id familia subtipo
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/familia-subtipo", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public Variable creacionFamiliaSubtipos(@RequestBody Variable familiaSubtipo)
            throws PlataformaBaseException {
        return this.subTipoService.crearFamiliaSubtipo(familiaSubtipo.getNombre());
    }

    /**
     * Creacion de SubTipos en Variables Transversales
     *
     * @param familiaSubtipo informacion familia sub tipo
     * @throws PlataformaBaseException si existe error
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/guardar-subtipo", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public void guardarSubtipos(@RequestBody Variable familiaSubtipo)
            throws PlataformaBaseException {
        this.subTipoService.guardarSubtipo(familiaSubtipo);
    }

    /**
     * consulta obtiene subtipos
     *
     * @return Listado de familias de subtipos
     * @throws PlataformaBaseException si existe error
     * @see <List<LimiteList>
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/familias-subtipo", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public List<Variable> obtieneFamiliaSubtipos()
            throws PlataformaBaseException {
        return this.subTipoService.obtenerFamiliasSubtipo();
    }

    /**
     * consulta obtiene subtipos por id
     *
     * @param idVariable   id variable
     * @return Listado de limites
     * @throws PlataformaBaseException si existe error
     * @see <List<LimiteList>
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/familias-subtipo/{idVariable}", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public List<ItemVariable> obtieneSubtiposPorId(@PathVariable Long idVariable)
            throws PlataformaBaseException {
        return this.subTipoService.obtenerItemPorId(idVariable);
    }

    /**
     * elimina familia subtipos
     *
     * @param idFamilia   id variable
     * @return Listado de limites
     * @throws PlataformaBaseException si existe error
     * @see <List<LimiteList>
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/familia-subtipo/{idFamilia}", method = RequestMethod.DELETE,
            produces = "application/json;charset=UTF-8")
    public void eliminaFamiliaSubtipo(@PathVariable Long idFamilia)
            throws PlataformaBaseException {
        this.subTipoService.eliminaFamiliaSubtipo(idFamilia);
    }

}
