package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.MotivoNoRating;

import java.util.List;

public interface ObtenerMotivosNoRatingRepository {

    List<MotivoNoRating> ejecutar();
}
