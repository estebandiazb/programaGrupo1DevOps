package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;

public interface AgregarItemVariablesTipoLimiteVersionRepository {
    void ejecutar(long idVariableTipoLimite, ItemVariable itemVariable) throws PlataformaBaseException;
}
