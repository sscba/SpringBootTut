package com.striver.dsa.heap;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static int kthLargestElement(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->  a-b);
        for(int i=0 ; i<nums.length; i++){
            minHeap.add(nums[i]);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {55,4,3,2,5,7,8,94,31,6765,23,4,967};
        int k = 5;
        System.out.println(kthLargestElement(nums,k));
    }
}
