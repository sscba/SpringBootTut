package com.striver.dsa.linkedlist;

public class RotateKNodes {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode nextNode = null;
        ListNode prevNode = null;
        while(temp != null){
            ListNode kthNode = findKthNode(temp,k);
            if(kthNode == null){
                if(prevNode != null){
                    prevNode.next = temp;
                }
                break;
            }
            nextNode = kthNode.next;
            kthNode.next = null;
            reverseLinkedList(temp);
            if(temp == head){
                head = kthNode;
            }
            else{
                prevNode.next = kthNode;
            }

            prevNode = temp;
            temp = nextNode;

        }
        return head;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    private ListNode findKthNode(ListNode temp, int k) {
        while(temp != null && k>1){
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        ListNode head = LinkedList.convertArrToListNode(arr);
        LinkedList.traverseLL(head);
        System.out.println(" ");

        ListNode newHead = new RotateKNodes().reverseKGroup(head,3);
        LinkedList.traverseLL(newHead);


    }
}
