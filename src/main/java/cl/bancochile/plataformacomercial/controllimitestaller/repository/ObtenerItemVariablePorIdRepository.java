package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;

import java.util.List;

public interface ObtenerItemVariablePorIdRepository {

    List<ItemVariable> ejecutar(Long idVariable) throws PlataformaBaseException;

}
