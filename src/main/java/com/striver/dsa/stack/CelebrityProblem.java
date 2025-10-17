package com.striver.dsa.stack;

public class CelebrityProblem {

    public static int bruteForce(int[][] mat){
        int n = mat.length;
        int[] knowMe = new int[n];
        int[] iKnow = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1 && i != j){
                    knowMe[j]++;
                    iKnow[i]++;
                }
            }
        }
        for(int i=0; i<n; i++){
            if(iKnow[i] == 0 && knowMe[i] == n-1){
                return i;
            }
        }
        return -1;
    }

    public static int optimal(int[][] mat){
        int n = mat.length;
        int top = 0;
        int bottom = n-1;
        while(top<bottom){
            if(mat[top][bottom] == 1){
                top++;
            }else if(mat[bottom][top] == 1){
                bottom--;
            }else{
                top++;
                bottom--;
            }
        }
        if(top>bottom) return -1;
        for(int i=0; i<n; i++){
            if(i == top) continue;
            if(mat[top][i] == 1 || mat[i][top] == 0){
                return -1;
            }
        }
        return top;
    }

    public static void main(String[] args) {
//        1 1 0
//        0 1 0
//        0 1 1
        int[][] mat = {{1,1,0},{0,1,0},{0,1,1}};
        System.out.println(optimal(mat));
    }
}
