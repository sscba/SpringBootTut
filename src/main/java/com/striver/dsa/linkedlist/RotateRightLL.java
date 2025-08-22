package com.striver.dsa.linkedlist;

public class RotateRightLL {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int n = findLen(head);
        k = k % n;
//        System.out.println("N: "+ n +" K: "+k);

        if (k == 0) return head;
        ListNode temp = head;

        for (int i = 0; i < (n - k - 1); i++) {
            temp = temp.next;
        }
        ListNode newHead = temp.next;
        ListNode tail = newHead;
        temp.next = null;
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = head;
        head = newHead;
        return head;

    }

    private static int findLen(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        ListNode head = LinkedList.convertArrToListNode(arr);
        LinkedList.traverseLL(head);
        System.out.println(" ");

        ListNode newHead = RotateRightLL.rotateRight(head,9);
        LinkedList.traverseLL(newHead);

    }
}
