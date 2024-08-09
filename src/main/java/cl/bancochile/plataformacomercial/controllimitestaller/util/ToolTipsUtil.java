package cl.bancochile.plataformacomercial.controllimitestaller.util;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableAtributo;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.CategoriaAtributoEnum;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ToolTipsUtil {

    private static final String VARIABLE_FECHA_MINIMA           = "VFM157";
    private static final String VARIABLE_FECHA_MAXIMA           = "VFM158";
    private static final String VARIABLE_FECHA                  = "VFC205";
    public static final String VARIABLE_TOOLTIP_VENC_MAX_OP    = "VFC213";

    private static final List<String> VARIABLES_CON_TOOLTIP = Arrays.asList(VARIABLE_FECHA_MINIMA,
                                                                            VARIABLE_FECHA_MAXIMA,
                                                                            VARIABLE_FECHA);

    private static final String ITEM_VENC_MAX_PLAZO = "Fecha Vencimiento MAC + Plazo";
    private static final String ITEM_VENC_MAX_PLAZO_OPER = "Fecha Vencimiento MAC + Plazo Operaciones";
    private static final String ITEM_FECHA_MAX_PLAZO = "Fecha Máx Curse + Plazo";
    private static final String ITEM_FECHA_MAX_PLAZO_OPER = "Fecha Máx Curse + Plazo Operaciones";

    private static final String TEXTO_TOOLTIP_FECHA_MIN =
            "Fecha mínima para poder cursar operaciones, no puede ser inferior a Fecha Presentación del MAC";
    private static final String TEXTO_TOOLTIP_FECHA_MAX =
            "Fecha máxima para poder cursar operaciones, no puede ser superior a Fecha vencimiento del MAC";
    private static final String TEXTO_TOOLTIP_FECHA =
            "Fecha máxima para poder cursar operaciones";
    private static final String TEXTO_TOOLTIP_VENC_MAX_OP =
            "Seleccionar fecha máxima en que puede vencer las operaciones cursadas";
    private static final String TEXTO_TOOLTIP_VENC_MAX_OP_PLAZO =
            "Por defecto se considera Fecha Vencimiento MAC + Plazo del Límite";
    private static final String TEXTO_TOOLTIP_VENC_MAX_OP_PLAZO_OPER =
            "Por defecto se considera Fecha Vencimiento MAC + Plazo Máx Operaciones";
    private static final String TEXTO_TOOLTIP_FECHA_MAX_OP_PLAZO =
            "Por defecto se considera Fecha Max Curse + Plazo del Límite";
    private static final String TEXTO_TOOLTIP_FECHA_MAX_OP_PLAZO_OPER =
            "Por defecto se considera Fecha Max Curse + Plazo Máx Operaciones";

    private ToolTipsUtil() {
        //SONAR
    }

    public static boolean isVariableLlevaTooltip(String codigo){
        return VARIABLES_CON_TOOLTIP.contains(codigo);
    }

    public static String getTooltipsFechasMaxMin(VariableAtributo variableAtributo) {
        String nuevoTooltip;

        switch (variableAtributo.getCodigo()){
            case VARIABLE_FECHA_MINIMA:
                nuevoTooltip = TEXTO_TOOLTIP_FECHA_MIN;
                break;
            case VARIABLE_FECHA_MAXIMA:
                nuevoTooltip = TEXTO_TOOLTIP_FECHA_MAX;
                break;
            case VARIABLE_FECHA:
                nuevoTooltip = TEXTO_TOOLTIP_FECHA;
                break;
            default:
                nuevoTooltip = variableAtributo.getTooltip();
                break;
        }
        return nuevoTooltip;
    }

    public static String getTooltipsVencMaxOperaciones(VariableAtributo variableAtributo,
                                                       CategoriaAtributoEnum categoria){
        if (CategoriaAtributoEnum.BASICO.equals(categoria)){
            return TEXTO_TOOLTIP_VENC_MAX_OP;
        }

        // Obtencion seleccion
        String opcion = variableAtributo.getItems().stream()
                .filter(ItemVariable::isSeleccionado)
                .map(item -> item.getValor() != null ? item.getValor().toString() : null)
                .findFirst()
                .orElse(null);

        switch (Objects.requireNonNull(opcion)){
            case ITEM_VENC_MAX_PLAZO:
                return TEXTO_TOOLTIP_VENC_MAX_OP_PLAZO;
            case ITEM_VENC_MAX_PLAZO_OPER:
                return TEXTO_TOOLTIP_VENC_MAX_OP_PLAZO_OPER;
            case ITEM_FECHA_MAX_PLAZO:
                return TEXTO_TOOLTIP_FECHA_MAX_OP_PLAZO;
            case ITEM_FECHA_MAX_PLAZO_OPER:
                return TEXTO_TOOLTIP_FECHA_MAX_OP_PLAZO_OPER;
            default:
                return variableAtributo.getTooltip();
        }
    }
}
