package cl.bancochile.plataformacomercial.controllimitestaller.domain;

import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;

public class MonedaBanco {

    private long id;
    private String codigo;
    private long codigoBanco;
    private String nombre;
    private String descripcion;
    private String simbolo;
    private String usuarioCreacion;
    private String fechaCreacion;
    private String fechaModificacion;
    private String usuarioModificacion;
    private EstadoTipoLimiteEnum estado;
    private ValorMonedaBanco valor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public long getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(long codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public EstadoTipoLimiteEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoTipoLimiteEnum estado) {
        this.estado = estado;
    }

    public ValorMonedaBanco getValor() {
        return valor;
    }

    public void setValor(ValorMonedaBanco valor) {
        this.valor = valor;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public static final class Builder {
        private final MonedaBanco monedaBanco;

        public Builder() {
            monedaBanco = new MonedaBanco();
        }

        public Builder id(long id) {
            monedaBanco.setId(id);
            return this;
        }

        public Builder codigo(String codigo) {
            monedaBanco.setCodigo(codigo);
            return this;
        }

        public Builder codigoBanco(long codigoBanco) {
            monedaBanco.setCodigoBanco(codigoBanco);
            return this;
        }

        public Builder nombre(String nombre) {
            monedaBanco.setNombre(nombre);
            return this;
        }

        public Builder descripcion(String descripcion) {
            monedaBanco.setDescripcion(descripcion);
            return this;
        }

        public Builder simbolo(String simbolo) {
            monedaBanco.setSimbolo(simbolo);
            return this;
        }

        public Builder fechaCreacion(String fechaCreacion) {
            monedaBanco.setFechaCreacion(fechaCreacion);
            return this;
        }

        public Builder fechaModificacion(String fechaModificacion) {
            monedaBanco.setFechaModificacion(fechaModificacion);
            return this;
        }

        public Builder estado(EstadoTipoLimiteEnum estado) {
            monedaBanco.setEstado(estado);
            return this;
        }

        public Builder valor(ValorMonedaBanco valor) {
            monedaBanco.setValor(valor);
            return this;
        }

        public Builder usuarioCreacion(String usuarioCreacion) {
            monedaBanco.setUsuarioCreacion(usuarioCreacion);
            return this;
        }

        public Builder usuarioModificacion(String usuarioModificacion) {
            monedaBanco.setUsuarioModificacion(usuarioModificacion);
            return this;
        }

        public MonedaBanco build() {
            return monedaBanco;
        }
    }
}
