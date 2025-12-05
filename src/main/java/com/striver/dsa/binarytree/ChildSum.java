package com.striver.dsa.binarytree;

public class ChildSum {
    public void changeTree(TreeNode root){
        if(root == null) return ;
        int child = 0;
        if(root.left != null) child+=root.left.val;
        if(root.right != null) child+=root.right.val;

        if(child >= root.val) root.val = child;
        else{
            if(root.left != null) root.left.val = child;
            else if(root.right != null) root.right.val = child;
        }

        changeTree(root.left);
        changeTree(root.right);

        int total = 0;
        if(root.left != null) total += root.left.val;
        if(root.right != null) total += root.right.val;
        if(root.left != null || root.right!= null) root.val = total;
    }
}
