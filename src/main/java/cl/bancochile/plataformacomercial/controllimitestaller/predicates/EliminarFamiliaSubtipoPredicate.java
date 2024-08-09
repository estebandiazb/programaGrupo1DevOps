package cl.bancochile.plataformacomercial.controllimitestaller.predicates;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import java.util.List;

public class EliminarFamiliaSubtipoPredicate implements Predicate {

    private final List<ItemVariable> subtipos;

    public EliminarFamiliaSubtipoPredicate(List<ItemVariable> subtipos){
        this.subtipos = subtipos;
    }

    @Override
    public boolean evaluate(Object o) {
        return !existeSubtipo(((ItemVariable) o).getId());
    }

    private boolean existeSubtipo(final Long idSubtipo){
        return CollectionUtils.exists(subtipos, new Predicate() {
            @Override
            public boolean evaluate(Object o) {
                return idSubtipo.equals(((ItemVariable) o ).getId());
            }
        });
    }

}
