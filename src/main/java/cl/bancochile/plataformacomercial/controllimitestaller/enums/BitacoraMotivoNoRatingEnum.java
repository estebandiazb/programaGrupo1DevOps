package cl.bancochile.plataformacomercial.controllimitestaller.enums;

public enum BitacoraMotivoNoRatingEnum {
    CREAR("Crear", "MOTIVO_NO_RATING"),
    EDITAR("Editar", "MOTIVO_NO_RATING"),
    ELIMINAR("Eliminar", "MOTIVO_NO_RATING");

    final private String accion;
    final private String funcionalidad;

    BitacoraMotivoNoRatingEnum (String accion, String sistema){
        this.accion = accion;
        this.funcionalidad = sistema;
    }

    public String getAccion() {
        return accion;
    }

    public String getFuncionalidad() {
        return funcionalidad;
    }
}
