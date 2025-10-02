package com.striver.dsa.stack;



public class ArrStack implements Stack{

    int[] stack;
    int top;
    int capacity;
    int size;

    public ArrStack(int capacity){
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = 0;
        this.size = 0;
    }

    @Override
    public void push(int data) {
        //check full
        if(isFull()){
            throw new IllegalArgumentException("Queue is full!");
        }
        stack[top++] = data;
        size++;
    }

    @Override
    public int pop() {
        //check empty
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty!");
        }
        int ele = stack[top--];
        size--;
        return ele;
    }

    @Override
    public int top() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty!");
        }
        return stack[top];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }
    public boolean isFull(){
        return size == capacity;
    }

    public static void main(String[] args) {

    }
}
