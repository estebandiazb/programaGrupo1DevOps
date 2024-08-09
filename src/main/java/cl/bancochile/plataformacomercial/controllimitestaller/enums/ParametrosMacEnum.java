package cl.bancochile.plataformacomercial.controllimitestaller.enums;

public enum ParametrosMacEnum {
    DIAS_RATING(1L, "DIAS_RATING", "Rating", "Editar", "PARAM_MAC");

    final private Long id;
    final private String parametro;
    final private String descripcion;
    final private String accion;
    final private String funcionalidad;

    ParametrosMacEnum(Long id, String parametro, String descripcion, String accion, String funcionalidad){
        this.id = id;
        this.parametro = parametro;
        this.descripcion = descripcion;
        this.accion = accion;
        this.funcionalidad = funcionalidad;
    }

    public Long getId() {
        return id;
    }

    public String getParametro() {
        return parametro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getAccion() {
        return accion;
    }

    public String getFuncionalidad() {
        return funcionalidad;
    }
}
