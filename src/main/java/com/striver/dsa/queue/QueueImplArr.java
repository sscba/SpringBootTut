package com.striver.dsa.queue;

public class QueueImplArr {
    int[] queue;
    int front;
    int end;
    int capacity;
    int size;

    public QueueImplArr(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.size = 0;
        this.front = 0;
        this.end = -1;
    }
    //push
    public void push(int data){
        //check full
        if(size == capacity){
            System.out.println("Queue is Full");
            return ;
        }
        end = (end+1) % capacity;
        queue[end] = data;
        size++;
    }
    //pop
    public int pop(){
        //check empty
        if(size==0){
            System.out.println("Queue is empty!");
            return -1;
        }
        int ele = queue[front];
        front = (front+1)%capacity;
        size--;
        return ele;
    }
    //top
    public int top(){
        //check empty
        if(size == 0){
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }
    //size
    public int size(){
        return size;
    }
    //isEmpty
    public boolean isEmpty(){
        return size == 0;
    }
    //isFull
    public boolean isFull(){
        return size == capacity;
    }
    //iterate
    public void iterate(){
        //check empty
        if(isEmpty()){
            System.out.println("Queue is empty!");
            return;
        }
        for(int i=0; i<size; i++){
            System.out.print(queue[i]+" ");
        }
    }

    public static void main(String[] args) {
        QueueImplArr q = new QueueImplArr(3);
        q.push(1);
        q.push(2);
        q.push(3);
        q.pop();
        q.pop();
        q.pop();
        q.push(4);
        System.out.println(q.top());
        q.iterate();
    }
}
