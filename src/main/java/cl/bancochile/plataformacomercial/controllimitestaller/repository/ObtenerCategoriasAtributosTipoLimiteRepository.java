package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.CategoriaSeleccionable;

import java.util.List;

public interface ObtenerCategoriasAtributosTipoLimiteRepository {
    List<CategoriaSeleccionable> ejecutar(Long idTipoLimite) throws PlataformaBaseException;
}
