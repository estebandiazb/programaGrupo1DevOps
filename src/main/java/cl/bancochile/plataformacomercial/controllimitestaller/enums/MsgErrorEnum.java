package cl.bancochile.plataformacomercial.controllimitestaller.enums;

public enum MsgErrorEnum {

    MSG_ERROR_SET_MONEDA("341000", "Error al guardar moneda banco"),
    MSG_ERROR_DEL_MONEDA("341001", "Error al eliminar moneda banco"),
    MSG_ERROR_UPD_VALOR_MONEDA("341002", "Error al modificar valor moneda banco"),
    MSG_ERROR_EMPTY_MONEDAS("341003", "Listado monedas vacío"),
    MSG_ERROR_PERFIL_USER("341004", "Usuario quien realiza acción no válido"),
    MSG_ERROR_CODIGO_MONEDA("341005", "Código de moneda no válido"),
    MSG_ERROR_DESCRI_MONEDA("34106", "Descripción de moneda no válida"),
    MSG_ERROR_NOMBRE_MONEDA("341007", "Nombre de moneda no válido"),
    MSG_ERROR_CODBCO_MONEDA("34108", "Código banco moneda no válido"),
    MSG_ERROR_SIMBOL_MONEDA("341009", "Símbolo moneda no válido"),
    MSG_ERROR_ID_MONEDA("341010", "Id moneda no válido"),
    MSG_ERROR_VALOR_MONEDA("341011", "Objeto valor moneda no válido"),
    MSG_ERROR_NO_VALOR_DOLAR("341012", "No fue posible obtener valor del dólar"),
    MSG_ERROR_VALOR_OBSERVADO("34013", "Valor observado no válido"),
    MSG_ERROR_INS_FAMLIM("34014", "Error al crear familia límite"),
    MSG_ERROR_DEL_FAMLIM("34015", "Error al eliminar familia límite"),
    MSG_ERROR_NO_FAMLIM("34016", "Contrato no válido para crear familia límite"),
    MSG_ERROR_NOMBRE_FAMLIM("34017", "Nombre familia de límite no debe estar vacío"),
    MSG_ERROR_ID_FAMLIM("34018", "Id familia de límite no válido"),
    MSG_ERROR_EDIT_ITEM_VARIABLE("34019", "Error al editar item variable"),
    MSG_ERROR_CREAR_TIPO_LIMITE("34020", "Error al crear el tipo de límite"),
    MSG_ERROR_CREAR_TIPO_LIMITE_VERSION("34021", "Error al crear versión del tipo de límite"),
    MSG_ERROR_GET_ITEMS_VARIABLES_TL("34022", "Error al obtener las opciones de variables de los atributos del Tipo " +
            "de Límite"),
    MSG_ERROR_GET_ATRIBUTOS_TL("34023", "Error al obtener los atributos del Tipo de Límite"),
    MSG_ERROR_GET_VARIBLES_TL("34024", "Error al obtener las variables de los atributos del Tipo de Límite"),
    MSG_ERROR_GET_INFO_TL("34025", "Error al obtener información para el nuevo Tipo de Límite"),
    MSG_ERROR_YA_EXISTE_PREFIJO("34026", "Ya existe un Tipo de Límite con ese prefijo"),
    MSG_ERROR_GET_CATEGORIAS_ATRIBUTOS_TL("34027", "Error al obtener las categorías de los atributos"),
    MSG_ERROR_CODIGO_NO_CORRESPONDE("34028", "El código de Tipo de Límite no corresponde"),
    MSG_ERROR_ESTADO_NOPERMITIDO("34029", "El estado del Tipo de Límite no permite modificaciones"),
    MSG_ERROR_CAMPOS_INCOMPLETOS("34030", "Campos incompletos. Revise columna Categoría para identificar"),
    MSG_ERROR_PLAZO("34031", "Falta incorporar el atributo Plazo (PL104), de lo contrario revisar configuración " +
            "del atributo Vencimiento Máximo de Curse (VC122)"),
    MSG_ERROR_PLAZO_FMC("34031", "Falta incorporar el atributo Plazo (PL104), de lo contrario revisar configuración " +
            "del atributo Fecha Máx de Curse (VL121)"),
    MSG_ERROR_PLAZO_MAX_OPERACIONES("34033", "Falta incorporar el atributo Plazo Máx Operaciones (PO123), " +
            "de lo contrario revisar configuración del atributo Vencimiento Máximo de Curse (VC122)"),
    MSG_ERROR_MONEDAS_CURSE("34032", "Falta incorporar el atributo Monedas de Curse (PM125), dado que se cuenta " +
            "con atributo Monto Límite (ML103)"),
    MSG_ERROR_CURSES_PARCIALES("34034", "Error en configuración atributo Curses Parciales (CP126). " +
            "De lo contrario revisar configuración Atributo Reutilizable (RE128)"),
    MSG_ERROR_CLEAN_UP("34035", "Error en configuración atributo Reutilizable (RE128), de lo contrario se " +
            "debe eliminar atributo Clean Up (CU117)"),
    MSG_ERROR_ELIMINAR_LIMITE("34036", "Error al eliminar Tipo Límite "),
    MSG_ERROR_ESTADO_NOPERMITIDO_ELIMINAR("34037", "El estado del Tipo de Límite no permite ser eliminado"),
    MSG_ERROR_CAMBIO_ESTADO_TIPO_LIMITE("34038", "Error al actualizar el estado del Tipo Límite"),
    MSG_ERROR_CLONAR_LIMITE("34039", "Error al clonar Tipo de Límite"),
    MSG_ERROR_EXISTE_NOMBRE_FAMLIM("34040", "Error al crear familia limite. El nombre de la familia ya existe"),
    MSG_ERROR_EXISTE_NOMBRE_FAMSUBTIPO("34041", "Error al crear familia subtipo. El nombre de la familia ya existe"),
    MSG_ERROR_MONTO_LIM_CLEAN_UP("34042", "Falta incorporar el atributo Monto (ML103), dado que se cuenta con " +
            "atributo Clean Up (CU117)"),
    MSG_ERROR_CREAR_MOTIVO_NO_RATING("34043", "Error al agregar motivo no rating"),
    MSG_ERROR_ELIMINAR_MOTIVO_NO_RATING ("34044", "Error al eliminar motivo no rating"),
    MSG_ERROR_ACTUALIZAR_MOTIVO_NO_RATING ("34045", "Error al actualizar motivo no rating"),
    MSG_ERROR_GET_PARAMETROS_MAC("34046", "Error al obtener los parametros Mac"),
    MSG_ERROR_UPD_PARAMETROS_MAC("34047", "Error al actualizar el parametro Mac");

    private final String codigo;
    private final String mensaje;

    MsgErrorEnum(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }
}
