package com.striver.dsa.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class HeightOfBinaryTree {
    public int maxDepth(TreeNode root) {
        //base case
        if(root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return 1 + Math.max(l,r);
    }

    public int maxDepthLevelOrderTraversal(TreeNode root) {
        int depth = 0;
        if(root == null) return depth;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            depth++;
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }
        return depth;
    }
}
