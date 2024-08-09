package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.FamiliaLimite;

public interface ModificarFamiliaLimiteRepository {

    void ejecutar(FamiliaLimite familiaLimite) throws PlataformaBaseException;
}
