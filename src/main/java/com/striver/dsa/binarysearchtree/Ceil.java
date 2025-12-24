package com.striver.dsa.binarysearchtree;

import com.striver.dsa.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Ceil {

    private int getCeil(TreeNode root, int key){
        TreeNode curr = root;
        int ceil = Integer.MAX_VALUE;
        while(curr != null){
            if(curr.val >= key){
                ceil = Math.min(curr.val,ceil);
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
        return ceil;
    }

    private int getFloor(TreeNode root, int key){
        TreeNode curr = root;
        int floor = Integer.MIN_VALUE;
        while(curr != null){
            if(curr.val <= key){
                floor = Math.max(curr.val,floor);
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }
        return floor;
    }

    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        //your code goes here
        int floor = getFloor(root,key);
        int ceil = getCeil(root,key);
        List<Integer> ans = new ArrayList<>();
        if(ceil == Integer.MAX_VALUE){
            ceil = -1;
        }
        if(floor == Integer.MIN_VALUE){
            floor = -1;
        }
        ans.add(floor);
        ans.add(ceil);
        return ans;
    }
}
