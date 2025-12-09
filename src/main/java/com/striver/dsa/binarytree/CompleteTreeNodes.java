package com.striver.dsa.binarytree;

public class CompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);
        if(lh == rh ) return (1<<lh)-1;
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftHeight(TreeNode node){
        int cnt = 0;
        while(node != null){
            cnt++;
            node = node.left;
        }
        return cnt;
    }

    private int getRightHeight(TreeNode node){
        int cnt = 0;
        while(node != null){
            cnt++;
            node = node.right;
        }
        return cnt;
    }
}
