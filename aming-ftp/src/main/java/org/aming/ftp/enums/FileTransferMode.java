package org.aming.ftp.enums;

/**
 * @author daming
 * @version 2018/1/4.
 */
public enum FileTransferMode {
    STREAM_TRANSFER_MODE(10), BLOCK_TRANSFER_MODE(11), COMPRESSED_TRANSFER_MODE(12);

    private int mode;

    public int getMode() {
        return mode;
    }

    FileTransferMode(int mode) {
        this.mode = mode;
    }
}
