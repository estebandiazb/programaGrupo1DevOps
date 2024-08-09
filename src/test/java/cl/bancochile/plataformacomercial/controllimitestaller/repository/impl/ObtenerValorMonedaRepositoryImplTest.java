package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ObtenerValorMonedaRepositoryImplTest extends AbstractRepositoyImplTest {

    @InjectMocks
    private ObtenerValorMonedaRepositoryImpl repository;

    @Test
    public void ejecutarCodigo() throws PlataformaBaseException {
        setupMap();
        assertNotNull(repository.ejecutar("CLP"));
    }

    @Test
    public void ejecutarId() throws PlataformaBaseException {
        setupMap();
        assertNotNull(repository.ejecutar(1));

    }

    private void setupMap() {
        customMap = new HashMap<>();
        customMap.put("OUT_ID_VALOR", 1);
        customMap.put("OUT_ID_MONEDA", 1);
        customMap.put("OUT_FECHA", "01/01/1810");
        customMap.put("OUT_FECHA_CREACION", "01/01/1810");
        customMap.put("OUT_FECHA_MODIFICACION", "01/01/1810");
        customMap.put("OUT_USUARIO_CREACION", "TEST");
        customMap.put("OUT_USUARIO_MODIFICACION", "TEST");
        customMap.put("OUT_VALOR_OBSERVADO", 1);
        customMap.put("OUT_PARIDAD_RETUTERS", 1);
        customMap.put("OUT_PARIDAD_BANCO_CENTRAL", 1);
        customMap.put("OUT_MOTIVO_MODIFICACION", "TEST");
        customMap.put("OUT_ORIGEN_DATA", "A");
        setup();
    }


}