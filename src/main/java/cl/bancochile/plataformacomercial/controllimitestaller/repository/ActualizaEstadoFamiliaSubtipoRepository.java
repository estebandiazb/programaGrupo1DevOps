package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;

public interface ActualizaEstadoFamiliaSubtipoRepository {

    void ejecutar(long idFamiliaSubtipo, EstadoTipoLimiteEnum estado) throws PlataformaBaseException;
}
