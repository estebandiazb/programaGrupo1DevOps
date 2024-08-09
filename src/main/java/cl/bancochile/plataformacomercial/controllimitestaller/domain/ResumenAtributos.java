package cl.bancochile.plataformacomercial.controllimitestaller.domain;

public class ResumenAtributos {

    private long normativos;
    private long basicos;
    private long avanzados;
    private long sinCategoria;

    public long getNormativos() {
        return normativos;
    }

    public void setNormativos(long normativos) {
        this.normativos = normativos;
    }

    public long getBasicos() {
        return basicos;
    }

    public void setBasicos(long basicos) {
        this.basicos = basicos;
    }

    public long getAvanzados() {
        return avanzados;
    }

    public void setAvanzados(long avanzados) {
        this.avanzados = avanzados;
    }

    public long getSinCategoria() {
        return sinCategoria;
    }

    public void setSinCategoria(long sinCategoria) {
        this.sinCategoria = sinCategoria;
    }

    public static final class Builder {
        private final ResumenAtributos resumenAtributos;

        public Builder() {
            resumenAtributos = new ResumenAtributos();
        }

        public Builder normativos(long normativos) {
            resumenAtributos.setNormativos(normativos);
            return this;
        }

        public Builder basicos(long basicos) {
            resumenAtributos.setBasicos(basicos);
            return this;
        }

        public Builder avanzados(long avanzados) {
            resumenAtributos.setAvanzados(avanzados);
            return this;
        }

        public Builder sinCategoria(long sinCategoria) {
            resumenAtributos.setSinCategoria(sinCategoria);
            return this;
        }

        public ResumenAtributos build() {
            return resumenAtributos;
        }
    }
}
