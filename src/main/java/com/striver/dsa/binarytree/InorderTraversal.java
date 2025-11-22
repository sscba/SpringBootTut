package com.striver.dsa.binarytree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverse(root,ans);
        return ans;
    }
    private void traverse(TreeNode node,List<Integer> ans){
        if(node == null) return;
        traverse(node.left,ans);
        ans.add(node.val);
        traverse(node.right,ans);
    }
}
