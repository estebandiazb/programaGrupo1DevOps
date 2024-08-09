package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.CategoriaSeleccionable;

public interface EditarCategoriaTipoLimiteRepository {

    void ejecutar(Long idTipoLimite, Long idAtributo, CategoriaSeleccionable categoria, String comentario)
            throws PlataformaBaseException;
}
