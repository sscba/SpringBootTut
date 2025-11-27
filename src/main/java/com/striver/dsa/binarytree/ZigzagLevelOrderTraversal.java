package com.striver.dsa.binarytree;

import java.util.*;

public class ZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        Boolean reverse = false;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                subList.add(node.val);
            }
            if(reverse){
                Collections.reverse(subList);
            }
            ans.add(subList);
            reverse = !reverse;
        }
        return ans;
    }
}
