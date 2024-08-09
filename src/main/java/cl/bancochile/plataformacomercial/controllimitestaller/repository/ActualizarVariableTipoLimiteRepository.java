package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableLimite;

public interface ActualizarVariableTipoLimiteRepository {

    void ejecutar(VariableLimite variableLimite) throws PlataformaBaseException;
}

