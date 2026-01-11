package com.striver.dsa.binarysearchtree;

import com.striver.dsa.binarytree.TreeNode;

public class KthsmalllestElement {

    private int cnt = 0;
    private int res = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return res;
    }

    private void inorder(TreeNode node, int k){
        if(node == null) return ;
        inorder(node.left,k);
        cnt++;
        if(cnt == k){
            res = node.val;
            return;
        }
        inorder(node.right,k);
    }
}
