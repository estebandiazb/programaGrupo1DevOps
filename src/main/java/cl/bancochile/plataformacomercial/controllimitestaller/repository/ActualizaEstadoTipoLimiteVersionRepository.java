package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;

public interface ActualizaEstadoTipoLimiteVersionRepository {

    void ejecutar(long idVersionTipoLimite, EstadoTipoLimiteEnum estado, String usuario)
            throws PlataformaBaseException;
}
