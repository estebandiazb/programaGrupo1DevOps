package cl.bancochile.plataformacomercial.controllimitestaller.domain;

import com.google.common.base.MoreObjects;


public class AtributoValidacion {

    private long idAtributo;
    private String codAtributo;
    private boolean validado;
    private String mensaje;

    public long getIdAtributo() {
        return idAtributo;
    }

    public void setIdAtributo(long idAtributo) {
        this.idAtributo = idAtributo;
    }

    public String getCodAtributo() {
        return codAtributo;
    }

    public void setCodAtributo(String codAtributo) {
        this.codAtributo = codAtributo;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public static final class Builder {
        private final AtributoValidacion validacionResponse;

        public Builder() {
            validacionResponse = new AtributoValidacion();
        }

        public Builder validado(boolean validado) {
            validacionResponse.setValidado(validado);
            return this;
        }

        public Builder mensaje(String mensaje) {
            validacionResponse.setMensaje(mensaje);
            return this;
        }

        public Builder idAtributo(long idAtributo) {
            validacionResponse.setIdAtributo(idAtributo);
            return this;
        }

        public Builder codAtributo(String codAtributo) {
            validacionResponse.setCodAtributo(codAtributo);
            return this;
        }

        public AtributoValidacion build() {
            return validacionResponse;
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("validacion", validado)
                .add("mensaje", mensaje)
                .toString();
    }
}
