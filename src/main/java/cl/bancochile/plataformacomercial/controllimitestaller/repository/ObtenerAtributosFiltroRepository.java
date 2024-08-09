package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Filtro;

import java.util.List;

public interface ObtenerAtributosFiltroRepository {

    List<Filtro> ejecutar() throws PlataformaBaseException;

}
