package com.striver.dsa.binarytree;

import java.util.*;

class PairII{
    TreeNode node;
    int level;

    public PairII(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}

public class TopView {

    public List<Integer> topView(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<PairII> q = new LinkedList<>();
        q.offer(new PairII(root,0));
        while(!q.isEmpty()){
            PairII p = q.poll();
            if(!map.containsKey(p.level)) map.put(p.level,p.node.val);
            if(p.node.left != null) q.offer(new PairII(p.node.left,p.level-1));
            if(p.node.right != null) q.offer(new PairII(p.node.right,p.level+1));
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
