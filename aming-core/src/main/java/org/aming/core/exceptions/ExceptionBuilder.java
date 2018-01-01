package org.aming.core.exceptions;

import org.aming.core.log.AmingLogger;
import org.aming.core.log.LoggerManager;

import java.text.MessageFormat;

/**
 * @author daming
 * @version 2017/12/2.
 */
public class ExceptionBuilder {

    protected static final AmingLogger logger = LoggerManager.getLogger("error");

    public static AmingException buildAmingException(String message) {
        AmingException result = new AmingException(message);
        log(result);
        return result;
    }

    public static AmingException buildAmingException(String format, Object...params) {

        return new AmingException(MessageFormat.format(format, params));
    }

    public static AmingException buildAmingException(String message, Throwable cause) {
        return new AmingException(message, cause);
    }

    public static AmingException buildAmingException(String format, Throwable cause, Object... params) {
        return new AmingException(
                MessageFormat.format(format,params),
                cause
        );
    }

    public static RuntimeException buildRuntimeException(String message) {
        return new RuntimeException(message);
    }

    public static RuntimeException buildRuntimeException(String format, Object...params) {
        return new RuntimeException(MessageFormat.format(format, params));
    }

    protected static void log(Throwable cause) {
        logger.error("error message : {}, error cause : {}", cause.getMessage(), cause.getCause());
    }
}
