package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.TipoLimiteVersion;

import java.util.List;

public interface ObtenerTipoLimitePorIdFamiliaRepository {

    List<TipoLimiteVersion> ejecutar(Long idVariable) throws PlataformaBaseException;
}
