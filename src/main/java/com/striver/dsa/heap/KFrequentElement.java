package com.striver.dsa.heap;

import java.util.*;

class PairI{
    int num;
    int freq;
    PairI(int num,int freq){
        this.num = num;
        this.freq = freq;
    }
}

public class KFrequentElement {

    public static int[] kFrequentElement(int[] nums,int k){
        Map<Integer,Integer> mp = new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        PriorityQueue<PairI> minHeap = new PriorityQueue<>((a,b)-> a.freq - b.freq);
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            minHeap.add(new PairI(entry.getKey(), entry.getValue()));
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] ans = new int[k];
        int i=0;
        while(!minHeap.isEmpty()){
            ans[i++]=minHeap.poll().num;
        }
        return  ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k=2;
        int[] ans = kFrequentElement(nums,k);
        for(int ele : ans){
            System.out.print(ele+" ");
        }
    }
}
