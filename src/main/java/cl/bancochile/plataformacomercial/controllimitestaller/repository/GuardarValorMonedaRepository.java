package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ValorMonedaBanco;

public interface GuardarValorMonedaRepository {

    void ejecutar(ValorMonedaBanco valorMonedaBanco) throws PlataformaBaseException;

}
