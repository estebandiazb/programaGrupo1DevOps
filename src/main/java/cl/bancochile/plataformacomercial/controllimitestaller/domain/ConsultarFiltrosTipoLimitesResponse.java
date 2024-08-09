package cl.bancochile.plataformacomercial.controllimitestaller.domain;

import cl.bancochile.plataformacomercial.lib.controllimites.taller.enums.EstadoTipoLimiteEnum;

import java.util.List;

public class ConsultarFiltrosTipoLimitesResponse {

    private List<Filtro> atributos;
    private List<Filtro> familias;
    private List<Filtro> nombres;
    private List<Filtro> subtipos;
    private List<EstadoTipoLimiteEnum> estados;

    public void setFamilias(List<Filtro> familias) {
        this.familias = familias;
    }

    public List<Filtro> getFamilias() {
        return familias;
    }

    public List<Filtro> getSubtipos() {
        return subtipos;
    }

    public void setSubtipos(List<Filtro> subtipos) {
        this.subtipos = subtipos;
    }

    public List<EstadoTipoLimiteEnum> getEstados() {
        return estados;
    }

    public void setEstados(List<EstadoTipoLimiteEnum> estados) {
        this.estados = estados;
    }


    public List<Filtro> getNombres() {
        return nombres;
    }

    public void setNombres(List<Filtro> nombres) {
        this.nombres = nombres;
    }

    public List<Filtro> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Filtro> atributos) {
        this.atributos = atributos;
    }
    public static final class Builder {
        private final ConsultarFiltrosTipoLimitesResponse consultarFiltrosTipoLimitesResponse;

        public Builder() {
            consultarFiltrosTipoLimitesResponse = new ConsultarFiltrosTipoLimitesResponse();
        }

        public Builder familias(List<Filtro> familias) {
            consultarFiltrosTipoLimitesResponse.setFamilias(familias);
            return this;
        }

        public Builder nombres(List<Filtro> nombres) {
            consultarFiltrosTipoLimitesResponse.setNombres(nombres);
            return this;
        }

        public Builder estados(List<EstadoTipoLimiteEnum> estados) {
            consultarFiltrosTipoLimitesResponse.setEstados(estados);
            return this;
        }

        public Builder atributos(List<Filtro> atributos) {
            consultarFiltrosTipoLimitesResponse.setAtributos(atributos);
            return this;
        }

        public Builder subtipos(List<Filtro> subtipos) {
            consultarFiltrosTipoLimitesResponse.setSubtipos(subtipos);
            return this;
        }

        public ConsultarFiltrosTipoLimitesResponse build() {
            return consultarFiltrosTipoLimitesResponse;
        }
    }
}
