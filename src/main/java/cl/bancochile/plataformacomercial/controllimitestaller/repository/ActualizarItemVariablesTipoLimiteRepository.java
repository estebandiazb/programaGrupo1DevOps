package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariableLimite;

public interface ActualizarItemVariablesTipoLimiteRepository {

    void ejecutar(ItemVariableLimite itemVariableLimite) throws PlataformaBaseException;
}
