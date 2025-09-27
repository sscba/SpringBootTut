package com.striver.dsa.linkedlist;

//Given two non-empty linked lists l1 and l2 which represent two non-negative integers.
//The digits are stored in reverse order with each node storing one digit.
//Add two numbers and return the sum as a linked list.
//The sum Linked List will be in reverse order as well.
//The Two given Linked Lists represent numbers without any leading zeros, except when the number is zero itself.
public class Add2NumberLL {


    public ListNode add(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode l1 = head1;
        ListNode l2 = head2;

        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            curr.next = newNode;
            curr = curr.next;
        }
        if(carry != 0){
            curr.next = new ListNode(carry);
        }

        return dummy.next;

    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,4};
        int[] arr2 = {9,9};

        ListNode num1 = LinkedList.convertArrToListNode(arr1);
        ListNode num2 = LinkedList.convertArrToListNode(arr2);

        ListNode sum = new Add2NumberLL().add(num1,num2);
        LinkedList.traverseLL(sum);

    }
}
