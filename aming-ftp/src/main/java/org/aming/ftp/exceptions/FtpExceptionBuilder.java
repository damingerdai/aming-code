package org.aming.ftp.exceptions;

import java.text.MessageFormat;

/**
 * @author daming
 * @version 2018/1/2.
 */
public class FtpExceptionBuilder {

    public static FtpException buildFtpException(String message, Throwable cause) {
        return new FtpException(message, cause);
    }

    public static FtpException buildFtpException(String pattern, Object...arguments) {
        return new FtpException(MessageFormat.format(pattern, arguments));
    }

    public static FtpException buildFtpException(String message) {
        return new FtpException(message);
    }
}
