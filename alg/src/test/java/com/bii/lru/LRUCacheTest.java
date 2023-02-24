package com.bii.lru;

import java.util.Scanner;

/**
 * @author bihaiyang
 * @desc
 * @since 2023/02/24
 */
public class LRUCacheTest {

    public static void LRUTest(){
        LRUCache lruCache = new LRUCache(5);
        Scanner sc = new Scanner(System.in);
        int key,val;
        while(true){
            System.out.println("请输入插入的key和val(以空格隔开,输入-1则结束)");
            key = sc.nextInt();
            if (key == -1) break;
            val = sc.nextInt();
            lruCache.put(key,val);
            System.out.println(lruCache.print());
        }
    
    
    
        while(true){
            System.out.println("请输入需要获取的key(输入-1则结束)");
            key = sc.nextInt();
            if (key == -1) break;
            System.out.println("key->val: "+key+"->"+lruCache.get(key));
            lruCache.print();
        }
    
    }
    
    
    public static void main(String[] args) {
        LRUTest();
    }

}
