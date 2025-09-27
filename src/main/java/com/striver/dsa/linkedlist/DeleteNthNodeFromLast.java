package com.striver.dsa.linkedlist;

public class DeleteNthNodeFromLast {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null && head.next == null) return head;
        int len = LinkedList.lengthLL(head);

        if(len == n) {
            ListNode newHead = head.next;
            head = null;
            return newHead;
        }

        int counter= len - n;
        ListNode temp = head;

        while(temp != null){
            counter--;
            if(counter == 0){
                break;
            }
            temp = temp.next;
        }

        ListNode deleteNode = temp.next;
        temp.next = temp.next.next;
        deleteNode.next = null;

        return head;

    }

    public ListNode optimal(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for(int i=0; i<n ;i++) fast = fast.next;
        if(fast == null) return head.next;

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        ListNode deleteNode = slow.next;
        slow.next = slow.next.next;
        deleteNode.next = null;

        return head;

    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 6};
        ListNode ll = LinkedList.convertArrToListNode(arr);

        LinkedList.traverseLL(ll);


    }
}
