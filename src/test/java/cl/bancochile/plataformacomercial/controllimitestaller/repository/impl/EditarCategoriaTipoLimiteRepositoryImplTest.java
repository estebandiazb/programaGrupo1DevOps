package cl.bancochile.plataformacomercial.controllimitestaller.repository.impl;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.CategoriaSeleccionable;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.CategoriaAtributoEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EditarCategoriaTipoLimiteRepositoryImplTest extends AbstractRepositoyImplTest{

    @InjectMocks
    private EditarCategoriaTipoLimiteRepositoryImpl repository;

    @Test
    public void ejecutar() throws PlataformaBaseException {
        setup();
        repository.ejecutar(1L, 1L, new CategoriaSeleccionable.Builder()
                        .categoria(CategoriaAtributoEnum.BASICO)
                        .idAtributo(1L)
                        .seleccionado(Boolean.TRUE)
                .build(), "comentario");
        repository.ejecutar(1L, 1L, null, "comentario");
    }

    @Test(expected = Exception.class)
    public void ejecutarFail() throws PlataformaBaseException {
        setupNOK();
        repository.ejecutar(1L, 1L, new CategoriaSeleccionable.Builder()
                .categoria(CategoriaAtributoEnum.BASICO)
                .idAtributo(1L)
                .seleccionado(Boolean.TRUE)
                .build(), "comentario");
    }
}
