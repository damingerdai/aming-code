package org.aming.ftp.utils;


import org.aming.ftp.exceptions.FtpException;
import org.aming.ftp.exceptions.FtpExceptionBuilder;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.parser.FTPFileEntryParserFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

/**
 * @author daming
 * @version 2018/1/1.
 */
public class FtpClientBuilder {

    private final FTPClient ftpClient;

    public FtpClientBuilder() {
        ftpClient = new FTPClient();
    }

    public FtpClientBuilder setDataTimeout(int timeout) throws FtpException {
        if (timeout < 0) {
            throw FtpExceptionBuilder.buildFtpException("timeout should be more than 0");
        }

        ftpClient.setDataTimeout(timeout);
        return this;
    }

    public FtpClientBuilder setParserFactory(FTPFileEntryParserFactory parserFactory) throws FtpException {
        if (Objects.isNull(parserFactory)) {
            throw FtpExceptionBuilder.buildFtpException("parserFactory is required");
        }

        ftpClient.setParserFactory(parserFactory);
        return this;
    }

    public FtpClientBuilder setRemoteVerificationEnabled(boolean enable) {
        ftpClient.setRemoteVerificationEnabled(enable);
        return this;
    }

    public FtpClientBuilder setActivePortRange(int minPort, int maxPort) {
        ftpClient.setActivePortRange(minPort, maxPort);
        return this;
    }

    public FtpClientBuilder setActiveExternalIPAddress(String ipAddress) throws FtpException {
        if (Objects.isNull(ipAddress)) {
            throw FtpExceptionBuilder.buildFtpException("ipAddress is required");
        }

        try {
            ftpClient.setActiveExternalIPAddress(ipAddress);
        } catch (UnknownHostException ex) {
            throw FtpExceptionBuilder.buildFtpException(ex.getMessage(), ex);
        }
        return this;
    }

    public FtpClientBuilder setPassiveLocalIPAddress(String ipAddress) throws FtpException {
        if (Objects.isNull(ipAddress)) {
            throw FtpExceptionBuilder.buildFtpException("ipAddress is required");
        }

        try {
            ftpClient.setPassiveLocalIPAddress(ipAddress);
        } catch (UnknownHostException ex) {
            throw FtpExceptionBuilder.buildFtpException(ex.getMessage(), ex);
        }
        return this;
    }

    public FtpClientBuilder setReportActiveExternalIPAddress(String ipAddress) throws FtpException {
        if (Objects.isNull(ipAddress)) {
            throw FtpExceptionBuilder.buildFtpException("ipAddress is required");
        }

        try {
            ftpClient.setReportActiveExternalIPAddress(ipAddress);
        } catch (UnknownHostException ex) {
            throw FtpExceptionBuilder.buildFtpException(ex.getMessage(), ex);
        }
        return this;
    }

    public static void main(String[] args) throws Exception {
        String host = "https://www.baidu.com";
        InetAddress inetAddress = InetAddress.getByName(host);
        System.out.println(inetAddress.getHostName());
    }

}
