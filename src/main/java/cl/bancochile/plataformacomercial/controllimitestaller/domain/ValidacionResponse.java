package cl.bancochile.plataformacomercial.controllimitestaller.domain;

import com.google.common.base.MoreObjects;

import java.util.List;


public class ValidacionResponse {

    private boolean validado;
    private Long idTipoLimite;
    private Long id;
    private List<AtributoValidacion> atributos;

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public List<AtributoValidacion> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<AtributoValidacion> atributos) {
        this.atributos = atributos;
    }

    public long getIdTipoLimite() {
        return idTipoLimite;
    }

    public void setIdTipoLimite(Long idTipoLimite) {
        this.idTipoLimite = idTipoLimite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static final class Builder {
        private final ValidacionResponse validacionResponse;

        public Builder() {
            validacionResponse = new ValidacionResponse();
        }

        public Builder validado(Boolean validado) {
            validacionResponse.setValidado(validado);
            return this;
        }

        public Builder atributos(List<AtributoValidacion> atributos) {
            validacionResponse.setAtributos(atributos);
            return this;
        }

        public Builder idTipoLimite(Long idTipoLimite) {
            validacionResponse.setIdTipoLimite(idTipoLimite);
            return this;
        }

        public Builder id(Long id) {
            validacionResponse.setId(id);
            return this;
        }

        public ValidacionResponse build() {
            return validacionResponse;
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("validado", validado)
                .add("atributos", atributos)
                .toString();
    }
}
