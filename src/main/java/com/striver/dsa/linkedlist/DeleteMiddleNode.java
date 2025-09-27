package com.striver.dsa.linkedlist;

public class DeleteMiddleNode {

    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if(slow == head) return null;
        prev.next = slow.next;
        slow.next = null;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {2};
        ListNode ll = LinkedList.convertArrToListNode(arr);

        LinkedList.traverseLL(ll);

        ListNode newLL = new DeleteMiddleNode().deleteMiddle(ll);
        System.out.println(" ");
        LinkedList.traverseLL(newLL);


    }
}
