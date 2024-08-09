package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.MonedaBanco;

public interface GuardarMonedaRepository {

    void ejecutar(MonedaBanco monedaBanco) throws PlataformaBaseException;

}
