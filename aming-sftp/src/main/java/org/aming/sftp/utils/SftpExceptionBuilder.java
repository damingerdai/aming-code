package org.aming.sftp.utils;

import org.aming.core.exceptions.ExceptionBuilder;
import org.aming.core.log.AmingLogger;
import org.aming.core.log.LoggerManager;
import org.aming.sftp.support.SftpAccessException;
import org.aming.sftp.support.SftpException;

import java.text.MessageFormat;

/**
 * @author daming
 * @version 2017/12/10.
 */
public class SftpExceptionBuilder extends ExceptionBuilder {

    private static final AmingLogger logger = LoggerManager.getLogger("error.sftp.logger");

    public static SftpException buildSftpException(String message) {
        logger.error(message);
        return new SftpException(message);
    }

    public static SftpException buildSftpException(String format, Object...params) {
        String message = MessageFormat.format(format, params);
        logger.error(message);
        return new SftpException(message);
    }

    public static SftpException buildSftpException(String message, Throwable cause) {
        logger.error(message);
        return new SftpException(message, cause);
    }

    public static SftpException buildSftpException(String format, Throwable cause, Object...params) {
        String message = MessageFormat.format(format, params);
        logger.error(message, cause);
        return new SftpException(message, cause);
    }

    public static SftpAccessException buildSftpAccessException(String message) {
        logger.error(message);
        return new SftpAccessException(message);
    }

    public static SftpAccessException buildSftpAccessException(String message, Throwable cause) {
        logger.error(message, cause);
        return new SftpAccessException(message, cause);
    }

}
