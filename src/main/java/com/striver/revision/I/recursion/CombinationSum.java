package com.striver.revision.I.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = candidates.length;
        generate(candidates,target,n,0,res,new ArrayList<>());
        return res;
    }

    private void generate(int[] candidates,int target,int n, int i,List<List<Integer>> res, List<Integer> ds){
        //base case
        if(n==i){
            if(target==0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }

        if(candidates[i] <= target){
            ds.add(candidates[i]);
            generate(candidates,target-candidates[i],n,i,res,ds);
            ds.removeLast();
        }
        generate(candidates,target,n,i+1,res,ds);
    }

    public static void main(String[] args) {

    }
}
