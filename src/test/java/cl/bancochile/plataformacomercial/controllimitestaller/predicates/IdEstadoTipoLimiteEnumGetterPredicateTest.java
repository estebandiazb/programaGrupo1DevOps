package cl.bancochile.plataformacomercial.controllimitestaller.predicates;

import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class IdEstadoTipoLimiteEnumGetterPredicateTest {

    @InjectMocks
    private IdEstadoTipoLimiteEnumGetterPredicate predicate;

    @Test
    public void get() {
        assertNotNull(predicate.get(EstadoTipoLimiteEnum.ACTIVO));
    }
}