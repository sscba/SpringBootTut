package com.striver.dsa.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class OddEvenLL {


    public ListNode optimalSol(ListNode head){
        if (head == null || head.next == null || head.next.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even != null && even.next != null){
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }

    public ListNode betterSol(ListNode head){
        if (head == null || head.next == null || head.next.next == null) return head;

        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null && temp.next != null){
            arr.add(temp.val);
            temp = temp.next.next;
        }
        if(temp != null){
            arr.add(temp.val);
        }

        temp = head.next;
        while(temp != null && temp.next != null){
            arr.add(temp.val);
            temp = temp.next.next;
        }
        if(temp != null){
            arr.add(temp.val);
        }

        int i=0 ;
        temp = head;
        while(temp != null){
            temp.val = arr.get(i++);
            temp = temp.next;
        }

        return head;

    }

    //naive approach
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;

        //create 2 LL- one for odd index and other for even index
        ListNode oddHead = new ListNode(head.val);
        ListNode evenHead = new ListNode(head.next.val);
        ListNode curr = head.next.next;
        ListNode oddCurr = oddHead;
        ListNode evenCurr = evenHead;

        boolean oddCounter = true;

        while (curr != null) {
            ListNode node = new ListNode(curr.val);

            if (oddCounter) {
                oddCurr.next = node;
                oddCurr = oddCurr.next;
            } else {
                evenCurr.next = node;
                evenCurr = evenCurr.next;
            }
            oddCounter = !oddCounter;
            curr = curr.next;
        }

        //point odd LL tail to even LL head
        oddCurr.next = evenHead;
        return oddHead;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 6};
        ListNode ll = LinkedList.convertArrToListNode(arr);

        LinkedList.traverseLL(ll);
        ListNode ans = new OddEvenLL().optimalSol(ll);
        System.out.println(" ");

        LinkedList.traverseLL(ans);


    }
}
