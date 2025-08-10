package com.striver.dsa.linkedlist;

class Node<E> {
    E data;
    Node<E> next;

    Node(E data, Node<E> node) {
        this.data = data;
        this.next = node;
    }

    Node(E data) {
        this.data = data;
        this.next = null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class LinkedList {

    public static ListNode convertArrToListNode(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode it = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            it.next = temp;
            it = temp;
        }

        return head;
    }

    public static Node<Integer> convertArrToLL(int[] arr) {
        Node<Integer> head = new Node<>(arr[0]);
        Node<Integer> it = head;

        for (int i = 1; i < arr.length; i++) {
            Node<Integer> temp = new Node<>(arr[i]);
            it.next = temp;
            it = temp;
        }

        return head;
    }

    public static <E> void traverseLL(Node<E> ll) {
        Node<E> temp = ll;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void traverseLL(ListNode ll) {
        ListNode temp = ll;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static <E> int lengthLL(Node<E> ll) {
        int cnt = 0;
        Node<E> temp = ll;
        while (temp != null) {
//            System.out.print(temp.data + " ");
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }

    public static <E> boolean searchInLL(Node<E> ll, E ele) {
        Node<E> temp = ll;
        while (temp != null) {
            if (temp.data == ele) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static <E> Node<E> deleteFromHeadLL(Node<E> ll) {
        if (ll == null) return ll;

        Node<E> head = ll;
        Node<E> temp = head;
        head = head.next;
//        temp.next = null;
        System.out.println(" Deleted data: " + temp.data + " next: " + temp.next);
        return head;
    }

    public static <E> Node<E> deleteFromTailLL(Node<E> head) {
        if (head == null) return head;
        if (head.next == null) return null;

        Node<E> temp = head;
        Node<E> prev = null;

        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
//        temp = null;

//        System.out.println(" Deleted data: " + temp.data);


        return head;
    }

    public static <E> Node<E> deleteFromPositionLL(Node<E> ll, int pos) {
        if (ll == null) return ll;

        if (pos == 1) {
            return deleteFromHeadLL(ll);
        }

        Node<E> temp = ll;
        Node<E> prev = null;

        while (pos > 1 && temp != null) {
            prev = temp;
            temp = temp.next;
            pos--;
        }

        prev.next = temp.next;
        temp.next = null;
        System.out.println(" Deleted data: " + temp.data + " next: " + temp.next);


        return ll;
    }

    public static <E> Node<E> deleteFromValueLL(Node<E> ll, E ele) {
        if (ll == null) return ll;
        if (ll.data == ele) {
            return deleteFromHeadLL(ll);
        }
        Node<E> temp = ll;
        Node<E> prev = null;
        while (temp != null) {
            if (temp.data == ele) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        //        System.out.println(" Deleted data: " + temp.data + " next: " + temp.next);
        return ll;
    }

    public static <E> Node<E> insertAtHeadLL(Node<E> head, E ele) {
        if (head == null) return new Node<>(ele);

        Node<E> temp = new Node<>(ele);
        temp.next = head;
        head = temp;
        return head;
    }

    public static <E> Node<E> insertAtTailLL(Node<E> head, E ele) {
        if (head == null) return new Node<>(ele);
//        Node<E> Ele = ;
        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node<>(ele);

        return head;
    }

    public static <E> Node<E> insertAtPosLL(Node<E> head, E ele, int pos) {
        if (head == null) return new Node<>(ele);

        Node<E> Ele = new Node<>(ele);
        Node<E> temp = head;
        Node<E> prev = null;

        int cnt = 0;

        while (temp != null) {
            cnt++;
            if (cnt == pos) {
                Ele.next = prev.next;
                prev.next = Ele;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;
    }

    public static <E> Node<E> insertAtValueLL(Node<E> head, E ele, E value) {
        if (head == null) return null;

        Node<E> Ele = new Node<>(ele);
        Node<E> temp = head;
        Node<E> prev = null;

        while (temp != null) {
            if (temp.data == value) {
                Ele.next = prev.next;
                prev.next = Ele;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;
    }

    public static <E> Node<E> reverseLL(Node<E> head){
        if(head == null || head.next == null) return head;

        Node<E> prev = null;
        Node<E> next = null;
        Node<E> temp = head;

        while(temp != null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        head = prev;
        return head;
    }

    public static void main(String[] args) {
//        int[] arr = {3};
        int[] arr = {3, 4, 75, 24, 21, 0, 45, 35};
        Node<Integer> ll = convertArrToLL(arr);

        System.out.print("Original LL: ");
        traverseLL(ll);

//        System.out.println("");
//        ll = deleteFromHeadLL(ll);
//        traverseLL(ll);
//
//        System.out.println("");
//        ll  = deleteFromPositionLL(ll, 3);
//        traverseLL(ll);

//        System.out.println("");
//        System.out.println("\nRemoved from value");
//        ll = deleteFromValueLL(ll,0);
//        traverseLL(ll);

//        System.out.println("Length of linkedList " + lengthLL(ll));

//        int ele = 35;

//        System.out.println("is ele "+ ele + " present in ll "+ searchInLL(ll,ele));


        //Insertion
//        Node<Integer> insertHead = insertAtValueLL(ll, 109, 75);

        Node<Integer> reverseLL = reverseLL(ll);
        System.out.println("");
        traverseLL(reverseLL);

    }


}
