package com.striver.dsa.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public List<Integer> iterative(TreeNode root){
        List<Integer> preorder = new ArrayList<>();
        if(root == null) return preorder;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            preorder.add(node.val);
            if(node.right != null) st.push(node.right);
            if(node.left != null) st.push(node.left);
        }
        return preorder;
    }

    public static void main(String[] args) {

    }
}
