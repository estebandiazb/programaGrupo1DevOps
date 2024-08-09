package cl.bancochile.plataformacomercial.controllimitestaller.fixture;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.MonedaBanco;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ParametroMac;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ValorMonedaBanco;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ParametroMacFixture {

    public static ParametroMac getParametroMac() {
        ParametroMac parametroMac = new ParametroMac();

        return new ParametroMac.Builder()
                .id(1L)
                .parametro("DIAS_RATING")
                .valor(21L)
                .descripcion("Rating")
                .build();
    }

    public static List<ParametroMac> getParametroMac2() {
        List<ParametroMac> lista = new ArrayList<>();
        lista.add(getParametroMac());
        return lista;
    }

}
