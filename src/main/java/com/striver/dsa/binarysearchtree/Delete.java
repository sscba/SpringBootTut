package com.striver.dsa.binarysearchtree;

import com.striver.dsa.binarytree.TreeNode;

public class Delete {
    private TreeNode helper(TreeNode root){
        if(root.left == null){
            return root.right;
        }else if(root.right == null){
            return root.left;
        }else{
            TreeNode rightChild = root.right;
            TreeNode lastRightChild = findLastRightChild(root.left);
            lastRightChild.right = rightChild;
            return root.left;
        }
    }

    private TreeNode findLastRightChild(TreeNode root) {
        if(root.right == null){
            return root;
        }
        return findLastRightChild(root.right);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key ){
            return helper(root);
        }
        TreeNode curr = root;
        while(curr != null){
            if(curr.val > key){
                //move left
                if(curr.left != null && curr.left.val == key){
                    curr.left = helper(curr.left);
                    break;
                }else{
                    curr = curr.left;
                }
            }else{
                //move right
                if(curr.right != null && curr.right.val == key){
                    curr.right = helper(curr.right);
                    break;
                }else{
                    curr = curr.right;
                }
            }
        }
        return root;
    }
}
