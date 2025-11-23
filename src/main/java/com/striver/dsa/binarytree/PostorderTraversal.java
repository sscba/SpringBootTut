package com.striver.dsa.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverse(root,ans);
        return ans;
    }

    private void traverse(TreeNode node,List<Integer> ans){
        if(node == null) return ;
        traverse(node.left,ans);
        traverse(node.right,ans);
        ans.add(node.val);
    }

    public List<Integer> iterative(TreeNode root){
        List<Integer> postorder = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        if(root == null) return postorder;
        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode node = st1.pop();
            st2.push(node.val);
            if(node.left != null) st1.push(node.left);
            if(node.right != null) st1.push(node.right);
        }
        while(!st2.isEmpty()){
            postorder.add(st2.pop());
        }
        return postorder;
    }
}
