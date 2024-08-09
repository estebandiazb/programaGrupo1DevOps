package cl.bancochile.plataformacomercial.controllimitestaller.exceptions;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TallerExceptionTest {

    @Test(expected = PlataformaBaseException.class)
    public void errMessage() throws PlataformaBaseException {
        throw new TallerException("test");
    }

    @Test(expected = PlataformaBaseException.class)
    public void errMessageTrowable() throws PlataformaBaseException {
        throw new TallerException("test", new RuntimeException("test"));
    }

    @Test(expected = PlataformaBaseException.class)
    public void errMessageCode() throws PlataformaBaseException {
        throw new TallerException("test", "code");
    }

    @Test(expected = PlataformaBaseException.class)
    public void errMsgErrEnum() throws PlataformaBaseException {
        throw new TallerException(MsgErrorEnum.MSG_ERROR_ID_MONEDA);
    }

    @Test(expected = PlataformaBaseException.class)
    public void errMsgErrEnumThrowable() throws PlataformaBaseException {
        throw new TallerException(MsgErrorEnum.MSG_ERROR_ID_MONEDA, new RuntimeException("test"));
    }

}