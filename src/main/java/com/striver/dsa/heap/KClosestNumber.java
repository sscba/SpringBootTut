package com.striver.dsa.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair{
    int diff;
    int num;
    Pair(int diff, int num){
        this.diff = diff;
        this.num = num;
    }
}

public class KClosestNumber {

    public static List<Integer> solve(int[] nums, int k, int x){
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> b.diff - a.diff);
        for (int num : nums) {
            maxHeap.add(new Pair(Math.abs(x - num), num));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!maxHeap.isEmpty()){
            ans.add(maxHeap.poll().num);
        }
        ans.sort((a,b)-> a-b);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 4;
        int x=3;
        List<Integer> ans = solve(nums,k,x);
        for(int ele: ans){
            System.out.print(ele +" ");
        }
    }
}
