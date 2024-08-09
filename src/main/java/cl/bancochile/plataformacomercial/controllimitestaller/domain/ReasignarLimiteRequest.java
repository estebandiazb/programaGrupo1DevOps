package cl.bancochile.plataformacomercial.controllimitestaller.domain;

public class ReasignarLimiteRequest {

    private long idTipoLimite;
    private long idFamiliaLimite;

    public long getIdTipoLimite() {
        return idTipoLimite;
    }

    public void setIdTipoLimite(long idTipoLimite) {
        this.idTipoLimite = idTipoLimite;
    }

    public long getIdFamiliaLimite() {
        return idFamiliaLimite;
    }

    public void setIdFamiliaLimite(long idFamiliaLimite) {
        this.idFamiliaLimite = idFamiliaLimite;
    }
}
