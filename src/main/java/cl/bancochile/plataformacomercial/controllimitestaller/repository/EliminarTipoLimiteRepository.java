package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.TipoLimiteVersion;

public interface EliminarTipoLimiteRepository {

    void ejecutar(long id)throws PlataformaBaseException;
}
