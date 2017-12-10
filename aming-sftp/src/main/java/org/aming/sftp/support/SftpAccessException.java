package org.aming.sftp.support;

/**
 * @author daming
 * @version 2017/12/2.
 */
public class SftpAccessException extends SftpException {

    public SftpAccessException(String message) {
        super(message);
    }

    public SftpAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
