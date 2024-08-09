package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimiteFull;

public interface ObtenerTipoLimitePorIdRepository {
    TipoLimiteFull ejecutar(long idVersionTipoLimite);
}
