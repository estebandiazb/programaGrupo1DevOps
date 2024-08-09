package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimiteFull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ActualizarVersionTipoLimiteRepositoryImplTest extends AbstractRepositoyImplTest {


    @InjectMocks
    private ActualizarVersionTipoLimiteRepositoryImpl repository;

    @Test
    public void ejecutar() throws PlataformaBaseException {
        setup();
        repository.ejecutar(new TipoLimiteFull.Builder()
                .id(1L)
                .nombre("Tipo Limite Editado")
                .descripcion("Comentarios")
                .build());
    }

    @Test(expected = PlataformaBaseException.class)
    public void ejecutarFail() throws PlataformaBaseException {
        setupNOK();
        repository.ejecutar(new TipoLimiteFull.Builder()
                .id(1L)
                .nombre("Tipo Limite Editado")
                .descripcion("Comentarios")
                .build());
    }
}
