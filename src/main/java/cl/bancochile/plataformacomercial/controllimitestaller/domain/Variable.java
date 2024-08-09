package cl.bancochile.plataformacomercial.controllimitestaller.domain;

import java.util.List;

public class Variable {

    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Integer tipoDato;
    private String estado;
    private Integer tipoSeleccion;
    private Integer cantidad;
    private List<ItemVariable> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public Integer getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(Integer tipoDato) {
        this.tipoDato = tipoDato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getTipoSeleccion() {
        return tipoSeleccion;
    }

    public void setTipoSeleccion(Integer tipoSeleccion) {
        this.tipoSeleccion = tipoSeleccion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public List<ItemVariable> getItems() {
        return items;
    }

    public void setItems(List<ItemVariable> items) {
        this.items = items;
    }

    public static final class Builder {
        private final Variable variable;

        public Builder() {
            variable = new Variable();
        }

        public Builder id(Long id) {
            variable.setId(id);
            return this;
        }

        public Builder codigo(String codigo) {
            variable.setCodigo(codigo);
            return this;
        }

        public Builder nombre(String nombre) {
            variable.setNombre(nombre);
            return this;
        }

        public Builder descripcion(String descripcion) {
            variable.setDescripcion(descripcion);
            return this;
        }

        public Builder tipoDato(Integer tipoDato) {
            variable.setTipoDato(tipoDato);
            return this;
        }

        public Builder estado(String estado) {
            variable.setEstado(estado);
            return this;
        }

        public Builder tipoSeleccion(Integer tipoSeleccion) {
            variable.setTipoSeleccion(tipoSeleccion);
            return this;
        }

        public Builder cantidad(Integer cantidad) {
            variable.setCantidad(cantidad);
            return this;
        }

        public Builder items(List<ItemVariable> items) {
            variable.setItems(items);
            return this;
        }

        public Variable build() {
            return variable;
        }
    }
}
