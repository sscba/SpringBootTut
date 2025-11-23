package com.striver.dsa.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public List<Integer> iterative(TreeNode root){
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }else{
                if(st.isEmpty()) break;
                node = st.pop();
                inorder.add(node.val);
                node = node.right;
            }
        }
        return inorder;
    }
}
