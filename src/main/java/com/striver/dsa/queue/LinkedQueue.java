package com.striver.dsa.queue;

class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedQueue implements Queue{
    Node front;
    Node end;
    int size;

    public LinkedQueue(){
        this.front = new Node(-1);
        this.end = new Node(-1);
        size = 0;
    }

    @Override
    public void push(int data) {
        end.next = new Node(data);
        end = end.next;
        if(isEmpty()){
            front = end;
        }
        size++;
    }

    @Override
    public int pop() {
        if(isEmpty()){
            return -1;
        }
        Node temp = front;
        front = front.next;
        temp.next = null;
        size--;
        return temp.data;
    }

    @Override
    public int top() {
        if(isEmpty()){
            return -1;
        }
        return front.data;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
