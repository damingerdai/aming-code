package org.aming.ftp.pools;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;

/**
 * @author daming
 * @version 2017/12/28.
 */
public class FtpClientFactory extends BasePooledObjectFactory<FTPClient> {

    @Override
    public FTPClient create() throws Exception {
        return null;
    }

    @Override
    public PooledObject<FTPClient> wrap(FTPClient obj) {
        return null;
    }
}
