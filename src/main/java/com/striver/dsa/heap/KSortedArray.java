package com.striver.dsa.heap;

import java.util.PriorityQueue;

public class KSortedArray {

    public int[] sort(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)-> a-b);
        int curr=0;
        for(int i=0; i<nums.length; i++){
            minHeap.add(nums[i]);
            if(minHeap.size()>k){
                nums[curr++] = minHeap.poll();
            }
        }
        while(!minHeap.isEmpty()){
            nums[curr++] = minHeap.poll();
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 2, 3, 6, 7, 8, 9, 10};
        int k = 2;
        int[] ans = new KSortedArray().sort(nums,k);
        for(int ele : ans){
            System.out.print(ele+" ");
        }
    }
}
