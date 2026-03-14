package com.striver.dsa.binarysearchtree;

import com.striver.dsa.binarytree.TreeNode;

public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean validate(TreeNode root, long minVal, long maxVal){
        if(root == null) return true;
        if(root.val >= maxVal || root.val <= minVal) return false;
        return validate(root.left,minVal,root.val) && validate(root.right,root.val,maxVal);
    }
}
