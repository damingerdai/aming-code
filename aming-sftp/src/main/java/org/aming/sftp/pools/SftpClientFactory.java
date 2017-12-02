package org.aming.sftp.pools;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.aming.core.log.AmingLogger;
import org.aming.core.log.LoggerManager;
import org.aming.sftp.pojo.SftpClientConfigure;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.util.Properties;

/**
 * @author daming
 * @version 2017/12/2.
 */
public class SftpClientFactory extends BasePooledObjectFactory<Session> {

    private static final AmingLogger logger = LoggerManager.getLogger(SftpClientFactory.class);

    private SftpClientConfigure configure;

    @Override
    public Session create() throws Exception {
        JSch jSch = new JSch();
        Session session = jSch.getSession(configure.getUsername(),configure.getHost(),configure.getPort());
        session.setPassword(configure.getPassword());

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        // 为Session对象设置properties
        session.setConfig(config);
        session.setTimeout(configure.getTimeout());
        logger.info("session is created");

        return session;
    }

    @Override
    public PooledObject<Session> wrap(Session session) {
        return new DefaultPooledObject<Session>(session);
    }

    @Override
    public void destroyObject(PooledObject<Session> p) throws Exception {
        if(p == null) {
            return;
        }
        Session session = p.getObject();
        if(session != null) {
            session.isConnected();
        }
    }


    public SftpClientFactory(SftpClientConfigure configure) {
        super();
        this.configure = configure;
    }

    public static SftpClientFactory getInstance(SftpClientConfigure configure) {
        return new SftpClientFactory(configure);
    }

}
