package com.striver.dsa.linkedlist;

import java.util.*;

public class PairSumDll {

    public List<List<Integer>>  pairSumDll(DListNode head,int target){

        List<List<Integer>> ans = new ArrayList<>();
        if(head.next == null) return ans;

        DListNode left = head;
        DListNode right = head;
        while(right.next != null){
            right = right.next;
        }

        while(right.data > left.data){
            int sum = left.data + right.data;
            if(sum == target){
                ans.add(List.of(left.data,right.data));
                left = left.next;
                right = right.prev;
            }
            else if(sum > target){
                right = right.prev;
            }else{
                left = left.next;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
