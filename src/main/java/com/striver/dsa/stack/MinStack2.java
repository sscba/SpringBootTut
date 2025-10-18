package com.striver.dsa.stack;

import java.util.Stack;

public class MinStack2 {

    Stack<Long> st;
    Long min;

    public MinStack2() {
        this.st = new Stack<>();
        min = Long.MAX_VALUE;
    }

    public void push(int val) {
        Long value = Long.valueOf(val);
        if(st.empty()){
            min = value;
            st.push(value);
        }else{
            if(min > val){
                long newVal = 2*value - min;
                min = value;
                st.push( newVal);
            }else{
                st.push(value);
            }
        }
    }

    public void pop() {
        if(st.empty()) return ;
        Long x = st.peek();
        if(x < min){
            min = 2*min - x;
        }
        st.pop();
    }

    public int top() {
        Long x = st.peek();
        if(x < min){
            return min.intValue();
        }
        return x.intValue();
    }

    public int getMin() {
        return min.intValue();
    }

}
