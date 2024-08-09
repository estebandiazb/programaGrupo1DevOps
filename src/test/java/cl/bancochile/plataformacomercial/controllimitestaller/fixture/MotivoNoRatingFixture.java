package cl.bancochile.plataformacomercial.controllimitestaller.fixture;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.MotivoNoRating;

import java.util.Arrays;
import java.util.List;

public class MotivoNoRatingFixture {

    public static List<MotivoNoRating> getMotivosNoRating(){
        return Arrays.asList(
                new MotivoNoRating.Builder()
                        .id(1L)
                        .orden(1)
                        .descripcion("Motivo Nro 1")
                        .build(),
                new MotivoNoRating.Builder()
                        .id(2L)
                        .orden(2)
                        .descripcion("Motivo Nro 2")
                        .build()
        );
    }
}
