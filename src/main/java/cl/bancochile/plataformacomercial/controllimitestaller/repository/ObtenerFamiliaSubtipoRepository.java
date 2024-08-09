package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Variable;

import java.util.List;

public interface ObtenerFamiliaSubtipoRepository {

    List<Variable> ejecutar() throws PlataformaBaseException;

}
