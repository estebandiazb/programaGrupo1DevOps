package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EditarItemVariableRepositoryImplTest extends AbstractRepositoyImplTest {

    @InjectMocks
    private EditarItemVariableRepositoryImpl repository;

    @Test
    public void ejecutar() throws PlataformaBaseException {
        repository.ejecutar(new ItemVariable());
    }

    @Test(expected = PlataformaBaseException.class)
    public void ejecutarNOK() throws PlataformaBaseException {
        setupNOK();
        repository.ejecutar(new ItemVariable());
    }
}