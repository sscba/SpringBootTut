package com.striver.dsa.binarytree;

import java.util.*;

public class BurnNode {
    public void mapParent(TreeNode root, Map<TreeNode,TreeNode> map){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                q.offer(node.left);
                map.put(node.left,node);
            }
            if(node.right != null){
                q.offer(node.right);
                map.put(node.right,node);
            }
        }
    }

    public int burn(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        mapParent(root,parentMap);
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode,Boolean> visited = new HashMap<>();
        q.offer(target);
        visited.put(target,true);
        int burnTime = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean burnt = false;
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left != null && visited.get(node.left) == null){
                    q.offer(node.left);
                    visited.put(node.left,true);
                    burnt = true;
                }
                if(node.right != null && visited.get(node.right) == null){
                    q.offer(node.right);
                    visited.put(node.right,true);
                    burnt = true;
                }
                if(parentMap.get(node) != null && visited.get(parentMap.get(node)) == null){
                    q.offer(parentMap.get(node));
                    visited.put(parentMap.get(node),true);
                    burnt = true;
                }
            }
            if(burnt) burnTime++;
        }
        return burnTime;
    }
}
