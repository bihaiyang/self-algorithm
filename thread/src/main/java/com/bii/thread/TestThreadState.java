package com.bii.thread;

/**
 * @author bihaiyang
 * @desc
 * @since 2023/01/16
 */
public class TestThreadState {
    
    
    
    private static final Object LOCK  = new Object();
    
    public static void main(String[] args) {
            testNewRunnableTerminated();
    
    }
    
    private static void testBlocked(){
        Thread t2 = new Thread(() -> {
            System.out.println("before sync");
            synchronized (LOCK){
                System.out.println("in sync");
            }
        }, "t2");
        
        t2.start();
        System.out.println("t2 state:" + t2.getState());
        synchronized (LOCK){
            System.out.println("t2 state:" + t2.getState());
        }
        System.out.println("t2 state:" + t2.getState());
    }
    
    private static void testNewRunnableTerminated(){
    
        Thread t1 = new Thread(() -> {
            System.out.println("Running");
        }, "t1");
    
        System.out.println("t1 state:" + t1.getState());
        t1.start();
        System.out.println("t1 state:" + t1.getState());
        System.out.println("t1 state:" + t1.getState());
    
    }
}
