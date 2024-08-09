package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;

public interface ObtenerInfoNuevoTipoLimiteRepository {
    long ejecutar(long idFamiliaTipoLimite, String prefijo) throws PlataformaBaseException;
}
