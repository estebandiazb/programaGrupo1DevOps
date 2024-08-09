package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.bchdao.SimpleDaoConfiguration;
import cl.bancochile.plataformacomercial.controllimitestaller.context.MockContextConfig;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.Atributo;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.CategoriaSeleccionable;
import cl.bancochile.plataformacomercial.controllimitestaller.feature.OutMapSPFeature;
import cl.bancochile.plataformacomercial.controllimitestaller.repository.AgregarAtributoTipoLimiteVersionRepository;
import cl.bancochile.plataformacomercial.controllimitestaller.util.MockSimpleJdbcCallWithErrorHandler;
import cl.bancochile.plataformacomercial.controllimitestaller.util.ReflectionUtil;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.CategoriaAtributoEnum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MockContextConfig.class})
public class AgregarAtributoTipoLimiteVersionImplRepositoryTest {
    @Autowired
    private AgregarAtributoTipoLimiteVersionRepository agregarAtributoTipoLimiteVersionRepository;

    @Autowired
    private SimpleDaoConfiguration simpleDaoConfig;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void setAgregarAtributoTipoLimiteTestOK() throws Exception {
        MockSimpleJdbcCallWithErrorHandler simpleJdbcCall =
                new MockSimpleJdbcCallWithErrorHandler(simpleDaoConfig);
        simpleJdbcCall.setMapRespuesta(OutMapSPFeature.outMapSP(0, "Ok", outParams()));
        ReflectionUtil.setProperty(agregarAtributoTipoLimiteVersionRepository, "simpleJdbcCall", simpleJdbcCall);

        List<CategoriaSeleccionable> categorias = Arrays.asList(
                new CategoriaSeleccionable.Builder()
                        .seleccionado(true)
                        .categoria(CategoriaAtributoEnum.BASICO)
                        .build(),
                new CategoriaSeleccionable.Builder()
                        .seleccionado(false)
                        .categoria(CategoriaAtributoEnum.AVANZADO)
                        .build());

        Atributo atributo = new Atributo.Builder()
                .id(1L)
                .categorias(categorias)
                .obligatorio(true)
                .build();

        // Con categoria seleccionada
        agregarAtributoTipoLimiteVersionRepository.ejecutar(1L, atributo);

        // Sin categorias seleccionadas
        categorias.get(0).setSeleccionado(false);
        agregarAtributoTipoLimiteVersionRepository.ejecutar(1L, atributo);

        // Sin categorias configuradas
        atributo.setCategorias(null);
        agregarAtributoTipoLimiteVersionRepository.ejecutar(1L, atributo);
    }

    private Map<String, Object> outParams() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        return map;
    }
}
