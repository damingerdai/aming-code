package org.aming.sftp.support;

import org.aming.sftp.pools.SftpSessionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author daming
 * @version 2017/12/2.
 */
public abstract class SftpAccessor {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private SftpSessionPool sftpSessionPool;

    public SftpSessionPool getSftpClientPool() {
        return sftpSessionPool;
    }

    public void setSftpSessionPool(SftpSessionPool sftpSessionPool) {
        this.sftpSessionPool = sftpSessionPool;
    }

    public void afterPropertiesSet() throws Exception {
        if(getSftpClientPool() == null) {
            throw new IllegalArgumentException("Property 'sftpClientPool' is required");
        }
    }
}
