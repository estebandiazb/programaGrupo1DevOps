package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableAtributo;

import java.util.List;

public interface ObtenerVariablesAtributosTipoLimiteRepository {
    List<VariableAtributo> ejecutar(Long idTipoLimite) throws PlataformaBaseException;
}
