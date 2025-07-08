package com.striver.dsa.binarysearch;

public class NthRootM {

    public int solve(int N,int M){
        int low = 1;
        int high = M/(N);
        while(low <= high){
            int mid = (low+high)/2;
            long val = calculate(mid,N);

            if(val == M) return mid;
            else if(val < M) low = mid + 1;
            else high = mid -1;

        }
        return -1;
    }

    private long calculate(int mid, int n) {
        long ans =1;
        while(n > 0){
            ans *= mid;
            n--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int N = 3;
        int M = 8;

        long st =System.currentTimeMillis();
        int ans = new NthRootM().solve(N,M);
        long end =System.currentTimeMillis();
        System.out.println("ans: "+ ans+ " time taken: "+ (end -st)+" ms" );

    }
}
