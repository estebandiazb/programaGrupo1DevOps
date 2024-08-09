package cl.bancochile.plataformacomercial.controllimitestaller.domain;

public class BitacoraMotivoNoRatingObject {

    private int orden;
    private String descripcion;

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

    public static final class Builder {
        private int orden;
        private String descripcion;

        public Builder() {
            //NOSONAR
        }

        public Builder orden(int orden) {
            this.orden = orden;
            return this;
        }

        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public BitacoraMotivoNoRatingObject build() {
            BitacoraMotivoNoRatingObject bitacoraMotivoNoRatingObject = new BitacoraMotivoNoRatingObject();
            bitacoraMotivoNoRatingObject.setOrden(orden);
            bitacoraMotivoNoRatingObject.setDescripcion(descripcion);
            return bitacoraMotivoNoRatingObject;
        }
    }
}
