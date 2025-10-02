package com.striver.dsa.queue;

public interface Queue {
    void push(int data);
    int pop();
    int top();
    boolean isFull();
    boolean isEmpty();
}
