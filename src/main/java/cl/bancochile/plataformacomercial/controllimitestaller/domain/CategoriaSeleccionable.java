package cl.bancochile.plataformacomercial.controllimitestaller.domain;

import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.CategoriaAtributoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CategoriaSeleccionable {
    @JsonIgnore
    private Long idAtributo;
    private CategoriaAtributoEnum categoria;
    private boolean seleccionado;

    public Long getIdAtributo() {
        return idAtributo;
    }

    public void setIdAtributo(Long idAtributo) {
        this.idAtributo = idAtributo;
    }

    public CategoriaAtributoEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaAtributoEnum categoria) {
        this.categoria = categoria;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public static final class Builder {
        private final CategoriaSeleccionable categoriaSeleccionable;

        public Builder() {
            categoriaSeleccionable = new CategoriaSeleccionable();
        }

        public CategoriaSeleccionable.Builder idAtributo(Long idAtributo) {
            categoriaSeleccionable.setIdAtributo(idAtributo);
            return this;
        }

        public CategoriaSeleccionable.Builder categoria(CategoriaAtributoEnum categoria) {
            categoriaSeleccionable.setCategoria(categoria);
            return this;
        }

        public CategoriaSeleccionable.Builder seleccionado(boolean isSeleccionado) {
            categoriaSeleccionable.setSeleccionado(isSeleccionado);
            return this;
        }

        public CategoriaSeleccionable build() {
            return categoriaSeleccionable;
        }
    }
}
