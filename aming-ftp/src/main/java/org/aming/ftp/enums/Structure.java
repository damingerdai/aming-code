package org.aming.ftp.enums;

import org.aming.ftp.exceptions.FtpException;
import org.aming.ftp.exceptions.FtpExceptionBuilder;

/**
 * @author daming
 * @version 2018/1/4.
 */
public enum Structure {
    FILE_STRUCTURE(7), RECORD_STRUCTURE(8), PAGE_STRUCTURE(9);

    private int type;

    public int getType() {
        return type;
    }

    Structure(int type) {
        this.type = type;
    }

    public static Structure getStructure(int type) throws FtpException {
        for (Structure st : values()) {
            if (st.type == type) {
                return st;
            }
        }
        throw FtpExceptionBuilder.buildFtpException("structure type '{0}' is invalid", type);
    }
}
