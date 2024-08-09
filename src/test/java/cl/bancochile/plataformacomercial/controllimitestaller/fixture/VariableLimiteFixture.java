package cl.bancochile.plataformacomercial.controllimitestaller.fixture;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariableLimite;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableLimite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VariableLimiteFixture {

    public static List<VariableLimite> getConfiguracionLimite(){
        List<VariableLimite> variableLimites = new ArrayList<>();

        variableLimites.add(new VariableLimite.Builder()
                .id(1L)
                .codigoAtributo("CODIGO2")
                .codigoVariable("VFE156")
                .tooltip("Tooltip 1")
                .items(getItemsVariable(
                        new ItemVariableLimite.Builder()
                                .id(1L)
                                .idVariableItem(2L)
                                .valor("Valor 1")
                                .seleccionado(Boolean.TRUE)
                                .build(),
                        new ItemVariableLimite.Builder()
                                .id(2L)
                                .idVariableItem(2L)
                                .valor("Valor 2")
                                .seleccionado(Boolean.FALSE)
                                .build())
                        )
                .build());
        variableLimites.add(new VariableLimite.Builder()
                .id(5L)
                .codigoAtributo("PM125")
                .codigoVariable("MMC170")
                .tooltip("Tooltip 2")
                .items(getItemsVariable(
                        new ItemVariableLimite.Builder()
                                .id(3L)
                                .idVariableItem(2L)
                                .valor("CLP")
                                .seleccionado(Boolean.TRUE)
                                .build(),
                        new ItemVariableLimite.Builder()
                                .id(4L)
                                .idVariableItem(3L)
                                .valor("EUR")
                                .seleccionado(Boolean.TRUE)
                                .build())
                )
                .build());
        variableLimites.add(new VariableLimite.Builder()
                .id(1L)
                .codigoAtributo("CODIGO10")
                .codigoVariable("PE127")
                .tooltip("Tooltip 2")
                .items(getItemsVariable(
                        new ItemVariableLimite.Builder()
                                .id(3L)
                                .idVariableItem(2L)
                                .valor("Valor 10")
                                .seleccionado(Boolean.TRUE)
                                .build(),
                        new ItemVariableLimite.Builder()
                                .id(4L)
                                .idVariableItem(3L)
                                .valor("Valor 11")
                                .seleccionado(Boolean.TRUE)
                                .build())
                )
                .build());
        variableLimites.add(new VariableLimite.Builder()
                .id(10L)
                .idVariableAtributo(13L)
                .codigoVariable("CTR127")
                .codigoAtributo("CD113")
                .items(getItemsVariable(new ItemVariableLimite.Builder()
                        .idVariableLimite(10L)
                        .valor("\"{\\n\" +\n" +
                                "\"\\\"id\\\": 1,\\n\" +\n" +
                                "\"\\\"nombre\\\": \\\"Tramo 1\\\",\\n\" +\n" +
                                "\"\\\"desde\\\": \\\"1\\\",\\n\" +\n" +
                                "\"\\\"hasta\\\": \\\"2\\\"\\n\" +\n" +
                                "\"}\"")
                        .seleccionado(Boolean.FALSE)
                        .build()))
                .build());
        return variableLimites;
    }

    public static List<ItemVariableLimite> getItemsVariable(ItemVariableLimite... item){
        return new ArrayList<>(Arrays.asList(item));
    }
}
