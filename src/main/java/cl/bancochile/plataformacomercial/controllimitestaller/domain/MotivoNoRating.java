package cl.bancochile.plataformacomercial.controllimitestaller.domain;

public class MotivoNoRating {

    private Long id;
    private int orden;
    private String descripcion;
    private String fechaCreacion;
    private String fechaActualizacion;
    private String usuarioCreador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(String usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public static final class Builder {
        private Long id;
        private int orden;
        private String descripcion;
        private String fechaCreacion;
        private String fechaActualizacion;
        private String usuarioCreador;

        public Builder() {
            //NOSONAR
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder orden(int orden) {
            this.orden = orden;
            return this;
        }

        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder fechaCreacion(String fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
            return this;
        }

        public Builder fechaActualizacion(String fechaActualizacion) {
            this.fechaActualizacion = fechaActualizacion;
            return this;
        }

        public Builder usuarioCreador(String usuarioCreador) {
            this.usuarioCreador = usuarioCreador;
            return this;
        }

        public MotivoNoRating build() {
            MotivoNoRating motivoNoRating = new MotivoNoRating();
            motivoNoRating.setId(id);
            motivoNoRating.setOrden(orden);
            motivoNoRating.setDescripcion(descripcion);
            motivoNoRating.setFechaCreacion(fechaCreacion);
            motivoNoRating.setFechaActualizacion(fechaActualizacion);
            motivoNoRating.setUsuarioCreador(usuarioCreador);
            return motivoNoRating;
        }
    }
}
