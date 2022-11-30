package com.bii.datastructure.tree;

/**
 *
 *
 * @author bihaiyang
 * @desc
 * @since 2022/11/24
 */
public class Node {
    
    private int value;
    
    private Node left;
    
    private Node right;
    
    public Node(int value) {
        this.value = value;
    }
    
    public void addBST(Node node){
        if (node == null){
            return;
        }
        if (this.value > node.value){
            if (this.left == null){
                this.left = node;
            }else {
                this.left.addBST(node);
            }
        }else {
            if (this.right == null){
                this.right = node;
            }else {
                this.right.addBST(node);
            }
        }
    }
    
    public Node searchBST(int value){
        if (this.value == value){
            return this;
        }else if (this.value > value){
            if(this.left == null){
                return null;
            }
            return this.left.searchBST(value);
        }else {
            if(this.right == null){
                return null;
            }
            return this.right.searchBST(value);
        }
    }
    
    
    public Node searchBSTParent(int value){
        if (this.value == value){
            return null;
        }else if (this.value > value){
            if(this.left == null){
                return null;
            }
            if (this.left.value == value){
                return this;
            }
            return this.left.searchBSTParent(value);
        }else {
            if(this.right == null){
                return null;
            }
            if (this.right.value == value){
                return this;
            }
            return this.right.searchBSTParent(value);
        }
    }
    public int height(){
       return Math.max(right == null ? 0 : right.height(), left == null ? 0 : left.height()) + 1;
    }
    
    
    public int leftHeight(){
        if (this.left == null){
            return 0;
        }
        return left.height();
        
    }
    
    public int rightHeight(){
        if (this.right == null){
            return 0;
        }
        return right.height();
    }
    
    public void midOrder(){
        if(this.left != null){
            this.left.midOrder();
        }
        System.out.println(this.value);
        if(this.right != null){
            this.right.midOrder();
        }
    }
    
    
}
