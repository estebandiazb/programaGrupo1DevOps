package cl.bancochile.plataformacomercial.controllimitestaller.fixture;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.Atributo;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.CategoriaSeleccionable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableAtributo;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.CategoriaAtributoEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AtributoFixture {

    public static Atributo getAtributo(long id,
                                       String nombre,
                                       List<CategoriaSeleccionable> categorias,
                                       List<VariableAtributo> variables,
                                       boolean isObligatorio) {
        return new Atributo.Builder()
                .id(id)
                .nombre(nombre)
                .codigo("AAAA")
                .comentario("Lalala")
                .categorias(categorias)
                .variables(variables)
                .obligatorio(isObligatorio)
                .build();
    }


    public static List<Atributo> getAtributos() {
        List<Atributo> atributos = new ArrayList<>();

        List<CategoriaSeleccionable> categorias =
                Arrays.asList(
                                new CategoriaSeleccionable.Builder()
                                .categoria(CategoriaAtributoEnum.BASICO)
                                .seleccionado(Boolean.TRUE)
                                .build(),
                                new CategoriaSeleccionable.Builder()
                                .categoria(CategoriaAtributoEnum.AVANZADO)
                                .seleccionado(Boolean.FALSE)
                                .build()
                );
        atributos.add(getAtributo(1, "test1", categorias, new ArrayList<>(), true));
        atributos.add(getAtributo(2, "test2", categorias, new ArrayList<>(), true));
        atributos.add(getAtributo(3, "test3", categorias, new ArrayList<>(), true));

        return atributos;
    }

}
