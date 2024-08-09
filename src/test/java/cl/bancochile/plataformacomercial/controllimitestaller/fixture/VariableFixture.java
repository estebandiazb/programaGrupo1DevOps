package cl.bancochile.plataformacomercial.controllimitestaller.fixture;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Variable;

import java.util.ArrayList;
import java.util.List;

public class VariableFixture {


    public static Variable getFamiliaSubtipo(String nombre) {
        List<ItemVariable> subtipos = new ArrayList<>();
        subtipos.add(new ItemVariable.Builder()
                .id(1L)
                .valor("subtipo 1")
                .build());
        return new Variable.Builder()
                .id(1L)
                .nombre(nombre)
                .items(subtipos)
                .build();
    }

    public static Variable getFamiliaSubtipo(String nombre, List<ItemVariable> subtipos) {
        return new Variable.Builder()
                .id(1L)
                .nombre(nombre)
                .items(subtipos)
                .build();
    }

    public static List<ItemVariable> getSubtipos(String... subtipos) {
        return getSubtipos(0L, subtipos);
    }

    public static List<ItemVariable> getSubtipos(Long id, String... subtipos) {
        List<ItemVariable> lista = new ArrayList<>();
        if (subtipos != null) {
            long gid = 1;
            for (String subtipo : subtipos) {
                lista.add(new ItemVariable.Builder()
                        .id(id == null ? null : gid++)
                        .valor(subtipo)
                        .build());
            }
        }
        return lista;
    }
}
