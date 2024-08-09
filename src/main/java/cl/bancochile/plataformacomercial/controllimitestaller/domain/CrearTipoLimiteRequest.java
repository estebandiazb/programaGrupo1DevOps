package cl.bancochile.plataformacomercial.controllimitestaller.domain;

public class CrearTipoLimiteRequest {

    private long idFamiliaLimite;
    private String prefijo;

    public long getIdFamiliaLimite() {
        return idFamiliaLimite;
    }

    public void setIdFamiliaLimite(long idFamiliaLimite) {
        this.idFamiliaLimite = idFamiliaLimite;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }
}
