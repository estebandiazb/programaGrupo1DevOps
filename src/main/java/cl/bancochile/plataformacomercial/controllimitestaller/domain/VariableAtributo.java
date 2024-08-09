package cl.bancochile.plataformacomercial.controllimitestaller.domain;

import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.TipoValorVariableEnum;
import com.google.common.base.MoreObjects;

import java.util.List;

public class VariableAtributo {

    private Long idAtributo;
    private Long id;
    private String codigo;
    private String nombre;
    private String tooltip;
    private Object valor;
    private boolean seleccionado;
    private TipoValorVariableEnum tipoValor;
    private List<ItemVariable> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ItemVariable> getItems() {
        return items;
    }

    public void setItems(List<ItemVariable> items) {
        this.items = items;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public TipoValorVariableEnum getTipoValor() {
        return tipoValor;
    }

    public void setTipoValor(TipoValorVariableEnum tipoValor) {
        this.tipoValor = tipoValor;
    }

    public Long getIdAtributo() {
        return idAtributo;
    }

    public void setIdAtributo(Long idAtributo) {
        this.idAtributo = idAtributo;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public static final class Builder {
        private final VariableAtributo variable;

        public Builder() {
            variable = new VariableAtributo();
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

        public Builder tooltip(String tooltip) {
            variable.setTooltip(tooltip);
            return this;
        }

        public Builder items(List<ItemVariable> items) {
            variable.setItems(items);
            return this;
        }

        public Builder valor(Object valor) {
            variable.setValor(valor);
            return this;
        }

        public Builder tipoValor(TipoValorVariableEnum tipoValor) {
            variable.setTipoValor(tipoValor);
            return this;
        }

        public Builder idAtributo(long idAtributo) {
            variable.setIdAtributo(idAtributo);
            return this;
        }

        public Builder seleccionado(boolean seleccionado) {
            variable.setSeleccionado(seleccionado);
            return this;
        }

        public VariableAtributo build() {
            return variable;
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idAtributo=", idAtributo)
                .add("id", id)
                .add("codigo", codigo)
                .add("nombre", nombre)
                .add("tooltip", tooltip)
                .add("valor", valor)
                .add("tipoValor", tipoValor)
                .add("seleccionado", seleccionado)
                .toString();
    }
}
