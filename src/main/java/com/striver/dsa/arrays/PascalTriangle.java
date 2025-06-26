package com.striver.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    private List<Integer> generateRow(int n){
        List<Integer> res = new ArrayList<>();

        int ans = 1;
        res.add(ans);
        for(int i=1;i<n;i++){
            ans = ans*(n-i);
            ans = ans/(i);
            res.add(ans);
        }
        return res;
    }

    public List<List<Integer>> solve(int num){
        List<List<Integer>> res = new ArrayList<>();

        for(int i =1;i<=num;i++){
            res.add(generateRow(i));
        }

        return res;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();

        List<List<Integer>> res = pascalTriangle.solve(5);

        for(List<Integer> row: res ){
            for(int col: row){
                System.out.print(col + " ");
            }
            System.out.println(" ");
        }
    }
}
