package cl.bancochile.plataformacomercial.controllimitestaller.util;

import cl.bancochile.bchdao.SimpleDaoConfiguration;
import cl.bancochile.bchdao.SimpleJdbcCallWithErrorHandler;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.Map;

public class MockSimpleJdbcCallWithErrorHandler extends SimpleJdbcCallWithErrorHandler {

    private Map<String, Object> mapRespuesta;

    public MockSimpleJdbcCallWithErrorHandler(SimpleDaoConfiguration config) {
        super(config);
    }

    @Override
    protected Map<String, Object> doExecute(Object... args) {
        if (mapRespuesta == null) {
            throw new RuntimeException("No se definio map respuesta");
        }
        return mapRespuesta;
    }

    @Override
    protected Map<String, Object> doExecute(SqlParameterSource parameterSource) {
        if (mapRespuesta == null) {
            throw new RuntimeException("No se definio map respuesta");
        }
        return mapRespuesta;
    }

    public Map<String, Object> getMapRespuesta() {
        return mapRespuesta;
    }

    public void setMapRespuesta(Map<String, Object> mapRespuesta) {
        this.mapRespuesta = mapRespuesta;
    }


}
