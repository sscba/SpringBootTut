package com.striver.dsa.recursion;

import ch.qos.logback.core.util.COWArrayList;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = candidates.length;
        findCombination(candidates,target,n,res,new ArrayList<>(),0);
        return res;
    }

    private void findCombination(int[] candidates, int target, int n, List<List<Integer>> res, ArrayList<Integer> ans, int i) {
        //base case
        if(n == i){
            if(target == 0){
                res.add(new ArrayList<>(ans));
            }
            return;
        }
        if(candidates[i] <= target){
            ans.add(candidates[i]);
            findCombination(candidates,target-candidates[i],n,res,ans,i);
            ans.remove(ans.size()-1);
        }
        findCombination(candidates,target,n,res,ans,i+1);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,7};
        int target = 15;

        List<List<Integer>> res = new CombinationSum().combinationSum(arr,target);
        System.out.println(res.size());
    }
}
