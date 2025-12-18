package com.striver.dsa.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                str.append("#,");
                continue;
            }
            str.append(node.val).append(",");
            q.offer(node.left);
            q.offer(node.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isBlank()) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);
        for(int i=1; i< values.length; i++){
            TreeNode parentNode = q.poll();
            if(!values[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parentNode.left = left;
                q.offer(left);
            }
            if(!values[++i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parentNode.right = right;
                q.offer(right);
            }
        }
        return root;
    }
}
