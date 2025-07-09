package com.striver.dsa.binarysearch;

public class KokoBanana {

    private int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public int solve(int[] piles, int h) {
        int low = 1;
        //find max
        int high = findMax(piles);
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            int timeTaken = findTimeToEatPile(piles, mid);
            if (timeTaken <= h) {
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;

        }
        return ans;

    }

    private int findTimeToEatPile(int[] piles, int mid) {
        int time = 0;
        for(int pile : piles){

            time += Math.ceil((double) pile/ (double) mid);
        }
        return time;
    }


    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 8;

        int ans = new KokoBanana().solve(piles, h);

        System.out.println(ans);
    }
}
