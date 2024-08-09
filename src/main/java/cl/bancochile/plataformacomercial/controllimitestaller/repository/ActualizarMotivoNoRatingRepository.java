package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.MotivoNoRating;

public interface ActualizarMotivoNoRatingRepository {

    void ejecutar(MotivoNoRating motivoNoRating) throws PlataformaBaseException;

    long ejecutar(MotivoNoRating motivoNoRating, String nombreUsuario, String usuario) throws PlataformaBaseException;
}
