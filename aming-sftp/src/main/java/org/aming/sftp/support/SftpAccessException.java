package org.aming.sftp.support;

import org.aming.core.exceptions.AmingException;

/**
 * @author daming
 * @version 2017/12/2.
 */
public class SftpAccessException extends AmingException {



    public SftpAccessException(String message) {
        super(message);
    }

    public SftpAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
