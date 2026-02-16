package com.striver.revision.I.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = candidates.length;
        Arrays.sort(candidates);
        generateCombo(candidates,target,n,0,res,new ArrayList<>());
        return res;
    }

    private void generateCombo(int[] candidates, int target, int n, int i,List<List<Integer>> res, List<Integer> ds){
        if(target == 0 ){
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int j=i; j<n ; j++){
            if(j > i && candidates[j] == candidates[j-1]) continue;
            if(candidates[j] > target) break;

            ds.add(candidates[j]);
            generateCombo(candidates,target-candidates[j],n,j+1,res,ds);
            ds.removeLast();
        }
    }

    public static void main(String[] args) {

    }
}
