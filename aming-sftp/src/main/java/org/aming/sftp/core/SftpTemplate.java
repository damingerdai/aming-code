package org.aming.sftp.core;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;
import org.aming.core.utils.Assert;
import org.aming.sftp.support.SftpAccessException;
import org.aming.sftp.support.SftpAccessor;
import org.aming.sftp.support.SftpOperations;
import org.aming.sftp.utils.SessionUtils;
import org.aming.sftp.utils.SftpExceptionBuilder;

import java.io.File;

/**
 * @author daming
 * @version 2017/12/2.
 */
public class SftpTemplate extends SftpAccessor implements SftpOperations{

    @Override
    public void upload(String remotePath, File file) throws SftpAccessException {
        Assert.notNull(remotePath, "'remotePath' is required");
        Assert.notNull(file, "'file' is required");

        Session session = null;
        ChannelSftp channel = null;
        try {
            session = getSftpClientPool().borrowObject();
            
            channel = SessionUtils.openChannel(session);

            channel.put(file.getAbsolutePath(), remotePath);
        } catch (SftpAccessException ex) {
            SessionUtils.releaseSession(channel, session, getSftpClientPool());
            throw ex;
        } catch (Exception ex) {
            SessionUtils.releaseSession(channel, session, getSftpClientPool());
            throw SftpExceptionBuilder.buildSftpAccessException("fail to upload file to sftp server");
        } finally {
            SessionUtils.releaseSession(channel, session, getSftpClientPool());
        }

    }

    @Override
    public void download(String remotePath, String fileName, String localPath) throws SftpAccessException {
        Assert.notNull(remotePath, "'remotePath' is required");
        Assert.notNull(fileName, "'fileName' is required");

        Session session = null;
        ChannelSftp channel = null;
        try {
            session = getSftpClientPool().borrowObject();

            channel = SessionUtils.openChannel(session);

            channel.get(remotePath);
        } catch (SftpAccessException ex) {
            SessionUtils.releaseSession(channel, session, getSftpClientPool());
            throw ex;
        } catch (Exception ex) {
            SessionUtils.releaseSession(channel, session, getSftpClientPool());
            throw SftpExceptionBuilder.buildSftpAccessException("fail to download file form sftp server");
        } finally {
            SessionUtils.releaseSession(channel, session, getSftpClientPool());
        }
    }
}
