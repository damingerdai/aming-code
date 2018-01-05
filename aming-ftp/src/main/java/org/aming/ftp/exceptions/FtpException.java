package org.aming.ftp.exceptions;

/**
 * @author daming
 * @version 2018/1/2.
 */
public class FtpException extends Exception {
 
	private static final long serialVersionUID = 4345643622854258621L;

	public FtpException(String message) {
        super(message);
    }

    public FtpException(String message, Throwable cause) {
        super(message, cause);
    }
}
