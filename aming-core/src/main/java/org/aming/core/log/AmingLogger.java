package org.aming.core.log;

import org.slf4j.Logger;

/**
 * @author daming
 * @version 2017/12/1.
 */
public class AmingLogger {

    private final Logger logger;

    public void trace(String msg) {
        if(logger.isTraceEnabled()) {
            logger.trace(msg);
        }
    }

    public void trace(String format, Object...params) {
        if(logger.isTraceEnabled()) {
            logger.trace(format, params);
        }
    }

    public void trace(String msg, Throwable t) {
        if(logger.isTraceEnabled()) {
            logger.trace(msg, t);
        }
    }

    public void debug(String msg) {
        if(logger.isDebugEnabled()) {
            logger.debug(msg);
        }
    }

    public void debug(String format, Object...params) {
        if(logger.isDebugEnabled()) {
            logger.debug(format, params);
        }
    }

    public void debug(String msg, Throwable t) {
        if(logger.isDebugEnabled()) {
            logger.debug(msg, t);
        }
    }

    public void info(String msg) {
        if(logger.isDebugEnabled()) {
            logger.info(msg);
        }
    }

    public void info(String format, Object...params) {
        if(logger.isInfoEnabled()) {
            logger.info(format, params);
        }
    }

    public void info(String msg, Throwable t) {
        if(logger.isInfoEnabled()) {
            logger.info(msg, t);
        }
    }

    public void warn(String msg) {
        if(logger.isWarnEnabled()) {
            logger.warn(msg);
        }
    }

    public void warn(String format, Object...params) {
        if(logger.isWarnEnabled()) {
            logger.warn(format, params);
        }
    }

    public void warn(String msg, Throwable t) {
        if(logger.isWarnEnabled()) {
            logger.warn(msg, t);
        }
    }

    public void error(String msg) {
        if(logger.isErrorEnabled()) {
            logger.error(msg);
        }
    }

    public void error(String msg, Object...params) {
        if(logger.isErrorEnabled()) {
            logger.error(msg, params);
        }
    }

    public void error(String msg, Throwable t) {
        if(logger.isErrorEnabled()) {
            logger.error(msg, t);
        }
    }

    public AmingLogger(Logger logger) {
        super();
        this.logger = logger;
    }
}
