package com.striver.dsa.binarytree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class PairIII{
    TreeNode node;
    int index;

    public PairIII(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

public class MaximumWidth {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<PairIII> q = new LinkedList<>();
        q.offer(new PairIII(root,0));
        int maxWidth = 0;
        while(!q.isEmpty()){
            int minIndex = q.peek().index;
            int first=0;
            int last=0;
            int size = q.size();
            for(int i=0; i<size;i++){
                PairIII p = q.poll();
                TreeNode node = p.node;
                int currIndex = p.index - minIndex;
                if(i==0) first=currIndex;
                if(i==size-1) last=currIndex;
                if(node.left != null){
                    q.offer(new PairIII(node.left,2*currIndex+1));
                }
                if(node.right != null){
                    q.offer(new PairIII(node.right,2*currIndex+2));
                }
            }
            maxWidth = Math.max(maxWidth,last-first+1);
        }
        return maxWidth;
    }
}
