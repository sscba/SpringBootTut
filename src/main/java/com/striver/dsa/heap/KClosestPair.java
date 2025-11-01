package com.striver.dsa.heap;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPair {

    public static List<PairII<Integer, Integer>> kClosestPair(int[][] nums, int k) {
        PriorityQueue<PairII<Integer, PairII<Integer, Integer>>> maxHeap = new PriorityQueue<>((a, b) -> b.key - a.key);
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(new PairII<>(nums[i][0] * nums[i][0] + nums[i][1] * nums[i][1], new PairII<>(nums[i][0], nums[i][1])));
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        List<PairII<Integer,Integer>> ans = new ArrayList<>();
        while(!maxHeap.isEmpty()){
            PairII<Integer,Integer> pair = maxHeap.poll().value;
            ans.add(pair);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{2, 3}, {3, 1}, {4, 7}, {-1, 2}, {5, 6}, {4, -1}};
        List<PairII<Integer,Integer>> ans = kClosestPair(arr,3);
        for(PairII<Integer,Integer> p : ans){
            System.out.println("x: "+ p.key+ " y: "+ p.value);
        }
    }
}
