package cl.bancochile.plataformacomercial.controllimitestaller.fixture;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.CategoriaSeleccionable;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.CategoriaAtributoEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoriaSeleccionableFixture {

    public static List<CategoriaSeleccionable> getCategorias(){
        List<CategoriaSeleccionable> categorias = new ArrayList<>();

        categorias.add(new CategoriaSeleccionable.Builder()
                                .idAtributo(1L)
                                .categoria(CategoriaAtributoEnum.NORMATIVO)
                                .seleccionado(Boolean.TRUE)
                                .build());
        categorias.add(new CategoriaSeleccionable.Builder()
                                .idAtributo(2L)
                                .categoria(CategoriaAtributoEnum.BASICO)
                                .seleccionado(Boolean.FALSE)
                                .build());
        categorias.add(new CategoriaSeleccionable.Builder()
                                .idAtributo(3L)
                                .categoria(CategoriaAtributoEnum.AVANZADO)
                                .seleccionado(Boolean.TRUE)
                                .build());

        return categorias;

    }

    public static List<CategoriaSeleccionable> getCategoriasList(CategoriaSeleccionable... categorias){
        return new ArrayList<>(Arrays.asList(categorias));
    }
}
