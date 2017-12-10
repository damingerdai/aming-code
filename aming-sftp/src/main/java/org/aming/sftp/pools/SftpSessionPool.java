package org.aming.sftp.pools;

import com.jcraft.jsch.Session;
import org.aming.core.log.AmingLogger;
import org.aming.core.log.LoggerManager;
import org.aming.sftp.utils.SftpExceptionBuilder;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.util.Objects;

/**
 * @author daming
 * @version 2017/12/10.
 */
public class SftpSessionPool extends GenericObjectPool<Session> {

    private static final AmingLogger logger = LoggerManager.getLogger(SftpSessionPool.class);

    @Override
    public Session borrowObject() throws Exception {
        try {
            Session session = super.borrowObject();
            if(Objects.isNull(session) || !session.isConnected()) {
                session = getFactory().makeObject().getObject();
                session.isConnected();
                addObject();
            }
            logger.info("borrow a session successfully");
            return session;
        } catch (Exception ex) {
            throw SftpExceptionBuilder.buildSftpException("fail to borrow a session", ex);
        }

    }

    @Override
    public void returnObject(Session session) {
        if(Objects.isNull(session) || !session.isConnected()) {
            session.disconnect();
            super.returnObject(session);
            return;
        }
        session = null;

        try {
            addObject();
        } catch (Exception ex) {
            logger.error("fail to return session", ex);
            throw SftpExceptionBuilder.buildRuntimeException("fail to return session");
        }
    }

    @Override
    public void close() {
        super.close();
    }

    public SftpSessionPool(PooledObjectFactory<Session> factory) {
        super(factory);
    }

    public SftpSessionPool(PooledObjectFactory<Session> factory, GenericObjectPoolConfig config) {
        super(factory, config);
    }
}
