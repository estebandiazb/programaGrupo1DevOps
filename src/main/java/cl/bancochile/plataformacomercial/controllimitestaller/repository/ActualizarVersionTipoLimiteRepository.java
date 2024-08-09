package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimiteFull;

public interface ActualizarVersionTipoLimiteRepository {

    void ejecutar(TipoLimiteFull versionTipoLimite) throws PlataformaBaseException;
}
