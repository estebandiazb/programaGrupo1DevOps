package cl.bancochile.plataformacomercial.controllimitestaller.fixture;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableAtributo;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.TipoValorVariableEnum;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class VariableAtributoFixture {


    public static List<VariableAtributo> getVariablesAtributos() {
        List<VariableAtributo> listado  = new ArrayList<>();

        listado.add(getVariableAtributo(1, 1,"", TipoValorVariableEnum.SELECCIONABLE, null, new ArrayList<ItemVariable>()));
        listado.add(getVariableAtributo(2, 1, "", TipoValorVariableEnum.SELECCIONABLE, null, new ArrayList<ItemVariable>()));
        listado.add(getVariableAtributo(3, 2, "", TipoValorVariableEnum.STRING, null, new ArrayList<ItemVariable>()));
        listado.add(getVariableAtributo(4, 4, "MMC170", TipoValorVariableEnum.SELECCIONABLE, getItemMonedasValor(), getItemMonedas()));
        listado.add(getVariableAtributo(5, 5, "CTR127", TipoValorVariableEnum.SELECCIONABLE, null, getItemDerivados()));
        listado.add(getVariableAtributo(6, 4, "MMC215", TipoValorVariableEnum.BOOLEAN, Boolean.TRUE, new ArrayList<ItemVariable>()));

        return listado;
    }

    public static List<ItemVariable> getItemDerivados(){
        List<ItemVariable> items = new ArrayList<>();
        items.add(new ItemVariable.Builder()
                .id(1L)
                .idVariable(10L)
                .valor("{\n" +
                        "\"id\": 1,\n" +
                        "\"nombre\": \"Tramo 1\",\n" +
                        "\"desde\": \"1\",\n" +
                        "\"hasta\": \"2\"\n" +
                        "}")
                .seleccionado(Boolean.FALSE)
                .build());
        return items;
    }

    public static List<ItemVariable> getItemMonedas(){
        List<ItemVariable> items = new ArrayList<>();
        items.add(new ItemVariable.Builder()
                .id(1L)
                .idVariable(1L)
                .valor("YEN")
                .seleccionado(Boolean.TRUE)
                .build());
        items.add(new ItemVariable.Builder()
                .id(1L)
                .idVariable(2L)
                .valor("EUR")
                .seleccionado(Boolean.FALSE)
                .build());
        return items;
    }

    public static List<LinkedHashMap<String, Object>> getItemMonedasValor(){
        List<LinkedHashMap<String, Object>> items = new ArrayList<>();
        LinkedHashMap<String, Object> asignado1 = new LinkedHashMap<>();
        asignado1.put("id",  1);
        asignado1.put("valor", "CLP");
        asignado1.put("seleccionado", Boolean.TRUE);

        LinkedHashMap<String, Object> asignado2 = new LinkedHashMap<>();
        asignado2.put("id",  2);
        asignado2.put("valor", "EUR");
        asignado2.put("seleccionado", Boolean.FALSE);

        items.add(asignado1);
        items.add(asignado2);

        return items;
    }




    public static VariableAtributo getVariableAtributo(long id,
                                                       long idAtributo,
                                                       String codigo,
                                                       TipoValorVariableEnum tipoValor,
                                                       Object valor,
                                                       List<ItemVariable> items) {
        return new VariableAtributo.Builder()
                .id(id)
                .idAtributo(idAtributo)
                .codigo(codigo)
                .nombre("Variable " + id)
                .tooltip("tooltip " + id)
                .tipoValor(tipoValor)
                .valor(valor)
                .items(items)
                .build();
    }
}
