package cl.bancochile.plataformacomercial.controllimitestaller.repository;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ParametroMac;

import java.util.List;


public interface ObtenerRatingVigenteRepository {

    List<ParametroMac> ejecutar(String parametro) throws PlataformaBaseException;
}
