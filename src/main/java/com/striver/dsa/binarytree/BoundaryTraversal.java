package com.striver.dsa.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    private boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }

    private void addLeftBoundary(TreeNode node, List<Integer> ans){
        TreeNode curr = node.left;
        while(curr != null){
            if(!isLeaf(curr)) ans.add(curr.val);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    private void addRightBoundary(TreeNode node, List<Integer> ans){
        TreeNode curr = node.right;
        ArrayList<Integer> tmp = new ArrayList<>();
        while(curr != null){
            if(!isLeaf(curr)) tmp.add(curr.val);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        for(int i= tmp.size()-1; i>0 ; i--){
            ans.add(tmp.get(i));
        }
    }

    private void addLeaf(TreeNode root, List<Integer> ans){
        if(isLeaf(root)){
            ans.add(root.val);
            return;
        }
        if(root.left != null) addLeaf(root.left,ans);
        if(root.right != null) addLeaf(root.right,ans);
    }

    public List<Integer> printBoundary(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(!isLeaf(root)) ans.add(root.val);
        addLeftBoundary(root,ans);
        addLeaf(root,ans);
        addRightBoundary(root,ans);
        return ans;
    }
}
