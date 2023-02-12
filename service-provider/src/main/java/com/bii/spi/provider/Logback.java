package com.bii.spi.provider;

import com.bii.spi.Logger;

/**
 * @author bihaiyang
 * @desc
 * @since 2023/01/09
 */
public class Logback implements Logger {
    
    @Override
    public void info(String msg) {
        System.out.println("Logback info 的输出：" + msg);
    }
    
    @Override
    public void debug(String msg) {
        System.out.println("Logback debug 的输出：" + msg);
    }
}
