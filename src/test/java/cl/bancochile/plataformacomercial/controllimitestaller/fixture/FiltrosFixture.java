package cl.bancochile.plataformacomercial.controllimitestaller.fixture;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.Filtro;

import java.util.ArrayList;
import java.util.List;

public class FiltrosFixture {

    public static Filtro getFiltro(long id, String nombre, String codigo) {
        return new Filtro.Builder()
                .id(id)
                .nombre(nombre)
                .codigo(codigo)
                .build();
    }

    public static List<Filtro> getFiltrosDesordenados() {

        List<Filtro> listado = new ArrayList<>();

        listado.add(getFiltro(3, "C", "C"));
        listado.add(getFiltro(4, "D", "D"));
        listado.add(getFiltro(2, "b", "b"));
        listado.add(getFiltro( 1, "A", "A"));
        listado.add(getFiltro( 6, null, "A"));
        listado.add(getFiltro( 5, "E", "E"));

        return listado;
    }
}
