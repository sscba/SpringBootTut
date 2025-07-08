package com.striver.dsa.binarysearch;

public class SqrtNum {

    public int sqrtN(int n){
        int low = 1;
        int high = n;
        int ans = Integer.MIN_VALUE;
        while(low<=high){
            int mid = low + (high -low)/2;
            if(mid * mid <= n){
                ans = Math.max(ans,mid);
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 225;
        int sqrtN = new SqrtNum().sqrtN(n);
        System.out.println("Square Root N: "+ n + " = "+ sqrtN);

    }
}
