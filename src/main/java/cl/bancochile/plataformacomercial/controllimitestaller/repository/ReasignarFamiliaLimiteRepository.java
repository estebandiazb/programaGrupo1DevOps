package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ReasignarLimiteRequest;

public interface ReasignarFamiliaLimiteRepository {

    void ejecutar(ReasignarLimiteRequest reasignarLimite) throws PlataformaBaseException;
}
