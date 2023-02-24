package com.bii.lru;


/**
 * @author bihaiyang
 * @desc 双向链表的实现
 * @since 2023/02/24
 */
public class DoubleList {
    
    /**
     * 头节点、尾节点
     */
    private Node head, tail;
    
    private int size;
    
    
    public DoubleList(){
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }
    /**
     * @param node
     */
    public void addFirst(Node node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        size++;
    }
    
    public Node removeLast(){
        if (head.next == tail){
            return null;
        }
        Node last = tail.pre;
        last.pre.next = tail;
        tail.pre = last.pre;
        size--;
        return last;
    }
    
    public Node remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size --;
        return node;
    }
    
    public int size(){
        return size;
    }
    
    @Override
    public String toString(){
        Node node = head.next;
        StringBuilder sb = new StringBuilder();
        while (node != null){
            sb.append("(key->");
            sb.append(node.key);
            sb.append(",val->");
            sb.append(node.val);
            sb.append("); ");
            node = node.next;
        }
        return sb.toString();
    }
}

class Node {
    
    /**
     * 存储键值对
     */
    public int key,val;
    /**
     * 双向链表、指向头节点以及尾节点
     */
    public Node pre, next;
    
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
    
}

