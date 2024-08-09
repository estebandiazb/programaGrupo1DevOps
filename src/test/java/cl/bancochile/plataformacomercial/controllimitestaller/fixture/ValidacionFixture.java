package cl.bancochile.plataformacomercial.controllimitestaller.fixture;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.Atributo;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.CategoriaSeleccionable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableAtributo;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.CategoriaAtributoEnum;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.TipoValorVariableEnum;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class ValidacionFixture {

    public static Atributo getAtributo(long id,
                                       String nombre,
                                       List<CategoriaSeleccionable> categorias,
                                       String codigo,
                                       List<VariableAtributo> variables,
                                       boolean isObligatorio) {
        return new Atributo.Builder()
                .id(id)
                .nombre(nombre)
                .codigo(codigo)
                .comentario("Lalala")
                .categorias(categorias)
                .variables(variables)
                .obligatorio(isObligatorio)
                .build();
    }

    public static CategoriaSeleccionable getCategoria(boolean seleccionado,
                                                      CategoriaAtributoEnum categoria) {
        return new CategoriaSeleccionable.Builder()
                .seleccionado(seleccionado)
                .categoria(categoria)
                .build();
    }

    public static VariableAtributo getVariableAtributo(long id,
                                                       long idAtributo,
                                                       String nombre,
                                                       String codigo,
                                                       String tooltip,
                                                       Object valor,
                                                       TipoValorVariableEnum tipoValor,
                                                       List<ItemVariable> items) {
        return new VariableAtributo.Builder()
                .id(id)
                .idAtributo(idAtributo)
                .nombre(nombre)
                .codigo(codigo)
                .tooltip(tooltip)
                .seleccionado(true)
                .valor(valor)
                .tipoValor(tipoValor)
                .items(items)
                .build();
    }

    public static ItemVariable getItem(long id, Boolean seleccionado, Object valor){
        return new ItemVariable.Builder()
                .id(id)
                .seleccionado(seleccionado)
                .valor(valor)
                .build();
    }

    public static List<CategoriaSeleccionable> getListadoCategoria(CategoriaAtributoEnum categoria) {
        List<CategoriaSeleccionable> categorias = new ArrayList<>();
        categorias.add(
                getCategoria(CategoriaAtributoEnum.BASICO == categoria, CategoriaAtributoEnum.BASICO));
        categorias.add(
                getCategoria(CategoriaAtributoEnum.AVANZADO == categoria, CategoriaAtributoEnum.AVANZADO));
        categorias.add(
                getCategoria(CategoriaAtributoEnum.NORMATIVO == categoria, CategoriaAtributoEnum.NORMATIVO));
        return categorias;
    }

    public static List<VariableAtributo> getVariablesVencimientoMaxCurse(String criterioVencMaxCurse) {
        List<VariableAtributo> variables = new ArrayList<>();
        variables.add(getVariableAtributo(46,22,"Fecha", "VFE159", null, null,
                TipoValorVariableEnum.DATE, new ArrayList<>()));
        variables.add(getVariableAtributo(47,22,"Fecha Mínima", "VFM160", null, null,
                TipoValorVariableEnum.DATE, new ArrayList<>()));
        variables.add(getVariableAtributo(48,22,"Fecha Máxima", "VFM161", null, null,
                TipoValorVariableEnum.DATE, new ArrayList<>()));
        variables.add(getVariableAtributo(49,22,"Opcion Fecha Criterio", "VFC213", null, null,
                TipoValorVariableEnum.SELECCIONABLE, getItemsOpcionFechaCriterio(criterioVencMaxCurse)));
        variables.add(getVariableAtributo(50,22,"Valor Criterio", "VFC214", null, null,
                TipoValorVariableEnum.INTEGER, new ArrayList<>()));
        return variables;
    }

    public static List<ItemVariable> getItemsOpcionFechaCriterio(String criterio) {
        List<ItemVariable> items = new ArrayList<>();
        items.add(getItem(90, "CriterioVencMaxCurse1".equals(criterio) ? true :false, "Fecha Vencimiento MAC + Plazo"));
        items.add(getItem(91, "CriterioVencMaxCurse2".equals(criterio) ? true :false, "Fecha Vencimiento MAC + Plazo Operaciones"));
        items.add(getItem(92, "CriterioVencMaxCurse3".equals(criterio) ? true :false, "Fecha Vencimiento MAC + X días"));
        items.add(getItem(93, "CriterioVencMaxCurse4".equals(criterio) ? true :false, "Fecha Máx Curse + Plazo"));
        items.add(getItem(94, "CriterioVencMaxCurse5".equals(criterio) ? true :false, "Fecha Máx Curse + Plazo Operaciones"));
        items.add(getItem(95, "CriterioVencMaxCurse6".equals(criterio) ? true :false, "Fecha Máx Curse + X días"));

        return items;
    }

    public static List<VariableAtributo> getVariablesMontoLimite(boolean seleccionado) {
        List<VariableAtributo> variables = new ArrayList<>();
        variables.add(getVariableAtributo(14,3,"Moneda", "MMO102", null, null,
                TipoValorVariableEnum.SELECCIONABLE, getItemsMoneda(seleccionado)));
        return variables;
    }

    public static List<ItemVariable> getItemsMoneda(boolean seleccionado) {
        List<ItemVariable> items = new ArrayList<>();
        items.add(getItem(65, seleccionado, "CLP"));
        items.add(getItem(66, false, "CLF"));
        items.add(getItem(67, false, "USD"));
        items.add(getItem(68, false, "EUR"));

        return items;
    }

    public static List<VariableAtributo> getVariablesVencimientoLimite(boolean seleccionado) {
        List<VariableAtributo> variables = new ArrayList<>();
        variables.add(getVariableAtributo(34,21,"Fecha", "VFE156", null, null,
                TipoValorVariableEnum.DATE, new ArrayList<>()));
        variables.add(getVariableAtributo(35,21,"Fecha Mínima", "VFM157", null, null,
                TipoValorVariableEnum.DATE, new ArrayList<>()));
        variables.add(getVariableAtributo(36,21,"Fecha Máxima", "VFM158", null, null,
                TipoValorVariableEnum.DATE, new ArrayList<>()));
        variables.add(getVariableAtributo(37,21,"Opcion Fecha Criterio 1", "VFC204", null, null,
                TipoValorVariableEnum.SELECCIONABLE, getOpcionFechaCriterio(seleccionado)));
        variables.add(getVariableAtributo(38,21,"Valor Criterio 1", "VFC205", null, null,
                TipoValorVariableEnum.INTEGER, new ArrayList<>()));
        variables.add(getVariableAtributo(39,21,"Fecha Fija Criterio 1", "VFC206", null, null,
                TipoValorVariableEnum.DATE, new ArrayList<>()));
        variables.add(getVariableAtributo(40,21,"Doble Logica", "VFC207", null, "True",
                TipoValorVariableEnum.BOOLEAN, new ArrayList<>()));
        variables.add(getVariableAtributo(41,21,"Plazo Criterio 2", "VFC208", null, null,
                TipoValorVariableEnum.STRING, new ArrayList<>()));
        variables.add(getVariableAtributo(42,21,"Unidad Plazo Criterio 2", "VFC209", null, null,
                TipoValorVariableEnum.SELECCIONABLE, getItemsUnidadTiempo(seleccionado)));
        variables.add(getVariableAtributo(43,21,"Opcion Fecha Criterio 2", "VFC210", null, null,
                TipoValorVariableEnum.SELECCIONABLE, getOpcionFechaCriterio(seleccionado)));
        variables.add(getVariableAtributo(44,21,"Valor Criterio 2", "VFC211", null, null,
                TipoValorVariableEnum.INTEGER, new ArrayList<>()));
        variables.add(getVariableAtributo(45,21,"Fecha Fija Criterio 2", "VFC212", null, null,
                TipoValorVariableEnum.DATE, new ArrayList<>()));
        return variables;
    }

    public static List<ItemVariable> getOpcionFechaCriterio(boolean seleccionado) {
        List<ItemVariable> items = new ArrayList<>();
        items.add(getItem(81, false, "Fecha presentación + X días"));
        items.add(getItem(82, seleccionado, "Fecha vencimiento MAC - X días"));
        items.add(getItem(83, false, "Fecha Fija"));

        return items;
    }

    public static List<VariableAtributo> getVariablesReutilizable(String reutilizable) {
        List<VariableAtributo> variables = new ArrayList<>();
        variables.add(getVariableAtributo(59,28,"Reutilizable", "RRE173", null, null,
                TipoValorVariableEnum.SELECCIONABLE, getItemsReutilizable(reutilizable)));
        return variables;
    }

    public static List<ItemVariable> getItemsReutilizable(String reutilizable) {
        List<ItemVariable> items = new ArrayList<>();
        items.add(getItem(112, "Si".equals(reutilizable) ? true : false, "Si"));
        items.add(getItem(113, "No".equals(reutilizable) ? true : false, "No"));

        return items;
    }

    public static List<VariableAtributo> getVariablesPlazoLimite(boolean seleccionado) {
        List<VariableAtributo> variables = new ArrayList<>();
        variables.add(getVariableAtributo(15,4,"Unidad de Tiempo", "PUT104", null, null,
                TipoValorVariableEnum.SELECCIONABLE, getItemsUnidadTiempo(seleccionado)));
        variables.add(getVariableAtributo(16,4,"Plazo", "PPL105", null, null,
                TipoValorVariableEnum.INTEGER, new ArrayList<>()));
        variables.add(getVariableAtributo(17,4,"Plazo Minimo", "PPM106", null, null,
                TipoValorVariableEnum.INTEGER, new ArrayList<>()));
        variables.add(getVariableAtributo(18,4,"Unidad Tiempo Plazo Minimo ", "PMV201", null, null,
                TipoValorVariableEnum.STRING, new ArrayList<>()));
        variables.add(getVariableAtributo(19,4,"Requiere Plazo Minimo", "PMV202", null, null,
                TipoValorVariableEnum.BOOLEAN, new ArrayList<>()));
        variables.add(getVariableAtributo(20,4,"Requiere Tooltips", "PMV203", null, null,
                TipoValorVariableEnum.BOOLEAN, new ArrayList<>()));
        return variables;
    }

    public static List<ItemVariable> getItemsUnidadTiempo(boolean seleccionado) {
        List<ItemVariable> items = new ArrayList<>();
        items.add(getItem(69, seleccionado, "Día (s)"));
        items.add(getItem(70, false, "Mes (s)"));
        items.add(getItem(71, false, "Año (s)"));
        items.add(getItem(72, false, "Indefinida"));
        items.add(getItem(73, false, "Semestre (s)"));
        items.add(getItem(74, false, "Semana (s)"));

        return items;
    }

    public static List<VariableAtributo> getVariablesPlazoMáximoOperaciones(boolean seleccionado) {
        List<VariableAtributo> variables = new ArrayList<>();
        variables.add(getVariableAtributo(51,23,"Unidad de Tiempo", "PUT162", null, null,
                TipoValorVariableEnum.SELECCIONABLE, getItemsUnidadTiempo(seleccionado)));
        variables.add(getVariableAtributo(52,23,"Plazo", "PPL163", null, null,
                TipoValorVariableEnum.INTEGER, new ArrayList<>()));
        variables.add(getVariableAtributo(53,23,"Unidad Tiempo Plazo Maximo", "PPM168", null, null,
                TipoValorVariableEnum.STRING, new ArrayList<>()));
        variables.add(getVariableAtributo(54,23,"Plazo Maximo", "PPM169", null, null,
                TipoValorVariableEnum.INTEGER, new ArrayList<>()));
        return variables;
    }

    public static List<VariableAtributo> getVariablesMonedaCurse(boolean seleccionado) {
        List<VariableAtributo> variables = new ArrayList<>();
        variables.add(getVariableAtributo(55,25,"Moneda Curse", "MMC170", null, null,
                TipoValorVariableEnum.SELECCIONABLE, getItemsMoneda(seleccionado)));
        variables.add(getVariableAtributo(56,25,"Todas M/N y M/X", "MMC215", null, null,
                TipoValorVariableEnum.BOOLEAN, new ArrayList<>()));
        return variables;
    }

    public static List<VariableAtributo> getVariablesCursesParciales(String cursesParciales) {
        List<VariableAtributo> variables = new ArrayList<>();
        variables.add(getVariableAtributo(57,26,"Curses Parciales", "CCP171", null, null,
                TipoValorVariableEnum.SELECCIONABLE, getItemsReutilizable(cursesParciales)));
        return variables;
    }

    public static List<VariableAtributo> getVariablesCleanUp() {
        List<VariableAtributo> variables = new ArrayList<>();
        variables.add(getVariableAtributo(30,17,"Monto Clean Up", "CMU146", null, null,
                TipoValorVariableEnum.STRING, new ArrayList<>()));
        variables.add(getVariableAtributo(31,17,"% Clean Up", "CCU147", null, null,
                TipoValorVariableEnum.STRING, new ArrayList<>()));
        variables.add(getVariableAtributo(32,17,"Mes Inicio", "CMI148", null, null,
                TipoValorVariableEnum.STRING, new ArrayList<>()));
        variables.add(getVariableAtributo(33,17,"Mes Término", "CMT149", null, null,
                TipoValorVariableEnum.STRING, new ArrayList<>()));
        return variables;
    }

    public static List<Atributo> getAtributosValidacion(String criterioVencMaxCurse, boolean seleccionado,
                                                        String reutilizable, String cursesParciales,
                                                        List<Pair> listadoAtributos) {

        List<Atributo> atributos = new ArrayList<>();

        for(Pair atributo : listadoAtributos) {

            String codigoAtributo = (String)atributo.getKey();
            CategoriaAtributoEnum categoria = (CategoriaAtributoEnum)atributo.getValue();

            switch (codigoAtributo) {
                case "VC122":
                    atributos.add(getAtributo(22, "Vcto Máx. Curse", getListadoCategoria(categoria),
                        "VC122", getVariablesVencimientoMaxCurse(criterioVencMaxCurse), false));
                break;
                case "ML103":
                    atributos.add(getAtributo(3, "Monto Límite", getListadoCategoria(categoria),
                        "ML103", getVariablesMontoLimite(seleccionado), false));
                break;
                case "VL121":
                    atributos.add(getAtributo(21, "Vencimiento Límite", getListadoCategoria(categoria),
                        "VL121", getVariablesVencimientoLimite(seleccionado), false));
                break;
                case "RE128":
                    atributos.add(getAtributo(28, "Reutilizable", getListadoCategoria(categoria),
                        "RE128", getVariablesReutilizable(reutilizable), false));
                break;
                case "PL104":
                    atributos.add(getAtributo(4, "Plazo Límite", getListadoCategoria(categoria),
                        "PL104", getVariablesPlazoLimite(seleccionado), false));
                break;
                case "PO123":
                    atributos.add(getAtributo(23, "Plazo Máximo Operaciones", getListadoCategoria(categoria),
                        "PO123", getVariablesPlazoMáximoOperaciones(seleccionado), false));
                break;
                case "PM125":
                    atributos.add(getAtributo(25, "Moneda Curse", getListadoCategoria(categoria),
                        "PM125", getVariablesMonedaCurse(seleccionado), false));
                break;
                case "CP126":
                    atributos.add(getAtributo(26, "Curses Parciales", getListadoCategoria(categoria),
                        "CP126", getVariablesCursesParciales(cursesParciales), false));
                break;
                case "CU117":
                    atributos.add(getAtributo(17, "Clean Up", getListadoCategoria(categoria),
                        "CU117", getVariablesCleanUp(), false));
                break;
                default:
                    break;
            }
        }
        return atributos;
    }

}
