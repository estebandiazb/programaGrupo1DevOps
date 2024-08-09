package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.FamiliaLimite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CrearFamiliaSubtipoRepositoryImplTest extends AbstractRepositoyImplTest {

    @InjectMocks
    private CrearFamiliaSubtipoRepositoryImpl repository;

    @Test
    public void ejecutar() throws PlataformaBaseException {
        setup();
        repository.ejecutar("nombre familia subtipo");
    }

    @Test(expected = Exception.class)
    public void ejecutarFail() throws PlataformaBaseException {
        setupNOK();
        repository.ejecutar("nombre familia subtipo");
    }

    @Test(expected = Exception.class)
    public void ejecutarFail2() throws PlataformaBaseException {
        setupCodigoNOK(-2);
        repository.ejecutar("nombre familia subtipo");
    }
}
