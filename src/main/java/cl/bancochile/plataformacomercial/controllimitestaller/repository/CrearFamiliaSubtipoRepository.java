package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;

public interface CrearFamiliaSubtipoRepository {

    long ejecutar(String nombreFamiliaSubtipo) throws PlataformaBaseException;
}
