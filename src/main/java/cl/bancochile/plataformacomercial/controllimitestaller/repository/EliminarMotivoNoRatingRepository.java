package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;

public interface EliminarMotivoNoRatingRepository {

    void ejecutar(Long idMotivoNoRating) throws PlataformaBaseException;

}
