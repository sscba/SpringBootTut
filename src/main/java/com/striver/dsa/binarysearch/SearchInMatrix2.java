package com.striver.dsa.binarysearch;

public class SearchInMatrix2 {

    public boolean search(int[][] mat,int target){
        int rows = mat.length;
        int cols = mat[0].length;

        for(int row=0;row < rows;row++){
            if(mat[row][0] <= target && mat[row][cols-1] >= target){
                //binary search the row
                int low = 0;
                int high = cols - 1;
                while(low<=high){
                    int mid = (low+high)/2;
                    if(mat[row][mid] == target) return true;
                    else if(mat[row][mid] <  target) low = mid + 1;
                    else high = mid - 1;
                }
            }
        }
        return false;
    }

    public boolean optimal(int[][] mat,int target){
        int row = 0;
        int col = mat[0].length -1;

        while(row < mat.length && col >= 0){
            if(mat[row][col] == target) return true;
            else if(mat[row][col] > target) col--;
            else row++;
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] mat = {{1,4,7,11,15},{2,5,8,12,19},{3,6,?9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] mat = {{-5}};
        int target = -5;

        boolean ans = new SearchInMatrix2().optimal(mat,target);
        System.out.println(ans);
    }
}
