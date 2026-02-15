package com.striver.dsa.linkedlist;


import java.util.HashMap;
import java.util.HashSet;

public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode curr = head;
        HashSet<ListNode> visited = new HashSet<>();

        while(curr != null && curr.next != null){
            //check visited
            if(visited.contains(curr)) return curr;
            visited.add(curr);
            curr = curr.next;
        }
        return null;
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast=fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
