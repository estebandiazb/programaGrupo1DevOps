package cl.bancochile.plataformacomercial.controllimitestaller.fixture;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.Atributo;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.CategoriaSeleccionable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimiteFull;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableAtributo;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.CategoriaAtributoEnum;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.TipoValorVariableEnum;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static cl.bancochile.plataformacomercial.controllimitestaller.fixture.CategoriaSeleccionableFixture.getCategorias;
import static cl.bancochile.plataformacomercial.controllimitestaller.fixture.CategoriaSeleccionableFixture.getCategoriasList;
import static cl.bancochile.plataformacomercial.controllimitestaller.fixture.VariableAtributoFixture.getItemDerivados;

public class TipoLimiteFullFixture {

    public static TipoLimiteFull getTipoLimiteFull(Long idTipoLimite){
        return new TipoLimiteFull.Builder()
                .nombre("Tipo 1")
                .descripcion("hola")
                .atributos(getAtributosTipoLimiteFull())
                .idTipoLimite(idTipoLimite)
                .estado(EstadoTipoLimiteEnum.BORRADOR)
                .id(idTipoLimite)
                .build();
    }

    public static TipoLimiteFull getTipoLimiteFull(long id, long idTipoLimite, EstadoTipoLimiteEnum estado){
        return new TipoLimiteFull.Builder()
                .nombre("Tipo 1")
                .descripcion("hola")
                .atributos(getAtributosTipoLimiteFull())
                .idTipoLimite(idTipoLimite)
                .estado(estado)
                .id(id)
                .build();
    }

    public static List<Atributo> getAtributosTipoLimiteFull(){
        List<Atributo> listadoAtributos = new ArrayList<>();

        listadoAtributos.add(new Atributo.Builder()
                .id(1L)
                .codigo("CODIGO1")
                .categorias(getCategoriasList(
                        new CategoriaSeleccionable.Builder()
                                .idAtributo(1L)
                                .categoria(CategoriaAtributoEnum.NORMATIVO)
                                .seleccionado(Boolean.FALSE).build(),
                        new CategoriaSeleccionable.Builder()
                                .idAtributo(1L)
                                .categoria(CategoriaAtributoEnum.BASICO)
                                .seleccionado(Boolean.TRUE).build(),
                        new CategoriaSeleccionable.Builder()
                                .idAtributo(1L)
                                .categoria(CategoriaAtributoEnum.AVANZADO)
                                .seleccionado(Boolean.TRUE).build()
                        ))
                .comentario("Comentario")
                .variables(getVariablesAtributoTipoLimiteFull("VACIO"))
                .build());
        listadoAtributos.add(new Atributo.Builder()
                .id(2L)
                .codigo("CODIGO2")
                .categorias(getCategoriasList(
                        new CategoriaSeleccionable.Builder()
                                .idAtributo(2L)
                                .categoria(CategoriaAtributoEnum.NORMATIVO)
                                .seleccionado(Boolean.TRUE).build(),
                        new CategoriaSeleccionable.Builder()
                                .idAtributo(2L)
                                .categoria(CategoriaAtributoEnum.BASICO)
                                .seleccionado(Boolean.TRUE).build(),
                        new CategoriaSeleccionable.Builder()
                                .idAtributo(2L)
                                .categoria(CategoriaAtributoEnum.AVANZADO)
                                .seleccionado(Boolean.FALSE).build()
                ))
                .comentario("Comentario")
                .variables(getVariablesAtributoTipoLimiteFull("MODIFICAR"))
                .build());
        listadoAtributos.add(new Atributo.Builder()
                .id(3L)
                .codigo("CODIGO3")
                .categorias(getCategorias())
                .comentario("Comentario")
                .variables(getVariablesAtributoTipoLimiteFull("SIN_MODIFICAR"))
                .build());
        // Caja derivados
        listadoAtributos.add(new Atributo.Builder()
                .id(4L)
                .codigo("CD113")
                .categorias(getCategorias())
                .comentario("Comentario")
                .variables(getVariablesCajaDerivados())
                .build());
        listadoAtributos.add(new Atributo.Builder()
                .id(5L)
                .codigo("PM125")
                .categorias(getCategorias())
                .nombre("Monedas Curse")
                .variables(getVariablesMonedas())
                .build());

        return listadoAtributos;
    }

