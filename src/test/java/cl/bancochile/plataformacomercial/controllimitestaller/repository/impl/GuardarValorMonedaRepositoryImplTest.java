package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.fixture.MonedaFixture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GuardarValorMonedaRepositoryImplTest extends AbstractRepositoyImplTest {

    @InjectMocks
    private GuardarValorMonedaRepositoryImpl repository;

    @Test
    public void ejecutar() throws PlataformaBaseException {
        repository.ejecutar(MonedaFixture.getValorMonedaBanco(1));
    }

    @Test(expected = PlataformaBaseException.class)
    public void ejecutarNOK() throws PlataformaBaseException {
        setupNOK();
        repository.ejecutar(MonedaFixture.getValorMonedaBanco(1));
    }
}