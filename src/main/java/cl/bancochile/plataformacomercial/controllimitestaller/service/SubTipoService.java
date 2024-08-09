package cl.bancochile.plataformacomercial.controllimitestaller.service;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Variable;

import java.util.List;

public interface SubTipoService {

    Variable crearFamiliaSubtipo(String nombreFamiliaSubtipo) throws PlataformaBaseException;

    void guardarSubtipo(Variable familiaSubtipo) throws PlataformaBaseException;

    List<Variable> obtenerFamiliasSubtipo() throws PlataformaBaseException;

    List<ItemVariable> obtenerItemPorId(Long idVariable) throws PlataformaBaseException;

    void eliminaFamiliaSubtipo(Long idFamilia) throws PlataformaBaseException;
}
