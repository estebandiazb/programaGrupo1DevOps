package cl.bancochile.plataformacomercial.controllimitestaller.domain;

public class Filtro {

    private Long id;
    private String nombre;
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static final class Builder {
        private final Filtro filtro;

        public Builder() {
            filtro = new Filtro();
        }

        public Builder nombre(String nombre) {
            filtro.setNombre(nombre);
            return this;
        }

        public Builder id(Long id) {
            filtro.setId(id);
            return this;
        }

        public Builder codigo(String codigo) {
            filtro.setCodigo(codigo);
            return this;
        }

        public Filtro build() {
            return filtro;
        }
    }
}
