package cl.bancochile.plataformacomercial.controllimitestaller.fixture;

import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.FamiliaLimite;

import java.util.ArrayList;
import java.util.List;

public class FamiliaLimiteFixture {

    public static FamiliaLimite getFamiliaLimite(String nombre){
        return new FamiliaLimite.Builder()
                .id(1L)
                .nombre(nombre)
                .usuarioCreacion("user")
                .build();
    }

    public static List<FamiliaLimite> getFamiliasLimites() {
        List<FamiliaLimite> familias = new ArrayList<>();
        familias.add(getFamiliaLimite("test1"));
        familias.add(getFamiliaLimite("test2"));
        familias.add(getFamiliaLimite("test3"));
        familias.add(getFamiliaLimite("test4"));
        return familias;
    }
}
