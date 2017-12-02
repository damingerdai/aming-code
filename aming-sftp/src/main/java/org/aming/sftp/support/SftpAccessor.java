package org.aming.sftp.support;

import org.aming.sftp.pools.SftpClientPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author daming
 * @version 2017/12/2.
 */
public abstract class SftpAccessor {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private SftpClientPool sftpClientPool;

    public SftpClientPool getSftpClientPool() {
        return sftpClientPool;
    }

    public void setSftpClientPool(SftpClientPool sftpClientPool) {
        this.sftpClientPool = sftpClientPool;
    }

    public void afterPropertiesSet() throws Exception {
        if(getSftpClientPool() == null) {
            throw new IllegalArgumentException("Property 'sftpClientPool' is required");
        }
    }
}
