package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimiteFull;

public interface CrearTipoLimiteVersionRepository {
    long ejecutar(TipoLimiteFull tipoLimite) throws PlataformaBaseException;
}
