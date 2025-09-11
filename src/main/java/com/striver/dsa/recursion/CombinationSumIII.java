package com.striver.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        generateCombination(k, n, 1, new ArrayList<>(), ans);
        return ans;
    }

    private void generateCombination(int k, int n, int i, ArrayList<Integer> ds, List<List<Integer>> ans) {
        //base case
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        if(k == 0 || n <= 0) return ;

        for (int j = i; j <= 9; j++) {
            if (j > n) break;
            ds.add(j);
            generateCombination(k-1, n - j, j + 1, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 7;

        List<List<Integer>> and = new CombinationSumIII().combinationSum3(k, n);
        for (List<Integer> ele : and) {
            System.out.println(ele);
        }
    }
}
