package com.striver.dsa.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelorderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        q.offer(root);
        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0; i<level; i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                subList.add(q.poll().val);
            }
            ans.add(subList);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
