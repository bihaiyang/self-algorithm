package com.bii.spi;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author bihaiyang
 * @desc
 * @since 2023/01/09
 */
public class LoggerService {
    
    private static final LoggerService SERVICE = new LoggerService();

    private final Logger logger;
    
    private final List<Logger> loggerList;
    
    private LoggerService(){
    
        ServiceLoader<Logger> load = ServiceLoader.load(Logger.class);
        loggerList = new ArrayList<>();
        load.forEach(logger -> loggerList.add(logger));
        if (!loggerList.isEmpty()) {
            logger = loggerList.get(0);
        } else {
            logger = null;
        }
    }
    
    public static LoggerService getService(){
        return SERVICE;
    }
    
    public void info(String msg){
        if (logger == null){
            System.out.println("info Logger provider is missing");
        }else {
            logger.info(msg);
        }
    }
    
    public void debug(String msg){
        if (loggerList.isEmpty()){
            System.out.println("debug Logger provider is missing");
        }
    }
}
