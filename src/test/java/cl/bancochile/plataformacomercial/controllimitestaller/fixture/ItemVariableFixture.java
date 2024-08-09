package cl.bancochile.plataformacomercial.controllimitestaller.fixture;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemVariableFixture {

    public static ItemVariable getItemVariable(long id, long idVariable, String valor, boolean isSeleccionado) {

        return new ItemVariable.Builder()
                .id(id)
                .idVariable(idVariable)
                .valor(valor)
                .seleccionado(isSeleccionado)
                .build();
    }

    public static List<ItemVariable> getItemsVariable(ItemVariable... item){
        return new ArrayList<>(Arrays.asList(item));
    }

    public static List<ItemVariable> getItemsVariables() {

        List<ItemVariable> listado = new ArrayList<>();

        listado.add(getItemVariable(1, 1, "Si", true));
        listado.add(getItemVariable(2, 1, "No", false));
        listado.add(getItemVariable(3, 2, "Opcion 1", true));
        listado.add(getItemVariable(4, 2, "Opcion 2", false));
        listado.add(getItemVariable(5, 2, "Opcion 3", false));

        return listado;
    }
}
