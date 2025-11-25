package com.striver.dsa.binarytree;

public class DiameterBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        findMax(root,diameter);
        return diameter[0];
    }
    private int findMax(TreeNode root, int[] diameter){
        if(root == null) return 0;
        int lh = findMax(root.left,diameter);
        int rh = findMax(root.right,diameter);
        diameter[0] = Math.max(diameter[0], lh+rh);
        return 1+Math.max(lh,rh);
    }
}
