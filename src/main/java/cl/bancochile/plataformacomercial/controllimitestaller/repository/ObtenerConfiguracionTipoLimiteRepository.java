package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableLimite;

import java.util.List;

public interface ObtenerConfiguracionTipoLimiteRepository {

    List<VariableLimite> ejecutar(Long idTipoLimite) throws PlataformaBaseException;
}
