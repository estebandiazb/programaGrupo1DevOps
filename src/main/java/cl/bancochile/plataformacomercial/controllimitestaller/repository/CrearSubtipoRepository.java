package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;

public interface CrearSubtipoRepository {

    void ejecutar(ItemVariable subtipo, long idFamiliaSubtipo) throws PlataformaBaseException;
}
