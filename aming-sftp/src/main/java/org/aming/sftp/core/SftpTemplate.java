package org.aming.sftp.core;

import org.aming.sftp.support.SftpAccessException;
import org.aming.sftp.support.SftpAccessor;
import org.aming.sftp.support.SftpOperations;

import java.io.File;

/**
 * @author daming
 * @version 2017/12/2.
 */
public class SftpTemplate extends SftpAccessor implements SftpOperations{

    public void upload(String remotePath, File file) throws SftpAccessException {

    }

    public void download(String remotePath, String fileName) throws SftpAccessException {

    }
}
