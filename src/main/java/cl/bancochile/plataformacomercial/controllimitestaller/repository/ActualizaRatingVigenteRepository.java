package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ParametroMac;

public interface ActualizaRatingVigenteRepository {

    void ejecutar(ParametroMac parametroMac) throws PlataformaBaseException;
}
