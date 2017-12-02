package org.aming.sftp.support;

import org.aming.core.exceptions.AmingException;

/**
 * @author daming
 * @version 2017/12/2.
 */
public class SftpException extends AmingException {



    public SftpException(String message) {
        super(message);
    }

    public SftpException(String message, Throwable cause) {
        super(message, cause);
    }
}
