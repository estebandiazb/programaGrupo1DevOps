package cl.bancochile.plataformacomercial.controllimitestaller.domain;

import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;
import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.OpcionTipoLimiteEnum;

import java.util.List;

public class TipoLimite {

    private long id;
    private long idVersion;
    private long idFamiliaLimite;
    private String codigo;
    private int version;
    private String nombre;
    private String fechaCreacion;
    private String usuarioCreacion;
    private String fechaActualizacion;
    private String usuarioActualizacion;
    private EstadoTipoLimiteEnum estado;
    private ResumenAtributos resumenAtributos;
    private String comentarios;
    private List<OpcionTipoLimiteEnum> opciones;
    private long cantidadAtributos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(long idVersion) {
        this.idVersion = idVersion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getUsuarioActualizacion() {
        return usuarioActualizacion;
    }

    public void setUsuarioActualizacion(String usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }

    public EstadoTipoLimiteEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoTipoLimiteEnum estado) {
        this.estado = estado;
    }

    public ResumenAtributos getResumenAtributos() {
        return resumenAtributos;
    }

    public void setResumenAtributos(ResumenAtributos resumenAtributos) {
        this.resumenAtributos = resumenAtributos;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public List<OpcionTipoLimiteEnum> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<OpcionTipoLimiteEnum> opciones) {
        this.opciones = opciones;
    }

    public long getIdFamiliaLimite() {
        return idFamiliaLimite;
    }

    public void setIdFamiliaLimite(long idFamiliaLimite) {
        this.idFamiliaLimite = idFamiliaLimite;
    }

    public long getCantidadAtributos() {
        return cantidadAtributos;
    }

    public void setCantidadAtributos(long cantidadAtributos) {
        this.cantidadAtributos = cantidadAtributos;
    }

    public static final class Builder {
        private final TipoLimite tipoLimite;

        public Builder() {
            tipoLimite = new TipoLimite();
        }

        public Builder id(long id) {
            tipoLimite.setId(id);
            return this;
        }

        public Builder idVersion(long idVersion) {
            tipoLimite.setIdVersion(idVersion);
            return this;
        }

        public Builder idFamiliaLimite(long idFamiliaLimite) {
            tipoLimite.setIdFamiliaLimite(idFamiliaLimite);
            return this;
        }

        public Builder codigo(String codigo) {
            tipoLimite.setCodigo(codigo);
            return this;
        }

        public Builder version(int version) {
            tipoLimite.setVersion(version);
            return this;
        }

        public Builder nombre(String nombre) {
            tipoLimite.setNombre(nombre);
            return this;
        }

        public Builder fechaCreacion(String fechaCreacion) {
            tipoLimite.setFechaCreacion(fechaCreacion);
            return this;
        }

        public Builder usuarioCreacion(String usuarioCreacion) {
            tipoLimite.setUsuarioCreacion(usuarioCreacion);
            return this;
        }

        public Builder fechaActualizacion(String fechaActualizacion) {
            tipoLimite.setFechaActualizacion(fechaActualizacion);
            return this;
        }

        public Builder usuarioActualizacion(String usuarioActualizacion) {
            tipoLimite.setUsuarioActualizacion(usuarioActualizacion);
            return this;
        }

        public Builder estado(EstadoTipoLimiteEnum estado) {
            tipoLimite.setEstado(estado);
            return this;
        }

        public Builder resumenAtributos(ResumenAtributos resumenAtributos) {
            tipoLimite.setResumenAtributos(resumenAtributos);
            return this;
        }

        public Builder comentarios(String comentarios) {
            tipoLimite.setComentarios(comentarios);
            return this;
        }

        public Builder opciones(List<OpcionTipoLimiteEnum> opciones) {
            tipoLimite.setOpciones(opciones);
            return this;
        }

        public Builder cantidadAtributos(long cantidadAtributos) {
            tipoLimite.setCantidadAtributos(cantidadAtributos);
            return this;
        }

        public TipoLimite build() {
            return tipoLimite;
        }
    }
}
