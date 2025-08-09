package com.striver.dsa.linkedlist;

import java.util.Stack;

public class PallindromeLL {

    public boolean isPalindromeStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode pointer = head;

        //add all data to stack --> First In Last Out --> store LL data in reverse order
        while(pointer != null){
            stack.add(pointer.val);
            pointer = pointer.next;
        }

        pointer = head;
        while(pointer != null){
            if(stack.peek() != pointer.val) return false;
            stack.pop();
            pointer = pointer.next;
        }
        return true;
    }


    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        //find middle of LL
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse second half of the list
        ListNode prev = null;
        while(slow != null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        //iterate left LL and right LL and check value is equal
        ListNode left = head;
        ListNode right = prev;

        while(right != null){
            if(left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);

        boolean isPallindrome = new PallindromeLL().isPalindromeStack(a);
        System.out.println(isPallindrome);
    }
}
