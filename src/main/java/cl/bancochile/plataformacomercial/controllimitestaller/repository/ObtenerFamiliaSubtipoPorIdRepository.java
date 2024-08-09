package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Variable;

public interface ObtenerFamiliaSubtipoPorIdRepository {

    Variable ejecutar(long idFamiliaSubtipo) throws PlataformaBaseException;
}
