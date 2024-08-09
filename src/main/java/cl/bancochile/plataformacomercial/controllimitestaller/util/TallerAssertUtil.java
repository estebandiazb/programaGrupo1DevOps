package cl.bancochile.plataformacomercial.controllimitestaller.util;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import cl.bancochile.plataformacomercial.controllimitestaller.exceptions.TallerException;

public class TallerAssertUtil {

    private TallerAssertUtil() {
        //SONAR
    }

    public static void assertTrue(String message, boolean condition)
            throws PlataformaBaseException {
        if (!condition) {
            throw new TallerException(message);
        }
    }

    public static void assertTrue(String message, String errorCode, boolean condition)
            throws PlataformaBaseException {
        if (!condition) {
            throw new TallerException(message, errorCode);
        }
    }

    public static void assertTrue(MsgErrorEnum error, boolean condition)
            throws PlataformaBaseException {
        if (!condition) {
            throw new TallerException(error);
        }
    }

}
