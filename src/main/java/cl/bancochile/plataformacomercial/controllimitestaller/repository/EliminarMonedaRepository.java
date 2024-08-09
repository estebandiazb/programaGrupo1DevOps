package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;

public interface EliminarMonedaRepository {

    void ejecutar(long idMoneda, String idUsuario) throws PlataformaBaseException;

}
