package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimite;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimiteFull;

public interface ActualizaEstadoTipoLimite2Repository {

    void ejecutar(TipoLimite tipoLimite) throws PlataformaBaseException;
}
