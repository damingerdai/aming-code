package org.aming.sftp.support;

import java.io.File;

/**
 * @author daming
 * @version 2017/12/2.
 */
public interface SftpOperations {

    void upload(String remotePath, File file) throws SftpAccessException;

    void download(String remotePath, String fileName) throws SftpAccessException;
}
