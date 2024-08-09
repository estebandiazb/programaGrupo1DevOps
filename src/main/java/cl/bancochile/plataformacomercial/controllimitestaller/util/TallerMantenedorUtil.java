package cl.bancochile.plataformacomercial.controllimitestaller.util;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.Atributo;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.CategoriaSeleccionable;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.CategoriaAtributoEnum;

import java.util.Optional;

public class TallerMantenedorUtil {

    private TallerMantenedorUtil() {
        //SONAR
    }

    public static CategoriaAtributoEnum getCategoriaAtributo(Atributo atributo) {
        return atributo.getCategorias().stream()
                .filter(CategoriaSeleccionable::isSeleccionado)
                .map(CategoriaSeleccionable::getCategoria)
                .findFirst()
                .orElse(null);
    }
}
