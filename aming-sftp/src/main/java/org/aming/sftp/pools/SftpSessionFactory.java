package org.aming.sftp.pools;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import org.aming.core.log.AmingLogger;
import org.aming.core.log.LoggerManager;
import org.aming.sftp.pojo.SftpConfigure;
import org.aming.sftp.utils.SftpExceptionBuilder;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.util.Objects;
import java.util.Properties;

/**
 * @author daming
 * @version 2017/12/10.
 */
public class SftpSessionFactory extends BasePooledObjectFactory<Session> {

    private static final AmingLogger logger = LoggerManager.getLogger(SftpSessionFactory.class);

    private SftpConfigure sftpConfigure;

    @Override
    public Session create() throws Exception {
        try {
            JSch jSch = new JSch();
            Session session = jSch.getSession(sftpConfigure.getUsername(),sftpConfigure.getHost(),sftpConfigure.getPort());
            session.setPassword(sftpConfigure.getPassword());

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            // 为Session对象设置properties
            session.setConfig(config);
            session.setTimeout(sftpConfigure.getTimeout());
            logger.info("session is created");
            return session;
        } catch (Exception ex) {
            throw SftpExceptionBuilder.buildSftpException("fail to create new session", ex);
        }
    }

    @Override
    public PooledObject<Session> wrap(Session session) {
        return new DefaultPooledObject<Session>(session);
    }

    @Override
    public void destroyObject(PooledObject<Session> p) throws Exception {
        try {
            if(Objects.nonNull(p)) {
                Session session = p.getObject();
                if(Objects.nonNull(session)) {
                    session.isConnected();
                }
            }
        } catch (Exception ex) {
            throw SftpExceptionBuilder.buildSftpException("fail to destroy session", ex);
        }
    }
    
    @Override
    public boolean validateObject(PooledObject<Session> p) {
    	if(Objects.isNull(p)) {
    		return false;
    	}
    	Session session = p.getObject();
    	if(Objects.isNull(session)) {
    		return false;
    	}
    	return session.isConnected();
    }

    public SftpSessionFactory(SftpConfigure sftpConfigure) {
        super();
        this.sftpConfigure = sftpConfigure;
    }

    public static SftpSessionFactory getInstance(SftpConfigure sftpConfigure) {
        return new SftpSessionFactory(sftpConfigure);
    }
}
