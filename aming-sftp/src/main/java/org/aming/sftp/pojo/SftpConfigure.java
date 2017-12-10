package org.aming.sftp.pojo;

import java.io.Serializable;

/**
 * @author daming
 * @version 2017/12/10.
 */
public class SftpConfigure implements Serializable {

    private static final long serialVersionUID = -2937632241049551835L;

    private static final int DEFAULT_TIMEOUT = 60000;

    private String host;
    private int port;
    private String username;
    private String password;
    private int timeout = DEFAULT_TIMEOUT;

    public String getHost() {
        return host;
    }

    public SftpConfigure setHost(String host) {
        this.host = host;
        return this;
    }

    public int getPort() {
        return port;
    }

    public SftpConfigure setPort(int port) {
        this.port = port;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public SftpConfigure setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SftpConfigure setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getTimeout() {
        return timeout;
    }

    public SftpConfigure setTimeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    public SftpConfigure() {
        super();
    }
}
