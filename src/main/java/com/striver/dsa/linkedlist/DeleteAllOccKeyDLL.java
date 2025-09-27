package com.striver.dsa.linkedlist;


class DListNode{
    int data;
    DListNode prev;
    DListNode next;

    public DListNode(int data) {
        this.data = data;
    }

    public DListNode(int data, DListNode prev, DListNode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

public class DeleteAllOccKeyDLL {

    public static  DListNode convertArrToDLL(int[] arr){
        int n = arr.length;
        DListNode head = new DListNode(arr[0]);
        DListNode it = head;

        for(int i=1;i<n;i++){
            DListNode temp = new DListNode(arr[i]);
            it.next = temp;
            temp.prev = it;
            it = temp;
        }
        return head;
    }

    public static  void traverseDLL(DListNode dll){
        DListNode temp = dll;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public DListNode deleteAllOccurrences(DListNode head, int target) {
        if (head == null) return null;

        DListNode current = head;

        while (current != null) {
            if (current.data == target) {
                // Store next node before deletion
                DListNode nextNode = current.next;

                // If deleting head node, update head
                if (current == head) {
                    head = current.next;
                }

                // Delete the current node
                deleteNode(current);

                // Move to next node
                current = nextNode;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    /**
     * Helper method to delete a specific node from doubly linked list
     */
    private void deleteNode(DListNode node) {
        if (node == null) return;

        // Update previous node's next pointer
        if (node.prev != null) {
            node.prev.next = node.next;
        }

        // Update next node's prev pointer
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        // Clean up the node (optional, helps with garbage collection)
        node.prev = null;
        node.next = null;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4};

        DListNode head = convertArrToDLL(arr);
        traverseDLL(head);

        DListNode alterDLL = new DeleteAllOccKeyDLL().deleteAllOccurrences(head,1);
        System.out.println(" ");
        traverseDLL(alterDLL);

    }
}
