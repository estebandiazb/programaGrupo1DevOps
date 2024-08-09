package cl.bancochile.plataformacomercial.controllimitestaller.controller;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.MonedaBanco;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ValorMonedaBanco;
import cl.bancochile.plataformacomercial.controllimitestaller.service.MonedaBancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller para servicios REST de monedas taller de control de limites
 */
@RestController
@RequestMapping(value = "/monedas")
public class MonedasController {

    @Autowired
    private MonedaBancoService monedaBancoService;

    /**
     * Consulta de monedas taller
     *
     * @return Listado de monedas usadas en control de limites
     * @throws PlataformaBaseException si existe error
     * @see List<MonedaBanco>
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/listado", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<MonedaBanco> obtencionMonedas()
            throws PlataformaBaseException {
        return monedaBancoService.obtencionMonedas();
    }

    /**
     * Consulta de monedas SGT
     *
     * @return Listado de monedas del Sistema General de Tablas
     * @throws PlataformaBaseException si existe error
     * @see List<MonedaBanco>
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/listado-sgt", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<MonedaBanco> obtencionMonedasSgt()
            throws PlataformaBaseException {
        return monedaBancoService.obtencionMonedasSgt();
    }

    /**
     * Eliminar moneda taller
     *
     * @param idMoneda   identificador moneda
     * @param perfilUser informacion del usuario quien realiza la accion
     * @throws PlataformaBaseException si existe error
     * @see List<MonedaBanco>
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/eliminar/{idMoneda}",
            method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public void eliminacionMoneda(@PathVariable Long idMoneda, PerfilUser perfilUser)
            throws PlataformaBaseException {
        monedaBancoService.eliminacionMoneda(idMoneda, perfilUser);
    }

    /**
     * Guardar moneda taller
     *
     * @param monedas    Listado de monedas modificar
     * @param perfilUser informacion del usuario quien realiza la accion
     * @return listado de monedas guardadas
     * @throws PlataformaBaseException si existe error
     * @see List<MonedaBanco>
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/guardar",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<MonedaBanco> guardarMonedas(@RequestBody List<MonedaBanco> monedas, PerfilUser perfilUser)
            throws PlataformaBaseException {
        return monedaBancoService.guardarMonedas(monedas, perfilUser);
    }

    /**
     * Guardar valor moneda taller
     *
     * @param valorMonedaBanco informacion del valor de moneda a guardar
     * @param perfilUser       informacion del usuario quien realiza la accion
     * @return listado de monedas guardadas
     * @throws PlataformaBaseException si existe error
     * @see ValorMonedaBanco
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/guardar-valor",
            method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ValorMonedaBanco guardarValorMoneda(@RequestBody ValorMonedaBanco valorMonedaBanco, PerfilUser perfilUser)
            throws PlataformaBaseException {
        return monedaBancoService.guardarValorMoneda(valorMonedaBanco, perfilUser);
    }

}
