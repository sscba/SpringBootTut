package com.striver.revision.I.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        generateCombo(k,n,1,ans,new ArrayList<>());
        return ans;
    }

    private void generateCombo(int k, int n, int i,List<List<Integer>> ans, List<Integer> ds){
        //base case
        if(k==0 && n==0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        if(k==0 || n<=0) return ;

        for(int j=i; j<=9; j++){
            if(j>n) break;
            ds.add(j);
            generateCombo(k-1,n-j,j+1,ans,ds);
            ds.removeLast();
        }

    }

    public static void main(String[] args) {
        int k=3;
        int n=4;
    }
}
