package com.striver.dsa.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode node,int num){
        this.node = node;
        this.num = num;
    }
}

public class AllTraversalInOneIteration {

    public void traversal(TreeNode root){
        Stack<Pair> st = new Stack<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        if(root == null) return;
        st.push(new Pair(root,1));
        while(!st.isEmpty()){
            Pair it = st.pop();
            if(it.num == 1){
                pre.add(it.node.val);
                it.num++;
                st.push(it);
                if(it.node.left != null){
                    st.push(new Pair(it.node.left,1));
                }
            }else if(it.num == 2){
                in.add(it.node.val);
                it.num++;
                st.push(it);
                if(it.node.right != null){
                    st.push(new Pair(it.node.right,1));
                }
            }else{
                post.add(it.node.val);
            }
        }
    }
}
