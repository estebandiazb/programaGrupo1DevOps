package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ObtenerMonedaRepositoryImplTest extends AbstractRepositoyImplTest {

    @InjectMocks
    private ObtenerMonedaRepositoryImpl repository;

    @Test
    public void ejecutar() throws PlataformaBaseException {

        customMap = new HashMap<>();
        customMap.put("OUT_ID_VALOR", 1);
        customMap.put("OUT_CODIGO", "CLP");
        customMap.put("OUT_CODIGO_BANCO", 1);
        customMap.put("OUT_NOMBRE", "PESOS");
        customMap.put("OUT_DESCRIPCION", "PESO CHILENO");
        customMap.put("OUT_SIMBOLO", "$");
        customMap.put("OUT_FECHA_CREACION", "01/01/1810");
        customMap.put("OUT_FECHA_MODIFICACION", "01/01/1810");
        customMap.put("OUT_USUARIO_CREACION", "TEST");
        customMap.put("OUT_USUARIO_MODIFICACION", "TEST");
        customMap.put("OUT_ESTADO", "ACTIVO");

        setup();

        assertNotNull(repository.ejecutar(1));
    }
}