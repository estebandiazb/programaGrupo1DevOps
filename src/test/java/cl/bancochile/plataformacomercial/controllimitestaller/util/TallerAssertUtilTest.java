package cl.bancochile.plataformacomercial.controllimitestaller.util;

import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformacomercial.controllimitestaller.enums.MsgErrorEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TallerAssertUtilTest {

    @Test(expected = PlataformaBaseException.class)
    public void assertTrue1() throws Exception {
        TallerAssertUtil.assertTrue("test", true);
        TallerAssertUtil.assertTrue("test", false);
    }

    @Test(expected = PlataformaBaseException.class)
    public void assertTrue2() throws Exception {
        TallerAssertUtil.assertTrue("test","test", true);
        TallerAssertUtil.assertTrue("test", "test", false);
    }


    @Test(expected = PlataformaBaseException.class)
    public void assertTrue3() throws Exception {
        TallerAssertUtil.assertTrue(MsgErrorEnum.MSG_ERROR_PERFIL_USER, true);
        TallerAssertUtil.assertTrue(MsgErrorEnum.MSG_ERROR_ID_MONEDA, false);
    }
}