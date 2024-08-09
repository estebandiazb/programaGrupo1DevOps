package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ConsultarTipoLimitesRequest;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimite;

import java.util.List;

public interface ObtenerTipoLimitesRepository {

    List<TipoLimite> ejecutar(ConsultarTipoLimitesRequest request) throws PlataformaBaseException;

}
