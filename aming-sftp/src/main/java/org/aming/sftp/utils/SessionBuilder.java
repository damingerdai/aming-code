package org.aming.sftp.utils;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.aming.sftp.support.SftpException;

import java.nio.file.Path;
import java.util.Properties;

/**
 * @author daming
 * @version 2017/12/31.
 */
public class SessionBuilder {

    public static Session newSessionWithPassword(String host, int port, String username, String password) throws SftpException {
        try {
            Session session = newSession(username, host, port);
            session.setPassword(password);
            return session;
        } catch (JSchException ex) {
            throw SftpExceptionBuilder.buildSftpAccessException(ex.getMessage(), ex);
        }
    }

    public static Session newSessionWithPassword(String host, int port, String username, byte[] password) throws SftpException {
        try {
            Session session = newSession(username, host, port);
            session.setPassword(password);
            return session;
        } catch (JSchException ex) {
            throw SftpExceptionBuilder.buildSftpAccessException(ex.getMessage(), ex);
        }
    }

    public static Session newSessionWithPrivateKey(String host, int port, String username, String privateKey) throws SftpException {
        try {
            JSch jSch = newJSch(privateKey);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            return newSession(jSch,username, host, port, config);
        } catch (JSchException ex) {
            throw SftpExceptionBuilder.buildSftpAccessException(ex.getMessage(), ex);
        }
    }

    private static JSch newJSch() {
        return new JSch();
    }

    private static JSch newJSch(String privateKey) throws JSchException {
        JSch jSch = newJSch();
        jSch.addIdentity(privateKey);
        return jSch;
    }

    private static JSch newJSch(Path privateKey) throws JSchException {
        return newJSch(privateKey.toString());
    }


    private static Session newSession(String username, String host, int port) throws JSchException {
        JSch jSch = newJSch();
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        return newSession(jSch, username, host ,port, config);
    }

    private static Session newSession(JSch jSch, String username, String host, int port, Properties config) throws JSchException {
        Session session = jSch.getSession(username, host, port);
        session.setConfig(config);
        return session;
    }


}
