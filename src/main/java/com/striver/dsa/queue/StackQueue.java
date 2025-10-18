package com.striver.dsa.queue;

import java.util.Stack;

public class StackQueue implements Queue{

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public StackQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    @Override
    public void push(int data) {
        stack1.add(data);
    }

    @Override
    public int pop() {
        if(stack2.isEmpty()){
            if(stack1.isEmpty()) throw new IllegalArgumentException("Queue is Empty!");
            while(!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
        }
        return stack2.pop();
    }

    @Override
    public int top() {
        if(stack2.isEmpty()){
            if(stack1.isEmpty()) throw new IllegalArgumentException("Queue is Empty!");
            while(!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
        }
        return stack2.peek();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
