package com.striver.dsa.matrix;

import java.util.List;

public class SetMatrixZeroes {


    public void markRowAndColZero(int[] zerosRow,int[] zerosCol, int row,int col){
        zerosRow[row] = 1;
        zerosCol[col] = 1;
    }

    public void solve(int[][] nums){
        int rowNum = nums.length;
        int colNum = nums[0].length;

        int[] zeroesRow = new int[rowNum];
        int[] zeroesCol = new int[colNum];



        for(int i=0; i<rowNum;i++){
            for(int j= 0; j<colNum;j++){
                if(nums[i][j] == 0 ){
                    markRowAndColZero(zeroesRow,zeroesCol,i,j);
                }
            }
        }

        for(int i=0; i<rowNum;i++){
            for(int j= 0; j<colNum;j++){
                if(zeroesRow[i] == 1 || zeroesCol[j] == 1 ){
                    nums[i][j] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] nums = {{1,1,1},{1,1,1},{0,1,0}};

        int rowNum = nums.length;
        int colNum = nums[0].length;

        for(int i=0; i<rowNum;i++){
            for(int j= 0; j<colNum;j++){
                System.out.print(nums[i][j]+ " ");
            }
            System.out.println(" ");
        }

       long st = System.currentTimeMillis();
        SetMatrixZeroes matrixZeroes = new SetMatrixZeroes();
        matrixZeroes.solve(nums);
        long end = System.currentTimeMillis();
        System.out.println(" Time Taken: "+ (end-st) + " ms");

        for(int i=0; i<rowNum;i++){
            for(int j= 0; j<colNum;j++){
                System.out.print(nums[i][j]+ " ");
            }
            System.out.println(" ");
        }


    }
}
