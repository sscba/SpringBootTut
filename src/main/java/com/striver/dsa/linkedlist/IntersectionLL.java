package com.striver.dsa.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class IntersectionLL {

    public ListNode optimalSol(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;

            if(temp1 == temp2) return temp1;

            if(temp1 == null) temp1 = headB;
            if(temp2 == null) temp2 = headA;
        }

        return temp1;
    }

    public ListNode betterSol(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int n1 = 0;
        int n2 = 0;

        while(temp1 != null){
            n1++;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            n2++;
            temp2 = temp2.next;
        }

        temp1 = headA;
        temp2 = headB;

        int diff = Math.abs(n1-n2);

        if(n1 > n2){
            //move temp1 d steps forward
            for(int i=0; i<diff ; i++){
                temp1=temp1.next;
            }
        }
        else if(n2 > n1){
            for(int i=0 ; i<diff ; i++){
                temp2 = temp2.next;
            }
        }

        while(temp1 != null && temp2 != null){
            if(temp1 == temp2){
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        Set<ListNode> visited = new HashSet<>();

        while(temp1 != null){
            visited.add(temp1);
            temp1 = temp1.next;
        }
        while(temp2 != null){
            if(visited.contains(temp2)) return temp2;
            temp2 = temp2.next;
        }

        return null;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,4};
        int[] arr2 = {9};

        ListNode num1 = LinkedList.convertArrToListNode(arr1);
        ListNode num2 = LinkedList.convertArrToListNode(arr2);
    }
}
