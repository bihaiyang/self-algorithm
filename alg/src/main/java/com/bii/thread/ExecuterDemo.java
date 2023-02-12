package com.bii.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author bihaiyang
 * @desc
 * @since 2022/12/13
 */
public class ExecuterDemo {
    
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
    }
}
