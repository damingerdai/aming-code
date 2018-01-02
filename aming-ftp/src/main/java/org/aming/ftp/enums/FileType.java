package org.aming.ftp.enums;

/**
 * @author daming
 * @version 2018/1/2.
 */
public enum FileType {

    ASCII_FILE_TYPE(0),EBCDIC_FILE_TYPE(1),BINARY_FILE_TYPE(3),LOCAL_FILE_TYPE(4);


    private int type;
    public int getType() {
        return type;
    }

    FileType(int type) {
        this.type = type;
    }

}
