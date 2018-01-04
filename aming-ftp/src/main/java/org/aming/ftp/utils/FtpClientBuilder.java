package org.aming.ftp.utils;


import org.aming.ftp.enums.FileTransferMode;
import org.aming.ftp.enums.FileType;
import org.aming.ftp.enums.Structure;
import org.aming.ftp.enums.TextFormat;
import org.aming.ftp.exceptions.FtpException;
import org.aming.ftp.exceptions.FtpExceptionBuilder;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.parser.FTPFileEntryParserFactory;

import java.io.IOException;
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

    public FtpClientBuilder setFileType(FileType fileType) throws FtpException {
        try {
            ftpClient.setFileType(fileType.getType());
        } catch (IOException ex) {
            throw FtpExceptionBuilder.buildFtpException(ex.getMessage(), ex);
        }
        return this;
    }

    public FtpClientBuilder setFileType(FileType fileType, int formatOrByteSize) throws FtpException {
        try {
            ftpClient.setFileType(fileType.getType(), formatOrByteSize);
        } catch (IOException ex) {
            throw FtpExceptionBuilder.buildFtpException(ex.getMessage(), ex);
        }
        return this;
    }

    public FtpClientBuilder setFileType(FileType fileType, TextFormat textFormat) throws FtpException {
        try {
            ftpClient.setFileType(fileType.getType(), textFormat.getType());
        } catch (IOException ex) {
            throw FtpExceptionBuilder.buildFtpException(ex.getMessage(), ex);
        }
        return this;
    }

    public FtpClientBuilder setFileStructure(Structure structure) throws FtpException {
        try {
            ftpClient.setFileStructure(structure.getType());
        } catch (IOException ex) {
            throw FtpExceptionBuilder.buildFtpException(ex.getMessage(), ex);
        }
        return this;
    }

    public FtpClientBuilder setFileTransferMode(FileTransferMode mode) throws FtpException {
        try {
           ftpClient.setFileTransferMode(mode.getMode());
        } catch (IOException ex) {
            throw FtpExceptionBuilder.buildFtpException(ex.getMessage(), ex);
        }
        return this;
    }

    public boolean login(String username, String password) throws FtpException {
        try {
            return ftpClient.login(username, password);
        } catch (IOException ex) {
            throw FtpExceptionBuilder.buildFtpException(ex.getMessage(), ex);
        }
    }

    public boolean login(String username, String password, String account) throws FtpException {
        try {
            return ftpClient.login(username, password, account);
        } catch (IOException ex) {
            throw FtpExceptionBuilder.buildFtpException(ex.getMessage(), ex);
        }
    }

    public FTPClient build() {
        return ftpClient;
    }
}
