package cl.bancochile.plataformacomercial.controllimitestaller.predicates;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.Filtro;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class NombreFiltroGetterPredicateTest {
    @InjectMocks
    private NombreFiltroGetterPredicate predicate;

    @Test
    public void get() {
        assertNotNull(predicate.get(new Filtro.Builder()
                .nombre("test")
                .build()));
    }
}