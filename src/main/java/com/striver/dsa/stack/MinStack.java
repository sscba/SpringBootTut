package com.striver.dsa.stack;

import java.util.Stack;

class Pair{
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MinStack {

    Stack<Pair> st;

    public MinStack() {
        this.st = new Stack<>();
    }

    public void push(int val) {
        int min;
        if(st.isEmpty()){
            min = val;
        }else{
            min = Math.min(val,st.peek().y);
        }
        st.push(new Pair(val,min));
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek().x;
    }

    public int getMin() {
        return  st.peek().y;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-1);
        minStack.push(0);
        minStack.push(4);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
    }
}
