package com.bii.jvm;

import java.util.ArrayList;

/**
 * @author bihaiyang
 * @desc
 * @since 2022/12/28
 */
public class HeapTest {
    
    byte[] a = new byte[1024 * 100];
    
    
    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapTest> heapTests = new ArrayList<>();
        while (true){
            heapTests.add(new HeapTest());
            Thread.sleep(10);
        }
    }
}
