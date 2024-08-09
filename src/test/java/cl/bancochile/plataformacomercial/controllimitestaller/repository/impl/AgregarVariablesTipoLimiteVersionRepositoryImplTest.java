package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.SimpleDaoConfiguration;
import cl.bancochile.plataformacomercial.controllimitestaller.context.MockContextConfig;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.VariableAtributo;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;
import cl.bancochile.plataformacomercial.controllimitestaller.feature.OutMapSPFeature;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.AgregarVariablesTipoLimiteVersionRepository;
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
public class AgregarVariablesTipoLimiteVersionRepositoryImplTest {
    @Autowired
    private AgregarVariablesTipoLimiteVersionRepository agregarVariablesTipoLimiteVersionRepository;

    @Autowired
    private SimpleDaoConfiguration simpleDaoConfig;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void agregarVariableTLTestOK() throws Exception {
        MockSimpleJdbcCallWithErrorHandler simpleJdbcCall =
                new MockSimpleJdbcCallWithErrorHandler(simpleDaoConfig);
        simpleJdbcCall.setMapRespuesta(OutMapSPFeature.outMapSP(0, "Ok", outParams()));
        ReflectionUtil.setProperty(agregarVariablesTipoLimiteVersionRepository, "simpleJdbcCall", simpleJdbcCall);

        agregarVariablesTipoLimiteVersionRepository.ejecutar(1L, new VariableAtributo());
    }

    @Test(expected = TallerException.class)
    public void agregarItemVariableTLTestFail() throws Exception {
        MockSimpleJdbcCallWithErrorHandler simpleJdbcCall =
                new MockSimpleJdbcCallWithErrorHandler(simpleDaoConfig);
        simpleJdbcCall.setMapRespuesta(OutMapSPFeature.outMapSP(-1, "NOK", outParams()));
        agregarVariablesTipoLimiteVersionRepository.ejecutar(1L, new VariableAtributo());
    }

    private Map<String, Object> outParams() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        return map;
    }
}
