package cl.bancochile.plataformacomercial.controllimitestaller.predicates;

import cl.bancochile.plataformacomercial.lib.controllimites.common.predicates.GetterPredicate;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;

public class IdEstadoTipoLimiteEnumGetterPredicate implements GetterPredicate<EstadoTipoLimiteEnum> {
    @Override
    public Object get(EstadoTipoLimiteEnum target) {
        return target.getId();
    }
}
