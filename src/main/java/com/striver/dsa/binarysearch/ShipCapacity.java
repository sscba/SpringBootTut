package com.striver.dsa.binarysearch;

public class ShipCapacity {

    public int shipWithinDays(int[] weights, int days) {
        int[] weightRange = getRange(weights);
        int low = weightRange[0];
        int high = weightRange[1];

        while(low<=high){
            int mid = (low+high)/2;
            int noOfDays = calculateDays(weights,mid);

            if(noOfDays <= days){
                high = mid -1;

            }else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int calculateDays(int[] weights,int cap) {
        int days = 1;
        int load = 0;
        for(int weight : weights){
            if(load + weight > cap){
                days+= 1;
                load = weight;
            }
            else{
                load += weight;
            }
        }
        return days;
    }


    private int[] getRange(int[] weights) {
        int maxWeight = 0;
        int minWeight = Integer.MIN_VALUE;
        for(int weight : weights){
            maxWeight+=weight;
            minWeight = Math.max(minWeight,weight);
        }
        return new int[]{minWeight,maxWeight};
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        int ans = new ShipCapacity().shipWithinDays(weights,days);
        System.out.println(ans);
    }
}
