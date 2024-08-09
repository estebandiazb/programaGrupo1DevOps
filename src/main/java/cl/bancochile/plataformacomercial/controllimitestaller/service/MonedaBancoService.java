package cl.bancochile.plataformacomercial.controllimitestaller.service;

import cl.bancochile.plataforma.shared.lib.cdnsession.model.service.PerfilUser;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.MonedaBanco;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ValorMonedaBanco;

import java.util.List;

public interface MonedaBancoService {

    List<MonedaBanco> obtencionMonedas() throws PlataformaBaseException;

    List<MonedaBanco> obtencionMonedasSgt() throws PlataformaBaseException;

    List<MonedaBanco> guardarMonedas(List<MonedaBanco> monedas, PerfilUser perfilUser)
            throws PlataformaBaseException;

    void eliminacionMoneda(long idMoneda, PerfilUser perfilUser)
            throws PlataformaBaseException;

    ValorMonedaBanco guardarValorMoneda(ValorMonedaBanco valorMonedaBanco, PerfilUser perfilUser)
            throws PlataformaBaseException;



}
