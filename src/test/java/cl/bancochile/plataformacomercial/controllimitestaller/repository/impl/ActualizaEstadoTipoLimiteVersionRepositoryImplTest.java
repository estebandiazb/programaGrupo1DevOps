package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ActualizaEstadoTipoLimiteVersionRepositoryImplTest extends AbstractRepositoyImplTest {

    @InjectMocks
    private ActualizaEstadoTipoLimiteVersionRepositoryImpl repository;

    @Test
    public void ejecutar() throws PlataformaBaseException {
        setup();
        repository.ejecutar(1L, EstadoTipoLimiteEnum.ACTIVO, "mmena");
    }

    @Test(expected = Exception.class)
    public void ejecutarFail() throws PlataformaBaseException {
        setupNOK();
        repository.ejecutar(1L, EstadoTipoLimiteEnum.HISTORICO, "mmena");
    }
}
