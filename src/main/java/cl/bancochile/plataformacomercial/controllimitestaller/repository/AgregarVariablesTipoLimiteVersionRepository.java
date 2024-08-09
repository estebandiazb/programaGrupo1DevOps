package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableAtributo;

public interface AgregarVariablesTipoLimiteVersionRepository {
    long ejecutar(long idTipoLimiteVersion, VariableAtributo variable) throws PlataformaBaseException;
}
