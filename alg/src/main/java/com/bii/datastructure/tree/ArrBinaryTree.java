package com.bii.datastructure.tree;

/**
 * @author bihaiyang
 * @desc
 * @since 2022/11/21
 */
public class ArrBinaryTree {
    
    private int[] data;
    
    
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.midOrder(0);
    }
    
    
    public ArrBinaryTree(int[] data) {
        this.data = data;
    }
    
    //前序遍历
    public void preOrder(int index) {
        if (data == null && data.length == 0) {
            return;
        }
        System.out.println(data[index]);
        //向左遍历
        if (index * 2 + 1 < data.length) {
            preOrder(index * 2 + 1);
        }
        //向右遍历
        if (index * 2 + 2 < data.length) {
            preOrder(index * 2 + 2);
        }
    }
    
    //前序遍历
    public void midOrder(int index) {
        if (data == null && data.length == 0) {
            return;
        }
        //向左遍历
        if (index * 2 + 1 < data.length) {
            midOrder(index * 2 + 1);
        }
        System.out.println(data[index]);
        
        //向右遍历
        if (index * 2 + 2 < data.length) {
            midOrder(index * 2 + 2);
        }
    }
    
    //前序遍历
    public void postOrder(int index) {
        if (data == null && data.length == 0) {
            return;
        }
        //向左遍历
        if (index * 2 + 1 < data.length) {
            postOrder(index * 2 + 1);
        }
        //向右遍历
        if (index * 2 + 2 < data.length) {
            postOrder(index * 2 + 2);
        }
        System.out.println(data[index]);
        
    }
}
