package com.striver.dsa.binarysearch;

public class BouquetMinDay {

    public int solve(int[] bloomDay, int m, int k){
        if((long) m * (long) k > bloomDay.length) return -1;

        int[] minMaxElement = findMinMaxElement(bloomDay);
        int low = minMaxElement[0];
        int high = minMaxElement[1];

        while(low<=high){
            int mid = (low+high)/2;

            //check mid days are possible or not
            if(possible(bloomDay,m,k,mid)){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean possible(int[] bloomDay, int m, int k, int mid) {
        int cnt = 0;
        int nBouquets = 0;
        for(int day : bloomDay){
            if(day <= mid){
                cnt += 1;
            }else{
                nBouquets += (cnt/k);
                cnt =0;
            }
        }
        nBouquets += (cnt/k);
        return nBouquets >= m;

    }

    private int[] findMinMaxElement(int[] bloomDay) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int ele : bloomDay){
            min = Math.min(min,ele);
            max = Math.max(max,ele);
        }
        return new int[]{min,max};
    }

    public static void main(String[] args) {
        int [] arr = {7,7,7,7,12,7,7};
        int m = 2;
        int k=3;

        int ans = new BouquetMinDay().solve(arr,m,k);
        System.out.println(ans);

    }
}
