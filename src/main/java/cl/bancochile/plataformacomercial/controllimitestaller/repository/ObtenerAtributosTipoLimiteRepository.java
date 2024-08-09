package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Atributo;

import java.util.List;

public interface ObtenerAtributosTipoLimiteRepository {
    List<Atributo> ejecutar(Long idTipoLimite) throws PlataformaBaseException;
}
