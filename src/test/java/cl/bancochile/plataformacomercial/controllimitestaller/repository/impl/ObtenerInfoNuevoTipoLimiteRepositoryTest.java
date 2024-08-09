package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.SimpleDaoConfiguration;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.context.MockContextConfig;
import cl.bancochile.plataformacomercial.controllimitestaller.feature.OutMapSPFeature;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerInfoNuevoTipoLimiteRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.util.MockSimpleJdbcCallWithErrorHandler;
import cl.bancochile.plataformacomercial.controllimitestaller.util.ReflectionUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedHashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MockContextConfig.class})
public class ObtenerInfoNuevoTipoLimiteRepositoryTest {
    @Autowired
    private ObtenerInfoNuevoTipoLimiteRepository obtenerInfoNuevoTipoLimiteRepository;

    @Autowired
    private SimpleDaoConfiguration simpleDaoConfig;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ObtenerInfoNuevoTLRepositoryTest() throws Exception {
        MockSimpleJdbcCallWithErrorHandler simpleJdbcCall =
                new MockSimpleJdbcCallWithErrorHandler(simpleDaoConfig);
        simpleJdbcCall.setMapRespuesta(OutMapSPFeature.outMapSP(0, "Ok", outParams()));
        ReflectionUtil.setProperty(obtenerInfoNuevoTipoLimiteRepository, "simpleJdbcCall", simpleJdbcCall);

        obtenerInfoNuevoTipoLimiteRepository.ejecutar(1L, "AAAA");
    }

    @Test(expected = PlataformaBaseException.class)
    public void ObtenerInfoNuevoTLRepositoryTestFail() throws Exception {
        MockSimpleJdbcCallWithErrorHandler simpleJdbcCall =
                new MockSimpleJdbcCallWithErrorHandler(simpleDaoConfig);
        simpleJdbcCall.setMapRespuesta(OutMapSPFeature.outMapSP(-1, "NOK", outParams()));
        ReflectionUtil.setProperty(obtenerInfoNuevoTipoLimiteRepository, "simpleJdbcCall", simpleJdbcCall);
        obtenerInfoNuevoTipoLimiteRepository.ejecutar(1L, "AAAA");
    }

    @Test(expected = PlataformaBaseException.class)
    public void ObtenerInfoNuevoTLRepositoryPrefijoYaExisteTestFail() throws Exception {
        MockSimpleJdbcCallWithErrorHandler simpleJdbcCall =
                new MockSimpleJdbcCallWithErrorHandler(simpleDaoConfig);
        simpleJdbcCall.setMapRespuesta(OutMapSPFeature.outMapSP(0, "OK", outParams(true)));
        ReflectionUtil.setProperty(obtenerInfoNuevoTipoLimiteRepository, "simpleJdbcCall", simpleJdbcCall);
        obtenerInfoNuevoTipoLimiteRepository.ejecutar(1L, "AAAA");
    }

    private Map<String, Object> outParams() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        return map;
    }

    private Map<String, Object> outParams(boolean existePrefijo) {
        Map<String, Object> map = outParams();
        map.put("OUT_EXISTE_PREFIJO", existePrefijo? 1: 0);
        map.put("OUT_ID_CORRELATIVO", 100);

        return map;
    }
}
