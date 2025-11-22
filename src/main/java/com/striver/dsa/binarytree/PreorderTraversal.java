package com.striver.dsa.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverse(root,ans);
        return ans;
    }
    private void traverse(TreeNode node,List<Integer> ans){
        //base case
        if(node == null){
            return ;
        }
        ans.add(node.val);
        traverse(node.left,ans);
        traverse(node.right,ans);
    }

    public static void main(String[] args) {

    }
}
