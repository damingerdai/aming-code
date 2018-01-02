package org.aming.ftp.exceptions;

/**
 * @author daming
 * @version 2018/1/2.
 */
public class FtpExceptionBuilder {

    public static FtpException buildFtpException(String message, Throwable cause) {
        return new FtpException(message, cause);
    }

    public static FtpException buildFtpException(String message) {
        return new FtpException(message);
    }
}
