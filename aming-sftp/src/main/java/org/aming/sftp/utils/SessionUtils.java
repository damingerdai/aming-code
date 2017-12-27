package org.aming.sftp.utils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.aming.core.utils.Assert;
import org.aming.sftp.pools.SftpSessionPool;
import org.aming.sftp.support.SftpAccessException;

import java.util.Objects;

/**
 * @author daming
 * @version 2017/12/2.
 */
public class SessionUtils {

    public static Session getSession(SftpSessionPool pool) throws SftpAccessException {
        Assert.notNull(pool, "sftp session pool is required");

        try {
            return pool.borrowObject();
        } catch (Exception ex) {
            throw SftpExceptionBuilder.buildSftpAccessException("fail to get a session", ex);
        }
    }

    public static void releaseSession(ChannelSftp channelSftp, Session session, SftpSessionPool pool) {
        try {
            releaseChannel(channelSftp);
            if(Objects.nonNull(session)) {
                pool.returnObject(session);
            }
        } catch (Exception ex) {
            throw SftpExceptionBuilder.buildSftpAccessException("fail to return session", ex);
        }
    }

    public static ChannelSftp openChannel(Session session) throws SftpAccessException {
        if(Objects.isNull(session)) {
            throw SftpExceptionBuilder.buildSftpAccessException("session is required");
        }
        if(!session.isConnected()) {
            throw SftpExceptionBuilder.buildSftpAccessException("fail to get session from sftp server");
        }
        try {
            Channel channel = session.openChannel("sftp");
            channel.connect();

            return (ChannelSftp)channel;
        } catch (JSchException e) {
            throw SftpExceptionBuilder.buildSftpAccessException("fail to get channel from sftp server");
        }
    }

    public static void releaseChannel(ChannelSftp channel) {
        if(Objects.nonNull(channel)) {
            channel.disconnect();
        }
    }
}
