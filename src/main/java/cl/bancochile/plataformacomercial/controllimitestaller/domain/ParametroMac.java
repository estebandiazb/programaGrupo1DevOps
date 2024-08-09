package cl.bancochile.plataformacomercial.controllimitestaller.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ParametroMac {

    private Long id;
    private String parametro;
    private Long valor;
    private String descripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getValor(){return valor;}

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public static final class Builder {
        private Long id;
        private String parametro;
        private Long valor;
        private String descripcion;

        public Builder() {
            //NOSONAR
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder parametro(String parametro) {
            this.parametro = parametro;
            return this;
        }

        public Builder valor(Long valor) {
            this.valor = valor;
            return this;
        }

        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public ParametroMac build() {
            ParametroMac parametroMac = new ParametroMac();
            parametroMac.setId(id);
            parametroMac.setParametro(parametro);
            parametroMac.setValor(valor);
            parametroMac.setDescripcion(descripcion);
            return parametroMac;
        }
    }
}
