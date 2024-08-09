package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;

public interface EliminarAtributoTipoLimiteRepository {

    void ejecutar(Long idFamilia, String codigoAtributo) throws PlataformaBaseException;
}

