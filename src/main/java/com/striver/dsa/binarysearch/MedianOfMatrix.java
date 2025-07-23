package com.striver.dsa.binarysearch;

public class MedianOfMatrix {

    public int upperBound(int[] arr, int x, int n) {
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > x) {
                ans = mid;
                // look for a smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }


    public int solve(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        int low=Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i =0; i<m; i++){
            low = Math.min(low,mat[i][0]);
            high = Math.max(high,mat[i][n-1]);
        }
        
        while(low<=high){
            int mid = (low+high)/2;
            int smallerNumbers = getSmallerNumCnt(mat,m,n,mid);

            if(smallerNumbers <= (m*n)/2) low = mid + 1;
            else high = mid -1;
        }
        return low;

    }

    private int getSmallerNumCnt(int[][] mat, int m, int n, int mid) {
        int cnt = 0;
        for(int i =0 ;i<m;i++){
            cnt+=upperBound(mat[i],mid,n);
        }
        return cnt;
    }


    public static void main(String[] args) {
        int[][] mat = {{1,4,6},{3,7,9},{1,3,8}};

        int ans = new MedianOfMatrix().solve(mat);
        System.out.println(ans);


    }
}
