package com.striver.dsa.linkedlist;

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}

public class DeleteNode {

    //    237. Delete Node in a Linked List - https://leetcode.com/problems/delete-node-in-a-linked-list/description/
    public void deleteNode(ListNode node) {
        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
        temp = null;
    }


}
