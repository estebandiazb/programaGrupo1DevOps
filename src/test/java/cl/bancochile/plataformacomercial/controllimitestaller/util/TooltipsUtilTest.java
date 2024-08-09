package cl.bancochile.plataformacomercial.controllimitestaller.util;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableAtributo;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.CategoriaAtributoEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static cl.bancochile.plataformacomercial.controllimitestaller.fixture.ItemVariableFixture.getItemsVariable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class TooltipsUtilTest {
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

    @Test
    public void isVariableLlevaTooltipsTest(){
        assertTrue(ToolTipsUtil.isVariableLlevaTooltip("VFM157"));
        assertTrue(ToolTipsUtil.isVariableLlevaTooltip("VFM158"));
        assertTrue(ToolTipsUtil.isVariableLlevaTooltip("VFC205"));
        assertFalse(ToolTipsUtil.isVariableLlevaTooltip("XXX100"));
    }

    @Test
    public void getTooltipsFechasMaxMinTest() {
        VariableAtributo variableAtributo1 = new VariableAtributo.Builder()
                .codigo("VFM157")
                .tooltip("")
                .build();

        VariableAtributo variableAtributo2 = new VariableAtributo.Builder()
                .codigo("VFM158")
                .tooltip("")
                .build();

        VariableAtributo variableAtributo3 = new VariableAtributo.Builder()
                .codigo("VFC205")
                .tooltip("")
                .build();

        VariableAtributo variableAtributo5 = new VariableAtributo.Builder()
                .codigo("XXX001")
                .tooltip("Tooltip seteado")
                .build();

        assertEquals(TEXTO_TOOLTIP_FECHA_MIN, ToolTipsUtil.getTooltipsFechasMaxMin(variableAtributo1));
        assertEquals(TEXTO_TOOLTIP_FECHA_MAX, ToolTipsUtil.getTooltipsFechasMaxMin(variableAtributo2));
        assertEquals(TEXTO_TOOLTIP_FECHA, ToolTipsUtil.getTooltipsFechasMaxMin(variableAtributo3));
        assertEquals(variableAtributo5.getTooltip(), ToolTipsUtil.getTooltipsFechasMaxMin(variableAtributo5));
    }


    @Test
    public void getTooltipsVencMaxOper(){

        VariableAtributo variableAtributo1 = new VariableAtributo.Builder()
                .codigo("VFC213")
                .tooltip("")
                .items(getItemsVariable(new ItemVariable.Builder()
                        .valor(ITEM_VENC_MAX_PLAZO)
                        .seleccionado(Boolean.TRUE)
                        .build()))
                .build();

        VariableAtributo variableAtributo2 = new VariableAtributo.Builder()
                .codigo("VFC213")
                .tooltip("")
                .items(getItemsVariable(new ItemVariable.Builder()
                        .valor(ITEM_VENC_MAX_PLAZO_OPER)
                        .seleccionado(Boolean.TRUE)
                        .build()))
                .build();

        VariableAtributo variableAtributo3 = new VariableAtributo.Builder()
                .codigo("VFC213")
                .tooltip("")
                .items(getItemsVariable(new ItemVariable.Builder()
                        .valor(ITEM_FECHA_MAX_PLAZO)
                        .seleccionado(Boolean.TRUE)
                        .build()))
                .build();

        VariableAtributo variableAtributo4 = new VariableAtributo.Builder()
                .codigo("VFC213")
                .tooltip("")
                .items(getItemsVariable(new ItemVariable.Builder()
                        .valor(ITEM_FECHA_MAX_PLAZO_OPER)
                        .seleccionado(Boolean.TRUE)
                        .build()))
                .build();

        VariableAtributo variableAtributo5 = new VariableAtributo.Builder()
                .codigo("VFC213")
                .tooltip("")
                .items(getItemsVariable(new ItemVariable.Builder()
                        .valor(ITEM_FECHA_MAX_PLAZO_OPER)
                        .seleccionado(Boolean.TRUE)
                        .build()))
                .build();

        assertEquals(TEXTO_TOOLTIP_VENC_MAX_OP_PLAZO, ToolTipsUtil.getTooltipsVencMaxOperaciones(variableAtributo1, CategoriaAtributoEnum.AVANZADO));
        assertEquals(TEXTO_TOOLTIP_VENC_MAX_OP_PLAZO_OPER, ToolTipsUtil.getTooltipsVencMaxOperaciones(variableAtributo2, CategoriaAtributoEnum.AVANZADO));
        assertEquals(TEXTO_TOOLTIP_FECHA_MAX_OP_PLAZO, ToolTipsUtil.getTooltipsVencMaxOperaciones(variableAtributo3, CategoriaAtributoEnum.AVANZADO));
        assertEquals(TEXTO_TOOLTIP_FECHA_MAX_OP_PLAZO_OPER, ToolTipsUtil.getTooltipsVencMaxOperaciones(variableAtributo4, CategoriaAtributoEnum.AVANZADO));
        assertEquals(TEXTO_TOOLTIP_VENC_MAX_OP, ToolTipsUtil.getTooltipsVencMaxOperaciones(variableAtributo5, CategoriaAtributoEnum.BASICO));

    }
}