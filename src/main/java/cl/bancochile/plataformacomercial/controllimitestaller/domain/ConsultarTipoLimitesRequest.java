package cl.bancochile.plataformacomercial.controllimitestaller.domain;

import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;

import java.util.List;

public class ConsultarTipoLimitesRequest {

    private String palabrasClaves;
    private List<Filtro> familias;
    private List<Filtro> nombres;
    private List<EstadoTipoLimiteEnum> estados;
    private List<Filtro> atributos;
    private List<Filtro> subtipos;
    private String codigo;

    public String getPalabrasClaves() {
        return palabrasClaves;
    }

    public void setPalabrasClaves(String palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }

    public List<Filtro> getFamilias() {
        return familias;
    }

    public void setFamilias(List<Filtro> familias) {
        this.familias = familias;
    }

    public List<Filtro> getNombres() {
        return nombres;
    }

    public void setNombres(List<Filtro> nombres) {
        this.nombres = nombres;
    }

    public List<EstadoTipoLimiteEnum> getEstados() {
        return estados;
    }

    public void setEstados(List<EstadoTipoLimiteEnum> estados) {
        this.estados = estados;
    }

    public List<Filtro> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Filtro> atributos) {
        this.atributos = atributos;
    }

    public List<Filtro> getSubtipos() {
        return subtipos;
    }

    public void setSubtipos(List<Filtro> subtipos) {
        this.subtipos = subtipos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public static final class Builder {
        private final ConsultarTipoLimitesRequest consultarTipoLimitesRequest;

        public Builder() {
            consultarTipoLimitesRequest = new ConsultarTipoLimitesRequest();
        }

        public Builder palabrasClaves(String palabrasClaves) {
            consultarTipoLimitesRequest.setPalabrasClaves(palabrasClaves);
            return this;
        }

        public Builder familias(List<Filtro> familias) {
            consultarTipoLimitesRequest.setFamilias(familias);
            return this;
        }

        public Builder nombres(List<Filtro> nombres) {
            consultarTipoLimitesRequest.setNombres(nombres);
            return this;
        }

        public Builder estados(List<EstadoTipoLimiteEnum> estados) {
            consultarTipoLimitesRequest.setEstados(estados);
            return this;
        }

        public Builder atributos(List<Filtro> atributos) {
            consultarTipoLimitesRequest.setAtributos(atributos);
            return this;
        }

        public Builder subtipos(List<Filtro> subtipos) {
            consultarTipoLimitesRequest.setSubtipos(subtipos);
            return this;
        }

        public Builder codigo(String codigo) {
            consultarTipoLimitesRequest.setCodigo(codigo);
            return this;
        }

        public ConsultarTipoLimitesRequest build() {
            return consultarTipoLimitesRequest;
        }
    }
}
