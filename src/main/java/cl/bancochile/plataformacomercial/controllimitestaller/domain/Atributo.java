package cl.bancochile.plataformacomercial.controllimitestaller.domain;

import com.google.common.base.MoreObjects;

import java.util.List;


public class Atributo {

    private long id;
    private String codigo;
    private String nombre;
    private String comentario;
    private List<CategoriaSeleccionable> categorias;
    private boolean obligatorio;
    private List<VariableAtributo> variables;

    public boolean isObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(boolean obligatorio) {
        this.obligatorio = obligatorio;
    }

    public List<VariableAtributo> getVariables() {
        return variables;
    }

    public void setVariables(List<VariableAtributo> variables) {
        this.variables = variables;
    }

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public List<CategoriaSeleccionable> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaSeleccionable> categorias) {
        this.categorias = categorias;
    }

    public static final class Builder {
        private final Atributo atributo;

        public Builder() {
            atributo = new Atributo();
        }

        public Builder id(Long id) {
            atributo.setId(id);
            return this;
        }

        public Builder codigo(String codigo) {
            atributo.setCodigo(codigo);
            return this;
        }

        public Builder nombre(String nombre) {
            atributo.setNombre(nombre);
            return this;
        }

        public Builder comentario(String comentario) {
            atributo.setComentario(comentario);
            return this;
        }

        public Builder categorias(List<CategoriaSeleccionable> categorias) {
            atributo.setCategorias(categorias);
            return this;
        }

        public Builder variables(List<VariableAtributo> variables) {
            atributo.setVariables(variables);
            return this;
        }

        public Builder obligatorio(boolean isObligario) {
            atributo.setObligatorio(isObligario);
            return this;
        }

        public Atributo build() {
            return atributo;
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("codigo", codigo)
                .add("nombre", nombre)
                .add("comentario", comentario)
                .add("obligatorio", obligatorio)
                .toString();
    }
}
