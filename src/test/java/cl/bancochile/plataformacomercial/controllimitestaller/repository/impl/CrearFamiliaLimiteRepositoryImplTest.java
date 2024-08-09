package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.FamiliaLimite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CrearFamiliaLimiteRepositoryImplTest extends AbstractRepositoyImplTest  {

    @InjectMocks
    private CrearFamiliaLimiteRepositoryImpl repository;

    @Test
    public void ejecutar() throws PlataformaBaseException {
        setup();
        repository.ejecutar(new FamiliaLimite());
    }

    @Test(expected = Exception.class)
    public void ejecutarFail() throws PlataformaBaseException {
        setupNOK();
        repository.ejecutar(new FamiliaLimite());
    }

    @Test(expected = Exception.class)
    public void ejecutarFail2() throws PlataformaBaseException {
        setupCodigoNOK(-1);
        repository.ejecutar(new FamiliaLimite());
    }
}
