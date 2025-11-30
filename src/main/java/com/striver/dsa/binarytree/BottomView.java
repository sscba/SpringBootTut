package com.striver.dsa.binarytree;

import java.util.*;

public class BottomView {

    public List<Integer> bottomView(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<PairII> q = new LinkedList<>();
        q.offer(new PairII(root,0));
        while(!q.isEmpty()){
            PairII p = q.poll();
            int level = p.level;
            TreeNode node = p.node;
            map.put(level,node.val);
            if(node.left != null) q.offer(new PairII(node.left,level-1));
            if(node.right != null) q.offer(new PairII(node.right,level+1));
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
