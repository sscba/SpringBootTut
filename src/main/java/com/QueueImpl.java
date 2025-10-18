package com;

import java.util.ArrayList;
import java.util.List;

public class QueueImpl {

    List<Integer> que = new ArrayList<>(10);
    int start = -1;
    int end = -1;
    //pop
    public int pop(){
        //check if empty
        if(start == -1) return -1;

        int element = que.get(start);
        start++;
        return element;
    }
    //push
    public void push(int n){
        //empty
        if(start==-1 && end==-1){
            start=0;
            end=0;
        }else{
            end++;
        }
        if(end < que.size()){
            //add to array
            que.add(end,n);
        }
        else{
            System.out.println("que is full!");
        }
    }

    //top
    public int top(){
        if(end != -1) return que.get(start);
        System.out.println("que is empty");
        return -1;
    }

    public static void main(String[] args) {

    }
}
