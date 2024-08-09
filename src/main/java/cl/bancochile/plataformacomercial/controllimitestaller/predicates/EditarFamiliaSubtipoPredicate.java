package cl.bancochile.plataformacomercial.controllimitestaller.predicates;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.ItemVariable;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import java.util.List;

public class EditarFamiliaSubtipoPredicate implements Predicate {

    private final List<ItemVariable> subtipos;

    public EditarFamiliaSubtipoPredicate(List<ItemVariable> subtipos){
        this.subtipos = subtipos;
    }

    @Override
    public boolean evaluate(Object o) {
        return existeSubtipo((ItemVariable) o);
    }

    private boolean existeSubtipo(final ItemVariable subtipo){
        return CollectionUtils.exists(subtipos, new Predicate() {
            @Override
            public boolean evaluate(Object o) {
                ItemVariable subtipoSaved = ((ItemVariable) o);
                return subtipo.getId() != null
                        && subtipo.getId().longValue() == subtipoSaved.getId()
                        && !subtipo.getValor().equals(subtipoSaved.getValor());
            }
        });
    }
}