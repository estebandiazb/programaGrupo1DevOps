package cl.bancochile.plataformacomercial.controllimitestaller.fixture;

import cl.bancochile.plataformacomercial.controllimitestaller.domain.ResumenAtributos;
import cl.bancochile.plataformacomercial.controllimitestaller.domain.TipoLimite;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;

import java.util.ArrayList;
import java.util.List;

public class TipoLimiteFixture {

    public static TipoLimite getTipoLimite(String nombre, EstadoTipoLimiteEnum estado) {
        return new TipoLimite.Builder()
                .id(2L)
                .nombre(nombre)
                .estado(estado)
                .usuarioCreacion("test")
                .fechaCreacion("01/01/1900")
                .usuarioActualizacion("test")
                .fechaActualizacion("01/02/1900")
                .version(1)
                .idVersion(1)
                .codigo("COD")
                .comentarios("comentarios")
                .build();
    }

    public static TipoLimite getTipoLimite(long idTipoLimite, String nombre, EstadoTipoLimiteEnum estado) {

        TipoLimite tipoLimite = getTipoLimite(nombre, estado);
        tipoLimite.setId(idTipoLimite);
        return tipoLimite;
    }

    public static List<TipoLimite> getTipoLimites() {
        List<TipoLimite> tipoLimites = new ArrayList<>();
        tipoLimites.add(getTipoLimite("test1", EstadoTipoLimiteEnum.ACTIVO));
        tipoLimites.add(getTipoLimite("test2", EstadoTipoLimiteEnum.ACTIVO));
        tipoLimites.add(getTipoLimite("test3", EstadoTipoLimiteEnum.HISTORICO));
        tipoLimites.add(getTipoLimite("test4", EstadoTipoLimiteEnum.EN_PROCESO));
        tipoLimites.add(getTipoLimite("test5", EstadoTipoLimiteEnum.ELIMINADO));
        tipoLimites.add(getTipoLimite("test6", EstadoTipoLimiteEnum.BORRADOR));
        return tipoLimites;
    }

    public static List<TipoLimite> getTipoLimites2(Long idTipoLimite) {
        List<TipoLimite> tipoLimites = new ArrayList<>();
        tipoLimites.add(getTipoLimite( idTipoLimite, "test1", EstadoTipoLimiteEnum.BORRADOR));
        tipoLimites.add(getTipoLimite( idTipoLimite,"test2", EstadoTipoLimiteEnum.BORRADOR));
        tipoLimites.add(getTipoLimite( idTipoLimite,"test3", EstadoTipoLimiteEnum.EN_PROCESO));
        tipoLimites.add(getTipoLimite( idTipoLimite,"test4", EstadoTipoLimiteEnum.EN_PROCESO));
        return tipoLimites;
    }

    public static ResumenAtributos getResumenAtributos() {
        return new ResumenAtributos.Builder()
                .basicos(1)
                .avanzados(1)
                .normativos(1)
                .sinCategoria(1)
                .build();
    }

}
