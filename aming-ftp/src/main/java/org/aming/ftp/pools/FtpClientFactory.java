package org.aming.ftp.pools;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import sun.net.ftp.FtpClient;

/**
 * @author daming
 * @version 2017/12/28.
 */
public class FtpClientFactory extends BasePooledObjectFactory<FtpClient> {

    @Override
    public FtpClient create() throws Exception {
        return null;
    }

    @Override
    public PooledObject<FtpClient> wrap(FtpClient obj) {
        return null;
    }
}
