package com.striver.dsa.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] max = new int[n-k+1];
        int right =0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            //remove out of range numbers
            if(!dq.isEmpty() && dq.peek() == i-k){
                dq.poll();
            }
            //remove smaller numbers in k range
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.add(i);
            if(i>=k-1){
                max[right++]=nums[dq.peek()];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k=3;
        int[] ans = maxSlidingWindow(arr,k);
        Arrays.stream(ans).forEach(ele -> System.out.print(ele+" "));
    }
}
