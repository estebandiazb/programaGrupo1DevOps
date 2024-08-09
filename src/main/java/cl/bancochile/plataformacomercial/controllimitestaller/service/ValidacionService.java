package cl.bancochile.plataformacomercial.controllimitestaller.service;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimiteFull;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ValidacionResponse;

public interface ValidacionService {

    ValidacionResponse validacion(TipoLimiteFull request, PerfilUser perfilUser)
            throws PlataformaBaseException;



}
