package cl.bancochile.plataformacomercial.controllimitestaller.feature;

import java.util.LinkedHashMap;
import java.util.Map;

public class OutMapSPFeature {

    public static Map<String, Object> outMapSPOk() {
        return outMapSP(0, "Ok", new LinkedHashMap<String, Object>());
    }

    public static Map<String, Object> outMapSP(Object codigo, String glosa, Map<String, Object> outParam) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();

        map.put("OUT_ESTADO", codigo);
        map.put("OUT_GLOSA", glosa);

        map.putAll(outParam);

        return map;
    }

    public static Map<String, Object> outMapSPEmpty(Object codigo, String glosa) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();

        map.put("OUT_ESTADO", codigo);
        map.put("OUT_GLOSA", glosa);

        return map;
    }
}