package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimite;

public interface CrearTipoLimiteRepository {
    TipoLimite ejecutar(String prefijoTipoLimite) throws PlataformaBaseException;
}
