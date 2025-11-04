package com.striver.dsa.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    static class VpwComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] o1, int[] o2) {
            double a1 = (1.0*o1[0])/o1[1];
            double b1 = (1.0*o2[0])/o2[1];
            return Double.compare(b1,a1);
        }
    }

    public static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        int[][] vpw = new int[n][2];
        for(int i=0; i<n ; i++){
            vpw[i][0] = val[i];
            vpw[i][1] = wt[i];
        }
        Arrays.sort(vpw, new VpwComparator());
        double res = 0.0;
        int currentCap = capacity;
        for(int i=0; i<n; i++){
            if(vpw[i][1] <= currentCap){
                res += vpw[i][0];
                currentCap -= vpw[i][1];
            }
            else{
                res += (1.0*vpw[i][0]/vpw[i][1]) * currentCap;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int cap = 50;
        System.out.println(fractionalKnapsack(val,wt,cap));
    }
}
