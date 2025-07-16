package com.striver.dsa.binarysearch;

public class SearchInMatrix {

    public boolean search(int[][] mat,int target){
        int m = mat.length;
        int n = mat[0].length;
        int low = 0;
        int high = (m*n)-1;

        while(low<=high){
            int mid = (low+high)/2;
            int row = mid/n;
            int col = mid%n;

            if(mat[row][col] == target) return true;
            else if(mat[row][col] < target) low = mid + 1;
            else high = mid -1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 1;
        boolean ans = new SearchInMatrix().search(mat,target);
        System.out.println(ans);
    }
}
