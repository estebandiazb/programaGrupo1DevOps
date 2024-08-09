package cl.bancochile.plataformacomercial.controllimitestaller.fixture;

import cl.bancochile.plataformacomercial.lib.controllimites.common.domain.Bitacora;

import java.util.Arrays;
import java.util.List;

public class BitacoraFixture {

    public static List<Bitacora> getMotivosNoRatingBitacora(){
        return Arrays.asList(
                new Bitacora.Builder()
                        .idKey(1L)
                        .funcionalidad("MOTIVO_NO_RATING")
                        .usuario("usuario")
                        .build(),
                new Bitacora.Builder()
                        .idKey(1L)
                        .funcionalidad("MOTIVO_NO_RATING")
                        .usuario("usuario")
                        .jsonData("{ \"id\": 1, \"descripcion\": \"descripcion\" }")
                        .build()
        );
    }
}
