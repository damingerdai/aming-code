package org.aming.core.exceptions;

/**
 * @author daming
 * @version 2017/12/2.
 */
public class AmingException extends RuntimeException {

    private String message;
    private Throwable cause;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    public AmingException(String message) {
        super(message);
    }

    public AmingException(String message, Throwable cause) {
        super(message, cause);
    }
}
