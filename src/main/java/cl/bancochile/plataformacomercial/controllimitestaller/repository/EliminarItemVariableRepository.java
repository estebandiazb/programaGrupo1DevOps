package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;

public interface EliminarItemVariableRepository {

    void ejecutar(long idItemVariable) throws PlataformaBaseException;
}
