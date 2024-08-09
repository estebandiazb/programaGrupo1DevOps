package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.ValorMonedaBanco;

public interface ObtenerValorMonedaRepository {

    ValorMonedaBanco ejecutar(long idMoneda);

    ValorMonedaBanco ejecutar(String codigo);

}
