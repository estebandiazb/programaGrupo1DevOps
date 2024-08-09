package cl.bancochile.plataformacomercial.controllimitestaller.domain;

import cl.bancochile.plataformacomercial.lib.controllimites.taller.domain.TipoLimiteVersion;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;

import java.util.List;

public class TipoLimiteFull extends TipoLimiteVersion {
    private long idFamiliaLimite;
    private String nombreFamiliaLimite;
    private String prefijo;
    private List<Atributo> atributos;

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public long getIdFamiliaLimite() {
        return idFamiliaLimite;
    }

    public void setIdFamiliaLimite(long idFamiliaLimite) {
        this.idFamiliaLimite = idFamiliaLimite;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }

    public String getNombreFamiliaLimite() {
        return nombreFamiliaLimite;
    }

    public void setNombreFamiliaLimite(String nombreFamiliaLimite) {
        this.nombreFamiliaLimite = nombreFamiliaLimite;
    }

    public static final class Builder {
        private final TipoLimiteFull tipoLimiteFull;

        public Builder() {
            tipoLimiteFull = new TipoLimiteFull();
        }

        public TipoLimiteFull.Builder id(Long id) {
            tipoLimiteFull.setId(id);
            return this;
        }

        public TipoLimiteFull.Builder idTipoLimite(Long id) {
            tipoLimiteFull.setIdTipoLimite(id);
            return this;
        }

        public TipoLimiteFull.Builder codigo(String codigo) {
            tipoLimiteFull.setCodigo(codigo);
            return this;
        }

        public TipoLimiteFull.Builder version(Integer version) {
            tipoLimiteFull.setVersion(version);
            return this;
        }

        public TipoLimiteFull.Builder nombre(String nombre) {
            tipoLimiteFull.setNombre(nombre);
            return this;
        }

        public TipoLimiteFull.Builder descripcion(String id) {
            tipoLimiteFull.setComentarios(id);
            return this;
        }

        public TipoLimiteFull.Builder estado(EstadoTipoLimiteEnum estado) {
            tipoLimiteFull.setEstado(estado);
            return this;
        }

        public TipoLimiteFull.Builder fechaCreacion(String fecha) {
            tipoLimiteFull.setFechaCreacion(fecha);
            return this;
        }

        public TipoLimiteFull.Builder fechaActualizacion(String fecha) {
            tipoLimiteFull.setFechaActualizacion(fecha);
            return this;
        }

        public TipoLimiteFull.Builder usuarioCreacion(String usuario) {
            tipoLimiteFull.setUsuarioCreacion(usuario);
            return this;
        }

        public TipoLimiteFull.Builder usuarioActualizacion(String usuario) {
            tipoLimiteFull.setUsuarioModificacion(usuario);
            return this;
        }

        public TipoLimiteFull.Builder atributos(List<Atributo> atributos) {
            tipoLimiteFull.setAtributos(atributos);
            return this;
        }

        public TipoLimiteFull.Builder familiaLimite(long idFamiliaLimite) {
            tipoLimiteFull.setIdFamiliaLimite(idFamiliaLimite);
            return this;
        }

        public TipoLimiteFull.Builder prefijo(String prefijo) {
            tipoLimiteFull.setPrefijo(prefijo);
            return this;
        }

        public TipoLimiteFull.Builder nombreFamiliaLimite(String nombreFamiliaLimite) {
            tipoLimiteFull.setNombreFamiliaLimite(nombreFamiliaLimite);
            return this;
        }

        public TipoLimiteFull build() {
            return tipoLimiteFull;
        }
    }
}
