package cl.bancochile.plataformacomercial.controllimitestaller.fixture;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.MonedaBanco;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.ValorMonedaBanco;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MonedaFixture {

    public static List<MonedaBanco> getMonedasBanco() {
        List<MonedaBanco> lista = new ArrayList<>();
        lista.add(getMonedaBanco("CLP", 1));
        lista.add(getMonedaBanco("CLF", 98));
        lista.add(getMonedaBanco("USD", 11));
        lista.add(getMonedaBanco("EUR", 96));
        return lista;
    }

    public static List<MonedaBanco> getMonedasBancoEmpty() {
        return new ArrayList<>();
    }

    public static MonedaBanco getMonedaBanco(String codigo, long codigoBanco) {
        return getMonedaBanco(codigo, codigoBanco, BigDecimal.ONE);
    }

    public static MonedaBanco getMonedaBanco(String codigo, long codigoBanco, BigDecimal valorObservado) {
        return new MonedaBanco.Builder()
                .codigo(codigo)
                .codigoBanco(codigoBanco)
                .nombre("Peso")
                .simbolo("$")
                .descripcion("Peso Chileno")
                .id(1)
                .fechaCreacion("01/01/1999")
                .fechaModificacion("01/01/1999")
                .valor(getValorMonedaBanco(1, valorObservado))
                .estado(EstadoTipoLimiteEnum.ACTIVO)
                .build();
    }

    public static ValorMonedaBanco getValorMonedaBanco(long idMoneda) {
        return getValorMonedaBanco(idMoneda, BigDecimal.ONE);
    }

    public static ValorMonedaBanco getValorMonedaBanco(long idMoneda, BigDecimal valorObservado) {
        return new ValorMonedaBanco.Builder()
                .id(idMoneda)
                .idMoneda(1)
                .motivoModificacion("TEST")
                .paridadBancoCentral(BigDecimal.ONE)
                .paridadReuters(BigDecimal.ONE)
                .valorObservado(valorObservado)
                .usuarioCreacion("test")
                .usuarioModificacion("test")
                .fechaModificacion("01/01/1999")
                .fechaCreacion("01/01/1999")
                .fecha("01/01/1999")
                .origenData("A")
                .build();
    }

}
