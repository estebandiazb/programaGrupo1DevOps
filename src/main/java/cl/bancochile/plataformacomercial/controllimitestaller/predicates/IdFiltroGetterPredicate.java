package cl.bancochile.plataformacomercial.controllimitestaller.predicates;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.Filtro;
import cl.bancochile.plataformacomercial.lib.controllimites.common.predicates.GetterPredicate;

public class IdFiltroGetterPredicate implements GetterPredicate<Filtro> {
    @Override
    public Object get(Filtro target) {
        return target.getId();
    }
}
