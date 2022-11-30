package com.bii.datastructure.tree;

/**
 * @author bihaiyang
 * @desc
 * @since 2022/11/24
 */
public class BinaryTreeSortTree {
    
    private Node root;
    
    
    public Node getRoot() {
        return root;
    }
    
    public void delNode(int value) {
        if (root == null) {
            return;
        }
        Node node = root.searchBST(value);
        if (node == null) {
        
        }
    }
}


