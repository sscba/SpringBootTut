package com.striver.dsa.linkedlist;

public class ReorderList {

    public ListNode reorderList(ListNode head) {
        if(head.next == null || head.next.next == null) return head;

        ListNode mid = findMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        rightHead = reverse(rightHead);

        return merge(head,rightHead);
    }

    private ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode next = temp;
        ListNode prev = null;

        while(next != null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    private ListNode merge(ListNode leftHead, ListNode rightHead){
        ListNode leftTemp = leftHead;
        ListNode rightTemp = rightHead;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        boolean left = true;

        while(leftTemp != null && rightTemp != null){
            if(left){
                curr.next = leftTemp;
                curr = leftTemp;
                leftTemp = leftTemp.next;
            }else{
                curr.next = rightTemp;
                curr = rightTemp;
                rightTemp = rightTemp.next;
            }
            left = !left;
        }
        if(rightTemp == null) curr.next = leftTemp;

        return dummy.next;
    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,4,5,6,7,8,9};

        ListNode ll = LinkedList.convertArrToListNode(arr1);
        LinkedList.traverseLL(ll);

        System.out.println(" ");
        ListNode reorderLL = new ReorderList().reorderList(ll);

        LinkedList.traverseLL(reorderLL);

    }
}
