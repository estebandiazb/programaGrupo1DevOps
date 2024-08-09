package cl.bancochile.plataformacomercial.controllimitestaller.domain;

import java.util.List;

public class VariableLimite {

    private long id;
    private long idVariableAtributo;
    private String codigoVariable;
    private String codigoAtributo;
    private String tooltip;
    private Object valor;
    private List<ItemVariableLimite> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigoVariable() {
        return codigoVariable;
    }

    public void setCodigoVariable(String codigoVariable) {
        this.codigoVariable = codigoVariable;
    }

    public String getCodigoAtributo() {
        return codigoAtributo;
    }

    public void setCodigoAtributo(String codigoAtributo) {
        this.codigoAtributo = codigoAtributo;
    }

    public long getIdVariableAtributo() {
        return idVariableAtributo;
    }

    public void setIdVariableAtributo(long idVariableAtributo) {
        this.idVariableAtributo = idVariableAtributo;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public List<ItemVariableLimite> getItems() {
        return items;
    }

    public void setItems(List<ItemVariableLimite> items) {
        this.items = items;
    }

    public static final class Builder {
        private long id;
        private long idVariableAtributo;
        private String codigoVariable;
        private String codigoAtributo;
        private String tooltip;
        private Object valor;
        private List<ItemVariableLimite> items;

        public Builder() {
            //NOSONAR
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder idVariableAtributo(long idVariableAtributo) {
            this.idVariableAtributo = idVariableAtributo;
            return this;
        }

        public Builder codigoVariable(String codigoVariable) {
            this.codigoVariable = codigoVariable;
            return this;
        }

        public Builder codigoAtributo(String codigoAtributo) {
            this.codigoAtributo = codigoAtributo;
            return this;
        }

        public Builder tooltip(String tooltip) {
            this.tooltip = tooltip;
            return this;
        }

        public Builder valor(Object valor) {
            this.valor = valor;
            return this;
        }

        public Builder items(List<ItemVariableLimite> items) {
            this.items = items;
            return this;
        }

        public VariableLimite build() {
            VariableLimite variableLimite = new VariableLimite();
            variableLimite.setId(id);
            variableLimite.setIdVariableAtributo(idVariableAtributo);
            variableLimite.setCodigoVariable(codigoVariable);
            variableLimite.setCodigoAtributo(codigoAtributo);
            variableLimite.setTooltip(tooltip);
            variableLimite.setValor(valor);
            variableLimite.setItems(items);
            return variableLimite;
        }
    }
}
