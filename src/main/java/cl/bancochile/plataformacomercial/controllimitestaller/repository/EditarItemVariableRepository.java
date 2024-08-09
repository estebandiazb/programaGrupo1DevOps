package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;

public interface EditarItemVariableRepository {

    void ejecutar(ItemVariable variable) throws PlataformaBaseException;
}
