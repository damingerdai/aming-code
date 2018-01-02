package org.aming.ftp.exceptions;

/**
 * @author daming
 * @version 2018/1/2.
 */
public class FtpException extends Exception {

    public FtpException(String message) {
        super(message);
    }

    public FtpException(String message, Throwable cause) {
        super(message, cause);
    }
}
