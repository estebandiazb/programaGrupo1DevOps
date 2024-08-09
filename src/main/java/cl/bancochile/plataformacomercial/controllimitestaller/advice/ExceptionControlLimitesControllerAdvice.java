package cl.bancochile.plataformacomercial.controllimitestaller.advice;

import cl.bancochile.bchdao.SimpleDaoException;
import cl.bancochile.plataformabase.error.ErrorSeverity;
import cl.bancochile.plataformabase.error.PlataformaBaseException;
import cl.bancochile.plataformabase.error.advice.ErrorInfo;
import cl.bancochile.plataformabase.error.advice.ExceptionControllerAdvice;
import cl.bancochile.traductor.dto.MessageCatalogRequestDecorator;
import cl.bancochile.traductor.dto.MessageResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@ControllerAdvice(annotations = RestController.class)
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionControlLimitesControllerAdvice extends ExceptionControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            cl.bancochile.plataformacomercial.controllimitestaller.
                    advice.ExceptionControlLimitesControllerAdvice.class);
    private static String ERROR_MSG = "Error: ";

    @ExceptionHandler(value = SimpleDaoException.class)
    @ResponseBody
    public ResponseEntity<ErrorInfo> handleGlobalExceptionRequest(HttpServletRequest req,
                                                                  SimpleDaoException ex) {
        LOGGER.error(ERROR_MSG, avoidImproperOutputNeutralization4Log(ex));
        PlataformaBaseException plataformaBaseException = new PlataformaBaseException(ex.getMessage(), ex, "400001");
        ErrorInfo errorInfo = new ErrorInfo(req.getRequestURL().toString(), plataformaBaseException);
        fillerErrorInfo(errorInfo, plataformaBaseException);

        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private void fillerErrorInfo(ErrorInfo errorInfo, PlataformaBaseException plataformaBaseException) {
        MessageCatalogRequestDecorator requestDecorator = new MessageCatalogRequestDecorator.Builder()
                .codigo(plataformaBaseException.getErrorCode())
                .parametros(plataformaBaseException.getErrorParams())
                .build();
        MessageResponse response = traductorService.getMessage(requestDecorator.getMessageCatalogRequest());
        errorInfo.setCatalogMessage(response.getErrorMessage());
        errorInfo.setErrorSeverity(ErrorSeverity.valueOf(response.getSeverity().toUpperCase()));
        String stackTrace = isFlagStackTraceEnabled() ? ExceptionUtils.getStackTrace(plataformaBaseException)
                : StringUtils.EMPTY;
        errorInfo.setStackTrace(stackTrace);
    }

    private static Exception avoidImproperOutputNeutralization4Log(Exception ex) {
        return new Exception(ex);
    }

    private boolean isFlagStackTraceEnabled() {
        String stackTraceEnabled = stackTraceEnableMessageSource.getMessage("stacktrace.enabled", null,
                Locale.forLanguageTag("es_cl"));
        return Boolean.valueOf(stackTraceEnabled);
    }
}
