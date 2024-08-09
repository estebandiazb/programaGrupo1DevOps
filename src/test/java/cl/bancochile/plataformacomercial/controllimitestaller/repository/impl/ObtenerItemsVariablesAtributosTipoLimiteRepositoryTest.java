package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.SimpleDaoConfiguration;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.context.MockContextConfig;
import cl.bancochile.plataformacomercial.controllimitestaller.feature.OutMapSPFeature;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.ObtenerItemsVariablesAtributosTipoLimiteRepository;
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
public class ObtenerItemsVariablesAtributosTipoLimiteRepositoryTest {
    @Autowired
    private ObtenerItemsVariablesAtributosTipoLimiteRepository obtenerItemsVariablesAtributosTipoLimiteRepository;

    @Autowired
    private SimpleDaoConfiguration simpleDaoConfig;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ObtenerAtributosTipoLimiteRepositoryTest() throws Exception {
        MockSimpleJdbcCallWithErrorHandler simpleJdbcCall =
                new MockSimpleJdbcCallWithErrorHandler(simpleDaoConfig);
        simpleJdbcCall.setMapRespuesta(OutMapSPFeature.outMapSP(0, "Ok", outParams()));
        ReflectionUtil
                .setProperty(obtenerItemsVariablesAtributosTipoLimiteRepository, "simpleJdbcCall", simpleJdbcCall);
        obtenerItemsVariablesAtributosTipoLimiteRepository.ejecutar(1L);
    }

    @Test(expected = PlataformaBaseException.class)
    public void ObtenerAtributosTipoLimiteRepositoryTestFail() throws Exception {
        MockSimpleJdbcCallWithErrorHandler simpleJdbcCall =
                new MockSimpleJdbcCallWithErrorHandler(simpleDaoConfig);
        simpleJdbcCall.setMapRespuesta(OutMapSPFeature.outMapSP(-1, "NOK", outParams()));
        ReflectionUtil
                .setProperty(obtenerItemsVariablesAtributosTipoLimiteRepository, "simpleJdbcCall", simpleJdbcCall);
        obtenerItemsVariablesAtributosTipoLimiteRepository.ejecutar(1L);
    }

    private Map<String, Object> outParams() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("ID", 1l);
        map.put("ID_VARIABLE", 1l);
        map.put("VALOR", "Si");
        return map;
    }
}
