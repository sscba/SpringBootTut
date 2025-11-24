package com.striver.dsa.binarytree;

public class HeightBalancedTree {
    public boolean isBalanced(TreeNode root) {
        // base case
        if(root == null) return true;
        int lh = height(root.left);
        int rh = height(root.right);
        if(Math.abs(lh - rh) > 1) return false;

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        if(!left || !right) return false;
        return true;
    }
    public int height(TreeNode root) {
        //base case
        if(root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        return 1 + Math.max(l,r);
    }

    public boolean optimal(TreeNode root){
        return optimalHeight(root) != -1;
    }
    public int optimalHeight(TreeNode root){
        if(root == null) return 0;
        int l = optimalHeight(root.left);
        if(l == -1 ) return -1;
        int r = optimalHeight(root.right);
        if(r == -1) return -1;
        if(Math.abs(l - r) > 1 ) return -1;
        return Math.max(l,r) + 1;
    }
}
