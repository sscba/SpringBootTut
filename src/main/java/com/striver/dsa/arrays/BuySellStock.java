package com.striver.dsa.arrays;

public class BuySellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i=0; i<prices.length; i++){
            minPrice = Math.min(minPrice,prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int ans = new BuySellStock().maxProfit(arr);
        System.out.println(ans);
    }
}
