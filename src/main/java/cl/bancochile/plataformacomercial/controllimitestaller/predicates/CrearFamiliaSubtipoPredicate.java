package cl.bancochile.plataformacomercial.controllimitestaller.predicates;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import org.apache.commons.collections.Predicate;

public class CrearFamiliaSubtipoPredicate implements Predicate {

    @Override
    public boolean evaluate(Object o) {
        return ((ItemVariable) o).getId() == null;
    }
}
