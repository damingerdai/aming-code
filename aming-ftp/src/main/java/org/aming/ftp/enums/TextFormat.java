package org.aming.ftp.enums;

import org.aming.ftp.exceptions.FtpException;
import org.aming.ftp.exceptions.FtpExceptionBuilder;

/**
 * @author daming
 * @version 2018/1/2.
 */
public enum TextFormat {

    NON_PRINT_TEXT_FORMAT(4), TELNET_TEXT_FORMAT(5), CARRIAGE_CONTROL_TEXT_FORMAT(6);

    private int type;
    public int getType() {
        return type;
    }

    TextFormat(int type) {
        this.type = type;
    }

    public static TextFormat getFileFormat(int type) throws FtpException {
        for (TextFormat ff : values()) {
            if (ff.type == type) {
                return ff;
            }
        }
        throw FtpExceptionBuilder.buildFtpException("text format type '{0}' is invalid", type);
    }
}
