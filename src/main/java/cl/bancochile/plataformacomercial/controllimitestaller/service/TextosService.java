package cl.bancochile.plataformacomercial.controllimitestaller.service;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.MotivoNoRating;
import cl.bancochile.plataformacomercial.lib.controllimites.common.domain.Bitacora;

import java.util.List;

public interface TextosService {

    List<MotivoNoRating> obtenerMotivosNoRating() throws PlataformaBaseException;

    void agregarMotivosNoRating(MotivoNoRating motivoNoRating, PerfilUser usuario) throws PlataformaBaseException;

    void eliminar (Long idMotivoNoRating) throws PlataformaBaseException;

    void actualizarOrden(List<MotivoNoRating> motivosNoRating) throws PlataformaBaseException;

    void actualizarMotivo(MotivoNoRating motivoNoRating, PerfilUser usuario) throws PlataformaBaseException;

    List<Bitacora> obtenerMotivoNoRatingBitacora(Long idMotivoNoRating) throws PlataformaBaseException;
}
