package com.striver.dsa.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class PeakElement2 {

    public List<List<Integer>> bruteSol(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(checkPivot(mat,i,j)){
                    ans.add(List.of(i,j));
                    System.out.println("peak element: "+ mat[i][j]);
                }
            }
        }
        return ans;
    }

    public int maxRowElementIndx(int[][] mat,int col){
        int m = mat.length;

        int maxIndex = -1;
        int maxEle = Integer.MIN_VALUE;
        for (int i =0 ;i<m;i++){
            if(mat[i][col] > maxEle){
                maxIndex = i;
                maxEle = mat[i][col];
            }
        }
        return maxIndex;
    }

    public int[] optimalSol(int[][] mat){

        int n = mat[0].length;

        int low = 0;
        int high = n-1;

        while(low<=high){
            int mid = (low+high)/2;
            int maxRowIndx = maxRowElementIndx(mat,mid);
            int left = mid > 0 ? mat[maxRowIndx][mid-1] : -1;
            int right = mid < n-1 ? mat[maxRowIndx][mid+1] : -1;

            if(mat[maxRowIndx][mid] > left && mat[maxRowIndx][mid] > right)
                return new int[]{maxRowIndx,mid};
            else if(mat[maxRowIndx][mid] < left) high = mid -1;
            else low =mid + 1;

        }

        return new int[]{-1,-1};
    }


    private boolean checkPivot(int[][] mat, int i, int j) {
        int m = mat.length;
        int n = mat[0].length;

        //check up
        if(i>0 && mat[i][j] < mat[i-1][j]) return false;
        //check down
        if(i < m-1 && mat[i][j] < mat[i+1][j]) return false;
        //check right
        if(j<n-1 && mat[i][j] < mat[i][j+1]) return false;
        //check left
        if(j>0 && mat[i][j] < mat[i][j-1]) return false;

        return true;
    }
    private boolean checkPivotOpt(int[][] mat, int i, int j) {
        int m = mat.length;
        int n = mat[0].length;

        //check up
        if(i>0 && mat[i][j] < mat[i-1][j]) return false;
        //check down
        if(i < m-1 && mat[i][j] < mat[i+1][j]) return false;
        //check right
//        if(j<n-1 && mat[i][j] < mat[i][j+1]) return false;
//        //check left
//        if(j>0 && mat[i][j] < mat[i][j-1]) return false;

        return true;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,4,3},{3,2,6}};
//        List<List<Integer>> ans = new PeakElement2().bruteSol(mat);
//
//        for(List<Integer> arr : ans){
//            for(Integer ele : arr){
//                System.out.println(ele);
//            }
//        }

        int[] ans = new PeakElement2().optimalSol(mat);
        for(int indx : ans) System.out.println(indx);
    }
}
