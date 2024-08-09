package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;

public interface EliminarFamiliaSubtipoRepository {

    void ejecutar(Long idFamilia) throws PlataformaBaseException;

}
