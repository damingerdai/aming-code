package org.aming.sftp.pojo;

import java.io.Serializable;

/**
 * @author daming
 * @version 2017/12/2.
 */
public class SftpClientConfigure implements Serializable {

    private static final long serialVersionUID = 9141992389315558432L;

    private static final int DEFAULT_TIMEOUT = 60000;

    private String host;
    private int port;
    private String username;
    private String password;
    private int timeout = DEFAULT_TIMEOUT;

    public String getHost() {
        return host;
    }

    public SftpClientConfigure setHost(String host) {
        this.host = host;
        return this;
    }

    public int getPort() {
        return port;
    }

    public SftpClientConfigure setPort(int port) {
        this.port = port;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public SftpClientConfigure setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SftpClientConfigure setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getTimeout() {
        return timeout;
    }

    public SftpClientConfigure setTimeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    public SftpClientConfigure() {
        super();
    }

    @Override
    public String toString() {
        return "SftpClientConfigure{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", timeout=" + timeout +
                '}';
    }
}
