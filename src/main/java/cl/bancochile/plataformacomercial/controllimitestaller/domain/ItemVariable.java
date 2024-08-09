package cl.bancochile.plataformacomercial.controllimitestaller.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.MoreObjects;


public class ItemVariable {

    private Long id;
    private Object valor;
    @JsonIgnore
    private Long idVariable;
    @JsonIgnore
    private boolean asignado;
    private boolean seleccionado;

    public ItemVariable() {
    }

    public ItemVariable(ItemVariable itemVariable) {
        this.id = itemVariable.getId();
        this.valor = itemVariable.getValor();
        this.idVariable = itemVariable.getIdVariable();
        this.asignado = itemVariable.isAsignado();
        this.seleccionado = itemVariable.isSeleccionado();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public Long getIdVariable() {
        return idVariable;
    }

    public void setIdVariable(Long idVariable) {
        this.idVariable = idVariable;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    public static final class Builder {
        private final ItemVariable itemVariable;

        public Builder() {
            itemVariable = new ItemVariable();
        }

        public Builder id(Long id) {
            itemVariable.setId(id);
            return this;
        }

        public Builder valor(Object valor) {
            itemVariable.setValor(valor);
            return this;
        }

        public Builder idVariable(Long idVariable) {
            itemVariable.setIdVariable(idVariable);
            return this;
        }

        public Builder seleccionado(boolean isSeleccionado) {
            itemVariable.setSeleccionado(isSeleccionado);
            return this;
        }

        public Builder asignado(boolean asignado) {
            itemVariable.setAsignado(asignado);
            return this;
        }
        public ItemVariable build() {
            return itemVariable;
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idVariable", idVariable)
                .add("id", id)
                .add("valor", valor)
                .add("seleccionado", seleccionado)
                .toString();
    }
}
