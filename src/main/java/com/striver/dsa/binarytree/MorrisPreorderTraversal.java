package com.striver.dsa.binarytree;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                preorder.add(curr.val);
                curr=curr.right;
            }else{
                TreeNode prev = curr.left;
                //find the rightmost node of left subtree
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = curr;
                    preorder.add(curr.val);
                    curr = curr.left;
                }else{
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return preorder;
    }
}
