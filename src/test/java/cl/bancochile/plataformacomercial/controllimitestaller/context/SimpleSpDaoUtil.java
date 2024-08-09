package cl.bancochile.plataformacomercial.controllimitestaller.context;

import cl.bancochile.bchdao.SimpleDaoConfiguration;
import cl.bancochile.plataformacomercial.controllimitestaller.util.MockSimpleJdbcCallWithErrorHandler;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleSpDaoUtil {

    public static void setOutMapSp(Object repository, SimpleDaoConfiguration simpleDaoConfig,
                                   Map<String, Object> outMap)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

        MockSimpleJdbcCallWithErrorHandler simpleJdbcCall = new MockSimpleJdbcCallWithErrorHandler(simpleDaoConfig);
        simpleJdbcCall.setMapRespuesta(outMap);

        Field f1 = repository.getClass().getSuperclass().getDeclaredField("simpleJdbcCall");
        boolean isAccessible = f1.isAccessible();
        f1.setAccessible(true);
        f1.set(repository, simpleJdbcCall);
        f1.setAccessible(isAccessible);
    }

    public static Map<String, Object> outMapSPOk() {
        return outMapSP(0, "Ok", new LinkedHashMap<String, Object>());
    }

    public static Map<String, Object> outMapSP(Object codigo, String glosa, Map<String, Object> outMap) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("OUT_ESTADO", codigo);
        map.put("OUT_GLOSA", glosa);
        map.putAll(outMap);
        return map;
    }
}
