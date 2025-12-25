package com.striver.dsa.binarysearchtree;

import com.striver.dsa.binarytree.TreeNode;

public class Insert {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode curr = root;
        while(true){
            if(curr.val <= val){
                //move right
                if(curr.right!=null) curr = curr.right;
                else{
                    curr.right = new TreeNode(val);
                    break;
                }
            }else{
                //move left
                if(curr.left!=null) curr = curr.left;
                else{
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
