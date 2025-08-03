package com.striver.dsa.linkedlist;


import com.sun.source.tree.DoWhileLoopTree;

import java.nio.DoubleBuffer;

class DoublyNode<E>{
    E data;
    DoublyNode<E> prev;
    DoublyNode<E> next;

    public DoublyNode(E data) {
        this.data = data;
    }

    public DoublyNode(E data, DoublyNode<E> prev, DoublyNode<E> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}


public class DoublyLinkedList {

    public static  DoublyNode<Integer> convertArrToDLL(int[] arr){
        int n = arr.length;
        DoublyNode<Integer> head = new DoublyNode<>(arr[0]);
        DoublyNode<Integer> it = head;

        for(int i=1;i<n;i++){
            DoublyNode<Integer> temp = new DoublyNode<>(arr[i]);
            it.next = temp;
            temp.prev = it;
            it = temp;
        }
        return head;
    }

    public static <E> void traverseDLL(DoublyNode<E> dll){
        DoublyNode<E> temp = dll;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static <E> DoublyNode<E> deleteFromHead(DoublyNode<E> head){
        if(head == null) return head;
        DoublyNode<E> temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
        return head;
    }

    public static <E> DoublyNode<E> deleteFromTail(DoublyNode<E> head){
        if(head == null) return head;
        DoublyNode<E> temp = head;
        //traverse reach tail
        while(temp.next != null){
            temp = temp.next;
        }
        DoublyNode<E> prevNode = temp.prev;
        prevNode.next = null;
        temp.prev = null;
        return head;
    }

    public static <E> DoublyNode<E> deleteFromPos(DoublyNode<E> head,int k){
        if(head == null) return head;
        if(k==1) return deleteFromHead(head);
        int cnt =0;
        DoublyNode<E> temp = head;
        //traverse reach tail
        while(temp != null){
            cnt++;
            if(cnt == k){
                if(temp.next == null){
                    temp.prev.next = null;
                    temp.prev = null;
                    break;
                }
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                temp.next = null;
                temp.prev = null;
            }
            temp = temp.next;
        }

        return head;
    }

    public static <E> DoublyNode<E> deleteFromValue(DoublyNode<E> head,E ele){
        if(head == null) return head;
        if(head.data == ele) return deleteFromHead(head);

        DoublyNode<E> temp = head;
        //traverse reach tail
        while(temp != null){

            if(temp.data == ele){
                if(temp.next == null){
                    temp.prev.next = null;
                    temp.prev = null;
                    break;
                }
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                temp.next = null;
                temp.prev = null;
            }
            temp = temp.next;
        }

        return head;
    }

    public static <E> DoublyNode<E> insertAtHead(DoublyNode<E> head, E ele){
        DoublyNode<E> temp = new DoublyNode<>(ele);
        if(head == null) return temp;
        temp.next = head;
        head.prev = temp;
        head = temp;

        return head;
    }

    public static <E> DoublyNode<E> insertAtTail(DoublyNode<E> head, E ele){
        DoublyNode<E> newNode = new DoublyNode<>(ele);
        if(head == null) return newNode;
        DoublyNode<E> temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }

    public static <E> DoublyNode<E> insertAtPos(DoublyNode<E> head,E ele,int pos){
        DoublyNode<E> newNode = new DoublyNode<>(ele);
        if(head == null) return newNode;
        if(pos == 1) return insertAtHead(head,ele);
        DoublyNode<E> temp = head;
        int cnt = 0;
        while(temp != null){

            cnt++;
            if(cnt == pos){
//                if(temp.next == null){
//
//
//                    break;
//                }
                newNode.prev = temp.prev;
                newNode.next = temp.prev.next;
                temp.prev.next = newNode;
                temp.prev = newNode;
            }
            temp = temp.next;
        }


        return head;
    }

    public static <E> DoublyNode<E> insertAtValue(DoublyNode<E> head,E ele,E pos){
        DoublyNode<E> newNode = new DoublyNode<>(ele);
        if(head == null) return newNode;
        if(pos == head.data) return insertAtHead(head,ele);
        DoublyNode<E> temp = head;

        while(temp != null){
            if(temp.data == pos){
                newNode.prev = temp.prev;
                newNode.next = temp.prev.next;
                temp.prev.next = newNode;
                temp.prev = newNode;
            }
            temp = temp.next;
        }
        return head;
    }

    public static <E> DoublyNode<E> reverseDLL(DoublyNode<E> head){
        if(head == null) return head;

        DoublyNode<E> temp = head;

        while(temp.next != null){
            temp = temp.next;
        }
        head = temp;

        while(temp != null){
            temp.next = temp.prev;
            temp.prev = temp.next;
            temp = temp.next;
        }

        return head;

    }



    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};

        DoublyNode<Integer> dll = convertArrToDLL(arr);
        System.out.println("Original DLL: ");
        traverseDLL(dll);

        //Deletion
        //From Head
//        DoublyNode<Integer> deleteDLL = deleteFromValue(dll,4);
//        traverseDLL(deleteDLL);
//
//        //Insertion
//        //From Head
//        DoublyNode<Integer> insertDLL =insertAtValue(dll,777,3);
//        traverseDLL(insertDLL);

        DoublyNode<Integer> reverseDll = reverseDLL(dll);
        traverseDLL(reverseDll);
    }
}
