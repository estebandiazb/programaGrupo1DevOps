package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;

public interface EliminarFamiliaLimiteRepository {

    void ejecutar(long idFamilia, String usuarioActualizacion) throws PlataformaBaseException;

}
