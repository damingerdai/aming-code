package org.aming.test.demo;

import java.util.Vector;

import org.aming.sftp.utils.SessionBuilder;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class TestMain {

	public static void main(String[] args) throws JSchException, SftpException {
		Session session = SessionBuilder.newSessionWithPrivateKey("sftp.acxiom.com.cn", 22, "mim640",
				"C:/Users/aming/.ssh/id_rsa");
		System.out.println(session.isConnected());
		session.connect();
		ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
		channel.connect();
		
		channel.cd("IN");
		Vector<?> vector = channel.ls("BSH");
		 for(Object obj : vector) {
             if(obj instanceof ChannelSftp.LsEntry) {
                 ChannelSftp.LsEntry lsEntry = (ChannelSftp.LsEntry)obj;
                 // 可能存在bug
                 if(!lsEntry.getAttrs().isDir()) {
                     System.out.println(lsEntry.getFilename());
                 }
             }
         }
	}

}
