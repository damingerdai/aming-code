package org.aming.core.log;

import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author daming
 * @version 2017/12/2.
 */
public class LoggerManager {

    private static Map<String,AmingLogger> cache = new HashMap<String, AmingLogger>();

    public static AmingLogger getLogger(String loggerName) {
        if(cache.containsKey(loggerName)) {
            return cache.get(loggerName);
        } else {
            AmingLogger logger = new AmingLogger(LoggerFactory.getLogger(loggerName));
            cache.put(loggerName,logger);
            return logger;
        }
    }

    public static AmingLogger getLogger(Class<?> className) {
        return getLogger(className.getName());
    }
    
}
