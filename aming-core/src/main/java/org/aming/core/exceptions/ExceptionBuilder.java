package org.aming.core.exceptions;

import java.text.MessageFormat;

/**
 * @author daming
 * @version 2017/12/2.
 */
public class ExceptionBuilder {

    public static AmingException buildAmingException(String message) {
        return new AmingException(message);
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
}
