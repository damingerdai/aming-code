package org.aming.sftp.pools;

import com.jcraft.jsch.Session;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * @author daming
 * @version 2017/12/2.
 */
public class SftpClientPool extends GenericObjectPool<Session> {

    @Override
    public Session borrowObject() throws Exception {
        Session session = super.borrowObject();
        if(session == null || !session.isConnected()) {
            session = getFactory().makeObject().getObject();
            addObject();
        }
        return session;
    }

    @Override
    public void returnObject(Session session) {
        if(session != null && session.isConnected()) {
            super.returnObject(session);
            return;
        }
        session = null;

        try {
            addObject();
        } catch (Exception e) {
            // TODO 添加session失败
        }
    }

    @Override
    public void close() {
        super.close();
    }

    public SftpClientPool(PooledObjectFactory<Session> factory) {
        super(factory);
    }

    public SftpClientPool(PooledObjectFactory<Session> factory, GenericObjectPoolConfig config) {
        super(factory, config);
    }

    public SftpClientPool(PooledObjectFactory<Session> factory, GenericObjectPoolConfig config, AbandonedConfig abandonedConfig) {
        super(factory, config, abandonedConfig);
    }
}