    public static List<VariableAtributo> getVariablesMonedas(){
        List<VariableAtributo> variables = new ArrayList<>();

        List<LinkedHashMap<String, Object>> valorMonedas = new ArrayList<>();
        LinkedHashMap<String, Object> asignado1 = new LinkedHashMap<>();
        asignado1.put("id",  2);
        asignado1.put("valor", "CLP");
        asignado1.put("seleccionado", Boolean.FALSE);

        LinkedHashMap<String, Object> asignado2 = new LinkedHashMap<>();
        asignado2.put("id",  1);
        asignado2.put("valor", "YEN");
        asignado2.put("seleccionado", Boolean.FALSE);

        valorMonedas.add(asignado1);
        valorMonedas.add(asignado2);

        variables.add(new VariableAtributo.Builder()
                .codigo("MMC170")
                .id(11L)
                .idAtributo(25L)
                .tipoValor(TipoValorVariableEnum.SELECCIONABLE)
                .valor(valorMonedas)
                .items(getItemsVariable(new ItemVariable.Builder()
                        .id(1L)
                        .valor("YEN")
                        .seleccionado(Boolean.TRUE)
                        .build()))
                .build());
        variables.add(new VariableAtributo.Builder()
                .codigo("MMC215")
                .id(12L)
                .idAtributo(25L)
                .tipoValor(TipoValorVariableEnum.BOOLEAN)
                .valor(Boolean.TRUE)
                .build());


        return variables;
    }

    public static List<VariableAtributo> getVariablesCajaDerivados(){
        List<VariableAtributo> variables = new ArrayList<>();
        variables.add(new VariableAtributo.Builder()
                .codigo("CTR127")
                .id(10L)
                .idAtributo(13L)
                .tipoValor(TipoValorVariableEnum.SELECCIONABLE)
                .items(getItemDerivados())
                .build());
        return variables;
    }

    public static List<VariableAtributo> getVariablesAtributoTipoLimiteFull(String opcion){

        List<VariableAtributo> variables = new ArrayList<>();

        switch (opcion) {
            case ("VACIO"):
                return variables;
            case ("SIN_MODIFICAR"):
                variables.add(new VariableAtributo.Builder()
                        .id(1L)
                        .idAtributo(1L)
                        .codigo("VFE156")
                        .tipoValor(TipoValorVariableEnum.SELECCIONABLE)
                        .items(getItemsVariable(
                                new ItemVariable.Builder()
                                        .id(1L)
                                        .valor("Valor 1")
                                        .idVariable(1L)
                                        .seleccionado(Boolean.TRUE)
                                        .build(),
                                new ItemVariable.Builder()
                                        .id(2L)
                                        .idVariable(1L)
                                        .valor("Valor 2")
                                        .seleccionado(Boolean.TRUE)
                                        .build(),
                                new ItemVariable.Builder()
                                        .id(3L)
                                        .idVariable(1L)
                                        .valor("Valor 3")
                                        .seleccionado(Boolean.TRUE)
                                        .build()))
                        .build());
                variables.add(new VariableAtributo.Builder()
                        .id(2L)
                        .idAtributo(1L)
                        .codigo("MMC170")
                        .tipoValor(TipoValorVariableEnum.SELECCIONABLE)
                        .items(getItemsVariable(
                                new ItemVariable.Builder()
                                        .id(4L)
                                        .valor("CLP")
                                        .idVariable(2L)
                                        .seleccionado(Boolean.FALSE)
                                        .build(),
                                new ItemVariable.Builder()
                                        .id(5L)
                                        .idVariable(2L)
                                        .valor("EUR")
                                        .seleccionado(Boolean.FALSE)
                                        .build()))
                        .build());
                return variables;
            case ("MODIFICAR") :
                variables.add(new VariableAtributo.Builder()
                        .id(1L)
                        .idAtributo(1L)
                        .codigo("VFE156")
                        .tipoValor(TipoValorVariableEnum.SELECCIONABLE)
                        .items(getItemsVariable(
                                new ItemVariable.Builder()
                                        .id(2L)
                                        .idVariable(1L)
                                        .valor("Valor 2")
                                        .seleccionado(Boolean.FALSE)
                                        .build(),
                                new ItemVariable.Builder()
                                        .id(3L)
                                        .valor("Valor 3")
                                        .seleccionado(Boolean.FALSE)
                                        .build(),
                                new ItemVariable.Builder()
                                        .id(4L)
                                        .valor("Valor 4")
                                        .seleccionado(Boolean.TRUE)
                                        .build()))
                        .build());
                variables.add(new VariableAtributo.Builder()
                        .id(2L)
                        .idAtributo(1L)
                        .codigo("MMC170")
                        .tipoValor(TipoValorVariableEnum.SELECCIONABLE)
                        .items(getItemsVariable(
                                new ItemVariable.Builder()
                                        .id(4L)
                                        .valor("CLP")
                                        .idVariable(2L)
                                        .seleccionado(Boolean.TRUE)
                                        .build(),
                                new ItemVariable.Builder()
                                        .id(5L)
                                        .idVariable(3L)
                                        .valor("EUR")
                                        .seleccionado(Boolean.FALSE)
                                        .build()))
                        .build());
                return variables;
            default:
                return null;
        }
    }

    public static List<ItemVariable> getItemsVariable(ItemVariable... item){
        return new ArrayList<>(Arrays.asList(item));
    }

}
