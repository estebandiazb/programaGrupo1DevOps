package cl.bancochile.plataformacomercial.controllimitestaller.domain;

public class ItemVariableLimite {

    private long id;
    private long idVariableLimite;
    private long idVariableItem;
    private boolean seleccionado;
    private Object valor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdVariableLimite() {
        return idVariableLimite;
    }

    public void setIdVariableLimite(long idVariableLimite) {
        this.idVariableLimite = idVariableLimite;
    }

    public long getIdVariableItem() {
        return idVariableItem;
    }

    public void setIdVariableItem(long idVariableItem) {
        this.idVariableItem = idVariableItem;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public static final class Builder {
        private long id;
        private long idVariableLimite;
        private long idVariableItem;
        private boolean seleccionado;
        private Object valor;

        public Builder() {
            //NOSONAR
        }

        public static Builder anItemVariableLimite() {
            return new Builder();
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder idVariableLimite(long idVariableLimite) {
            this.idVariableLimite = idVariableLimite;
            return this;
        }

        public Builder idVariableItem(long idVariableItem) {
            this.idVariableItem = idVariableItem;
            return this;
        }

        public Builder seleccionado(boolean seleccionado) {
            this.seleccionado = seleccionado;
            return this;
        }

        public Builder valor(Object valor) {
            this.valor = valor;
            return this;
        }

        public ItemVariableLimite build() {
            ItemVariableLimite itemVariableLimite = new ItemVariableLimite();
            itemVariableLimite.setId(id);
            itemVariableLimite.setIdVariableLimite(idVariableLimite);
            itemVariableLimite.setIdVariableItem(idVariableItem);
            itemVariableLimite.setSeleccionado(seleccionado);
            itemVariableLimite.setValor(valor);
            return itemVariableLimite;
        }
    }
}
