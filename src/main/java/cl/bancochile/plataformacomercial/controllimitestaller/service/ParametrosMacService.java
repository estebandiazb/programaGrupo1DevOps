package cl.bancochile.plataformacomercial.controllimitestaller.service;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ParametroMac;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.ParametrosMacEnum;

import java.util.List;

public interface ParametrosMacService {

    ParametroMac obtenerParametrosMac()
            throws PlataformaBaseException;

    List<ParametroMac>  obtenerRatingVigente(String parametro)
            throws PlataformaBaseException;

    void actualizaRatingVigente(ParametroMac parametroMac, PerfilUser perfilUser)
            throws PlataformaBaseException;

}
