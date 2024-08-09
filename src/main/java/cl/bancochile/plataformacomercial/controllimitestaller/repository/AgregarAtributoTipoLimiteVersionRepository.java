package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Atributo;

public interface AgregarAtributoTipoLimiteVersionRepository {
    long ejecutar(Long idTipoLimiteVersion, Atributo atributo) throws PlataformaBaseException;
}
