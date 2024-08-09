package cl.bancochile.plataformacomercial.controllimitestaller.domain;

import java.util.List;

public class ConsultarTipoLimitesResponse {

    private List<TipoLimite> tipoLimites;

    public List<TipoLimite> getTipoLimites() {
        return tipoLimites;
    }

    public void setTipoLimites(List<TipoLimite> tipoLimites) {
        this.tipoLimites = tipoLimites;
    }


    public static final class Builder {
        private final ConsultarTipoLimitesResponse consultarTipoLimitesResponse;

        public Builder() {
            consultarTipoLimitesResponse = new ConsultarTipoLimitesResponse();
        }

        public Builder tipoLimites(List<TipoLimite> tipoLimites) {
            consultarTipoLimitesResponse.setTipoLimites(tipoLimites);
            return this;
        }

        public ConsultarTipoLimitesResponse build() {
            return consultarTipoLimitesResponse;
        }
    }
}
