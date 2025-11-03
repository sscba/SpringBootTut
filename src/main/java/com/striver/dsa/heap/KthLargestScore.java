package com.striver.dsa.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestScore {
    private Queue<Integer> minHeap;
    int size;

    public KthLargestScore(int k, int[] nums) {
        this.size = k;
        this.minHeap = new PriorityQueue<>((a,b) -> a-b);
        for(int num : nums){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size()>size){
            minHeap.poll();
        }
        return minHeap.peek();
    }

}
