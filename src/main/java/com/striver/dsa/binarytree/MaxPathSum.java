package com.striver.dsa.binarytree;

public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        findMax(root,maxi);
        return maxi[0];
    }
    private int findMax(TreeNode root, int[] maxi){
        if(root == null) return 0;
        int left =  Math.max(0,findMax(root.left,maxi));
        int right =  Math.max(0,findMax(root.right,maxi));
        maxi[0] = Math.max(maxi[0], root.val+right+left);
        return root.val+ Math.max(left,right);
    }
}
