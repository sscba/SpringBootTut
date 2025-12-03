package com.striver.dsa.binarytree;

import java.util.ArrayList;
import java.util.List;

public class RootToNode {

    private boolean getPath(TreeNode root, List<Integer> path, int node){
        if(root == null) return false;
        path.add(root.val);
        if(root.val == node) return true;
        if(getPath(root.left,path,node) || getPath(root.right,path,node)) return true;
        path.removeLast();
        return false;
    }

    List<Integer> search(TreeNode root, int node){
        List<Integer> path = new ArrayList<>();
        if(root == null) return path;

        return path;
    }
}
