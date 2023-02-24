package com.bii.lru;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author bihaiyang
 * @desc lru缓存
 * @since 2023/02/24
 */
public class LRUCache {

    private HashMap<Integer, Node> map;
    
    private DoubleList cache;
    
    private int capacity;
    
    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }
    
    
    public void delete(int key){
        Node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }
    
    public void removeLast(){
        Node node = cache.removeLast();
        map.remove(node.key);
    }
    
    public int makeFirst(int key){
        Node node = map.get(key);
        cache.remove(node);
        cache.addFirst(node);
        return node.val;
    }
    
    public void addFirst(int key, int val){
        Node node = new Node(key, val);
        cache.addFirst(node);
        map.put(key, node);
    }
    
    public void put(int key, int val){
        if (map.containsKey(key)){
            delete(key);
            addFirst(key, val);
            return;
        }
        
        if (cache.size() >= capacity){
            removeLast();
        }
        addFirst(key, val);
    }
    
    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }
        return makeFirst(key);
    }
    
    public int size(){
        return cache.size();
    }
    
    public String print(){
        return cache.toString();
    }
    
    
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
