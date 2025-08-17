package com.striver.dsa.linkedlist;

import java.util.List;

public class Merge2SortedLL {

    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode l1 = head1;
        ListNode l2 = head2;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            }
            else{
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            }
        }

        if(l1 != null) temp.next = l1;
        else temp.next = l2;

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3,6,8,9};
        int[] arr2 = {2,4,5,6,7,10,11,23};

        ListNode l1 = LinkedList.convertArrToListNode(arr1);
        ListNode l2 = LinkedList.convertArrToListNode(arr2);

        ListNode mergedLL = new Merge2SortedLL().merge(l1,l2);
        LinkedList.traverseLL(mergedLL);


    }
}
