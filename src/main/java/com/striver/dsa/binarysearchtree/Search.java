package com.striver.dsa.binarysearchtree;

import com.striver.dsa.binarytree.TreeNode;

public class Search {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curr = root;
        while(curr != null && curr.val != val){
            curr = curr.val < val ? curr.right : curr.left;
        }
        return curr;
    }
}
