package com.striver.dsa.heap;

import java.util.PriorityQueue;

public class ConnectRopesMinimiseCost {

    public static int minimiseCost(int[] ropes){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)-> a-b);
        for(int rope : ropes){
            minHeap.add(rope);
        }
        int sum =0;
        while(minHeap.size()>1){
            int r1 = minHeap.poll();
            int r2 = minHeap.poll();
            sum += r1+r2;
            minHeap.add(r1+r2);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(minimiseCost(arr));
    }
}
