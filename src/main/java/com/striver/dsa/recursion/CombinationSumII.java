package com.striver.dsa.recursion;

import java.util.*;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = candidates.length;
        Arrays.sort(candidates);
        findCombinations(candidates, n, res, new ArrayList<>(), 0, target);
        return res;
    }

    private static void findCombinations(int[] candidates, int n, List<List<Integer>> res, List<Integer> ans, int indx, int target) {
        //base case
        if(target == 0){
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int i = indx; i<n ; i++){
            if(i > indx && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;

            ans.add(candidates[i]);
            findCombinations(candidates,n,res,ans,i+1,target-candidates[i]);
            ans.remove(ans.size()-1);
        }

    }


    public static void main(String[] args) {
        int[] arr = {2,5,2,1,2};
        int target = 5;

        List<List<Integer>> res = new CombinationSumII().combinationSum2(arr, target);

        for (List<Integer> ans : res) {
            for(Integer ele: ans){
                System.out.print(ele+" ");
            }
            System.out.println("");
        }

    }
}
