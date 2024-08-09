package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ResumenAtributos;

public interface ObtenerResumenAtributosRepository {

    ResumenAtributos ejecutar(long idTipoLimiteVersion) throws PlataformaBaseException;

}
