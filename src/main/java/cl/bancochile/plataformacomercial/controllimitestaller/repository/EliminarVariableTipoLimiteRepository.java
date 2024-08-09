package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariableLimite;

public interface EliminarVariableTipoLimiteRepository {

    void ejecutar(ItemVariableLimite itemVariable) throws PlataformaBaseException;
}
