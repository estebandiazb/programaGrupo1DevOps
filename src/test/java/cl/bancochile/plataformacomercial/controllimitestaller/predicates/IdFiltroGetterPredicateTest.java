package cl.bancochile.plataformacomercial.controllimitestaller.predicates;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.Filtro;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class IdFiltroGetterPredicateTest {

    @InjectMocks
    private IdFiltroGetterPredicate predicate;

    @Test
    public void get() {
        assertNotNull(predicate.get(new Filtro.Builder()
                .id(1L)
                .build()));
    }
}