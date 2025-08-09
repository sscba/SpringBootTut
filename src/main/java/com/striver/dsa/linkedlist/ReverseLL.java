package com.striver.dsa.linkedlist;

public class ReverseLL {

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);

        ListNode rev = new ReverseLL().reverse(a);
        // print rev: should print 3 2 1

        while(rev != null){
            System.out.print(rev.val+ " -> ");
            rev = rev.next;
        }
    }

    private ListNode reverse(ListNode head) {

        // base case: empty or single node
        if (head == null || head.next == null) return head;

        // reverse the rest and get new head
        ListNode newHead = reverse(head.next);

        // make head.next (the node after head) point back to head
        head.next.next = head;

        // break the original forward link to avoid a cycle
        head.next = null;

        return newHead;
    }
}
