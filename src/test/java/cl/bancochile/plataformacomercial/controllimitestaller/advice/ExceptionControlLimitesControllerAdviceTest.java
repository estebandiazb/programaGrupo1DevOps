package cl.bancochile.plataformacomercial.controllimitestaller.advice;

import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.plataformabase.error.ErrorSeverity;
import cl.bancochile.plataformabase.error.advice.ErrorInfo;
import cl.bancochile.traductor.dto.MessageCatalogRequest;
import cl.bancochile.traductor.dto.MessageResponse;
import cl.bancochile.traductor.services.Translator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.Locale;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExceptionControlLimitesControllerAdviceTest {

    private ExceptionControlLimitesControllerAdvice exceptionCdlControllerAdvice;
    private Translator traductorService;
    private MessageSource stackTraceEnablerMessageSource;

    @Before
    public void setUp() throws Exception {
        traductorService = mock(Translator.class);
        stackTraceEnablerMessageSource = mock(MessageSource.class);
        exceptionCdlControllerAdvice = new ExceptionControlLimitesControllerAdvice();

        MessageResponse messageResponse = mock(MessageResponse.class);
        when(messageResponse.getErrorCode()).thenReturn("0");
        when(messageResponse.getErrorMessage()).thenReturn("mensaje");
        when(messageResponse.getSeverity()).thenReturn(ErrorSeverity.ERROR.toString());
        when(traductorService.getMessage(any(MessageCatalogRequest.class))).thenReturn(messageResponse);


        setFieldAccessible(exceptionCdlControllerAdvice, traductorService, "traductorService");
        setFieldAccessible(exceptionCdlControllerAdvice, stackTraceEnablerMessageSource, "stackTraceEnableMessageSource");
    }

    @Test
    public void testHandleGlobalExceptionRequest() throws Exception {

        when(stackTraceEnablerMessageSource.getMessage(anyString(), any(String[].class),any(Locale.class)))
                .thenReturn("true");

        HttpServletRequest req = mock(HttpServletRequest.class);
        when(req.getRequestURL()).thenReturn(new StringBuffer("URL"));
        SimpleDaoException simpleDaoException = new SimpleDaoException("mensaje", "detalle", 1);

        ResponseEntity<ErrorInfo> responseEntity =
                exceptionCdlControllerAdvice.handleGlobalExceptionRequest(req, simpleDaoException);

        Assert.assertEquals("400001", responseEntity.getBody().getErrorCode());
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

    @Test
    public void testHandleGlobalExceptionRequestTraceOff() throws Exception {

        when(stackTraceEnablerMessageSource.getMessage(anyString(), any(String[].class),any(Locale.class)))
                .thenReturn("false");

        HttpServletRequest req = mock(HttpServletRequest.class);
        when(req.getRequestURL()).thenReturn(new StringBuffer("URL"));
        SimpleDaoException simpleDaoException = new SimpleDaoException("mensaje", "detalle", 1);

        ResponseEntity<ErrorInfo> responseEntity =
                exceptionCdlControllerAdvice.handleGlobalExceptionRequest(req, simpleDaoException);

        Assert.assertEquals("", responseEntity.getBody().getStackTrace());
        Assert.assertEquals("400001", responseEntity.getBody().getErrorCode());
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());

    }

    public static void setFieldAccessible(Object exceptionAdvice, Object service, String field) throws Exception {
        Field f1 = exceptionAdvice.getClass().getSuperclass().getDeclaredField(field);
        boolean isAccessible = f1.isAccessible();
        f1.setAccessible(true);
        f1.set(exceptionAdvice, service);
        f1.setAccessible(isAccessible);
    }

}
