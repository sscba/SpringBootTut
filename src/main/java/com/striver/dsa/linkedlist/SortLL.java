package com.striver.dsa.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortLL {

    public ListNode sortList(ListNode head) {
        if (head == null && head.next == null) return head;
        ListNode curr = head;
        ListNode min = null;
        while (curr != null) {
            ListNode temp = curr;
            min = temp;
            while (temp != null) {
                if (min.val > temp.val) min = temp;
                temp = temp.next;
            }
            int val = curr.val;
            curr.val = min.val;
            min.val = val;
            curr = curr.next;
        }

        return head;
    }

    public ListNode sortListBruteForce(ListNode head){
        ListNode temp = head;
        ArrayList<Integer> arr = new ArrayList<>();

        while(temp!= null){
            arr.add(temp.val);
            temp = temp.next;
        }

        //sort arr
        Collections.sort(arr);

        temp = head;
        for(int i=0;i<arr.size();i++){
            temp.val = arr.get(i);
            temp = temp.next;
        }

        return head;

    }

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


    public ListNode mergeSortLL(ListNode head){

        if(head == null || head.next == null) return head;

        ListNode mid = findMid(head);
        ListNode leftHead = head;
        ListNode rightHead = mid.next;
        mid.next = null;

        leftHead = mergeSortLL(leftHead);
        rightHead = mergeSortLL(rightHead);

        return merge(leftHead,rightHead);


    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3,5,9,1,868,576,223,89};
        ListNode ll = LinkedList.convertArrToListNode(arr);

        LinkedList.traverseLL(ll);

        ListNode sortedLL = new SortLL().mergeSortLL(ll);
        System.out.println(" ");
        LinkedList.traverseLL(sortedLL);
    }
}
