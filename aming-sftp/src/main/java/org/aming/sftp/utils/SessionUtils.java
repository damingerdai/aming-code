package org.aming.sftp.utils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.aming.sftp.support.SftpAccessException;

/**
 * @author daming
 * @version 2017/12/2.
 */
public class SessionUtils {

    public Channel openChannel(Session session) throws SftpAccessException {
        if(session != null) {
            throw new SftpAccessException("session is required");
        }
        if(!session.isConnected()) {
            throw new SftpAccessException("fail to get session from sftp server");
        }
        try {
            Channel channel = session.openChannel("sftp");
            channel.connect();
            return channel;
        } catch (JSchException e) {
            throw new SftpAccessException("fail to get channel from sftp server");
        }
    }

    public void releaseChannel(Session session, Channel channel) throws SftpAccessException {
        if(channel != null) {
            channel.disconnect();
            // channel.getSession()
        }
    }
}
