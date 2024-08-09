package cl.bancochile.plataformacomercial.controllimitestaller.exceptions;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;

public class TallerException extends PlataformaBaseException {
    private static final long serialVersionUID = 12983212453412L;

    public TallerException(String message) {
        super(message, new RuntimeException(message), "0");
    }

    public TallerException(String message, Throwable throwable) {
        super(message, throwable, "0");
    }

    public TallerException(String message, String errorCode) {
        super(message, new RuntimeException(message), errorCode);
    }

    public TallerException(MsgErrorEnum err) {
        super(err.getMensaje(), new RuntimeException(err.getMensaje()), err.getCodigo());
    }

    public TallerException(MsgErrorEnum err, Throwable throwable) {
        super(err.getMensaje(), throwable, err.getCodigo());
    }
}
