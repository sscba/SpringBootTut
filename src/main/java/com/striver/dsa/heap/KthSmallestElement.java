package com.striver.dsa.heap;

import java.util.PriorityQueue;

public class KthSmallestElement {

    public static int kthSmallestElement(int[] nums, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);
        for(int i=0 ; i<nums.length; i++){
            maxHeap.add(nums[i]);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        return (int)maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums= {2,8,9,3,6,5,7,12,11,54};
        int k = 5;
        System.out.println(kthSmallestElement(nums,k));
    }
}
