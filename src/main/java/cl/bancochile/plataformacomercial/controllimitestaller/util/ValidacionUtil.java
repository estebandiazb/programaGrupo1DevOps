package cl.bancochile.plataformacomercial.controllimitestaller.util;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.Atributo;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.AtributoValidacion;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.CategoriaSeleccionable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableAtributo;

import java.util.ArrayList;
import java.util.List;

public class ValidacionUtil {

    private ValidacionUtil() {
        //SONAR
    }

    public static Atributo getAtributo(List<Atributo> atributos, String codAtributo) {
        for(Atributo atributo: atributos){
            if(codAtributo.equals(atributo.getCodigo())){
                return atributo;
            }
        }
        return null;
    }

    public static VariableAtributo getVariable(List<VariableAtributo> variables, String codVariable) {
        for(VariableAtributo variable: variables){
            if(codVariable.equals(variable.getCodigo())){
                return variable;
            }
        }
        return null;
    }

    public static ItemVariable getItemSeleccionado(List<ItemVariable> items) {
        for(ItemVariable item: items){
            if(item.isSeleccionado()){
                return item;
            }
        }
        return null;
    }

    public static Boolean validaExisteCategoriaSeleccionada(List<CategoriaSeleccionable> categorias) {

        for(CategoriaSeleccionable categoria : categorias){
            if(categoria.isSeleccionado()){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public static String objectToString(Object valor){
        if (valor != null){
            return valor.toString();
        }
        return null;
    }

    public static List<AtributoValidacion> creaResponse(List<Atributo> atributos){
        List<AtributoValidacion> response = new ArrayList<>();
        for(Atributo atributo: atributos){
            response.add(new AtributoValidacion.Builder()
                    .idAtributo(atributo.getId())
                    .codAtributo(atributo.getCodigo())
                    .validado(Boolean.TRUE)
                    .mensaje(null)
                    .build());
        }

        return response;
    }

    public static Boolean isValidado(List<AtributoValidacion> response){
        for(AtributoValidacion atributo: response){
            if (!atributo.isValidado()){
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

}
