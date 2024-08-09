package cl.bancochile.plataformacomercial.controllimitestaller.domain;

import java.math.BigDecimal;

public class ValorMonedaBanco {

    private long id;
    private long idMoneda;
    private String fecha;
    private String fechaCreacion;
    private String fechaModificacion;
    private String usuarioCreacion;
    private String usuarioModificacion;
    private BigDecimal paridadReuters;
    private BigDecimal paridadBancoCentral;
    private BigDecimal valorObservado;
    private String motivoModificacion;
    private String origenData;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(long idMoneda) {
        this.idMoneda = idMoneda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public BigDecimal getParidadReuters() {
        return paridadReuters;
    }

    public void setParidadReuters(BigDecimal paridadReuters) {
        this.paridadReuters = paridadReuters;
    }

    public BigDecimal getParidadBancoCentral() {
        return paridadBancoCentral;
    }

    public void setParidadBancoCentral(BigDecimal paridadBancoCentral) {
        this.paridadBancoCentral = paridadBancoCentral;
    }

    public BigDecimal getValorObservado() {
        return valorObservado;
    }

    public void setValorObservado(BigDecimal valorObservado) {
        this.valorObservado = valorObservado;
    }

    public String getMotivoModificacion() {
        return motivoModificacion;
    }

    public void setMotivoModificacion(String motivoModificacion) {
        this.motivoModificacion = motivoModificacion;
    }

    public String getOrigenData() {
        return origenData;
    }

    public void setOrigenData(String origenData) {
        this.origenData = origenData;
    }

    public static final class Builder {
        private final ValorMonedaBanco valorMonedaBanco;

        public Builder() {
            valorMonedaBanco = new ValorMonedaBanco();
        }

        public Builder id(long id) {
            valorMonedaBanco.setId(id);
            return this;
        }

        public Builder idMoneda(long idMoneda) {
            valorMonedaBanco.setIdMoneda(idMoneda);
            return this;
        }

        public Builder fecha(String fecha) {
            valorMonedaBanco.setFecha(fecha);
            return this;
        }

        public Builder fechaCreacion(String fechaCreacion) {
            valorMonedaBanco.setFechaCreacion(fechaCreacion);
            return this;
        }

        public Builder fechaModificacion(String fechaModificacion) {
            valorMonedaBanco.setFechaModificacion(fechaModificacion);
            return this;
        }

        public Builder usuarioCreacion(String usuarioCreacion) {
            valorMonedaBanco.setUsuarioCreacion(usuarioCreacion);
            return this;
        }

        public Builder usuarioModificacion(String usuarioModificacion) {
            valorMonedaBanco.setUsuarioModificacion(usuarioModificacion);
            return this;
        }

        public Builder paridadReuters(BigDecimal paridadReuters) {
            valorMonedaBanco.setParidadReuters(paridadReuters);
            return this;
        }

        public Builder paridadBancoCentral(BigDecimal paridadBancoCentral) {
            valorMonedaBanco.setParidadBancoCentral(paridadBancoCentral);
            return this;
        }

        public Builder valorObservado(BigDecimal valorObservado) {
            valorMonedaBanco.setValorObservado(valorObservado);
            return this;
        }

        public Builder motivoModificacion(String motivoModificacion) {
            valorMonedaBanco.setMotivoModificacion(motivoModificacion);
            return this;
        }

        public Builder origenData(String origenData) {
            valorMonedaBanco.setOrigenData(origenData);
            return this;
        }

        public ValorMonedaBanco build() {
            return valorMonedaBanco;
        }
    }
}
