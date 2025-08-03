package com.striver.dsa.linkedlist;

public class MiddleElementLL {

    public static <E> Node<E> middleElement(Node<E> head) {
        if (head.next == null) return head;

        int n = LinkedList.lengthLL(head);
        int cnt = 0;
        int k = n / 2;
        Node<E> temp = head;

        while (temp != null) {
            if (cnt == k) return temp;
            temp = temp.next;
            cnt++;
        }
        return head;
}

    public static <E> Node<E> optimal(Node<E> head) {
        if (head.next == null) return head;

        Node<E> fast = head;
        Node<E> slow = head;
        while(fast.next != null && fast != null){
            if(fast.next.next != null) fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 6};
    Node<Integer> ll = LinkedList.convertArrToLL(a);
    Node<Integer> mid = optimal(ll);
    System.out.println("Length " + LinkedList.lengthLL(ll));
    LinkedList.traverseLL(mid);
}

}
