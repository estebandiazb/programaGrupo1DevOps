package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.SimpleDaoException;
import org.junit.Before;
import org.mockito.Mock;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public abstract class AbstractRepositoyImplTest {

    @Mock
    protected SimpleJdbcCall simpleJdbcCall;

    protected Map<String, Object> customMap = null;

    protected Map<String, Object> getResultOK() {
        return getResultOK(customMap);
    }

    protected Map<String, Object> getResultOK(Map<String, Object> customMap) {
        return getResult(0, "OK", customMap);
    }

    @Before
    public void setup() {
        when(simpleJdbcCall.execute(any(SqlParameterSource.class)))
                .thenReturn(getResultOK());
    }

    protected void setupNOK() {
        when(simpleJdbcCall.execute(any(SqlParameterSource.class)))
                .thenThrow(new SimpleDaoException("test", "test", 1));
    }

    protected void setupCodigoNOK(int codigo) {
        when(simpleJdbcCall.execute(any(SqlParameterSource.class)))
                .thenThrow(new SimpleDaoException("test", "test", codigo));
    }

    protected static Map<String, Object> getResult(Object codigo, String glosa, Map<String, Object> customMap) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("OUT_ESTADO", codigo);
        map.put("OUT_GLOSA", glosa);
        if (customMap != null) {
            map.putAll(customMap);
        }
        return map;
    }
}
