package com.striver.dsa.linkedlist;

public class DeleteDupDLL {

    public DListNode removeDuplicates(DListNode head) {
        DListNode temp = head;
        while (temp.next != null) {
            if (temp.data == temp.next.data) {
                //deleteNode(temp.next);
                DListNode deleteNode = temp.next;
                temp.next = deleteNode.next;
                if (deleteNode.next != null) {
                    deleteNode.next.prev = deleteNode.prev;
                }

                deleteNode.next = null;
                deleteNode.prev = null;
            } else {

                temp = temp.next;
            }
        }

        return head;

    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 2, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6};

        DListNode head = DeleteAllOccKeyDLL.convertArrToDLL(arr);
        DeleteAllOccKeyDLL.traverseDLL(head);

        DListNode newHead = new DeleteDupDLL().removeDuplicates(head);
        System.out.println(" ");
        DeleteAllOccKeyDLL.traverseDLL(newHead);


    }
}
