package com.striver.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        String init = ".".repeat(n);
        for (int i = 0; i < n; i++) {
            board.add(init);
        }
//        solve(0, board, ans, n);
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2*n -1];
        int[] lowerDiagonal = new int[2*n -1];
        solveOptimise(0,board,ans,n,leftRow,upperDiagonal,lowerDiagonal);
        return ans;
    }

    public void solveOptimise(int col, List<String> board, List<List<String>> ans, int n
            , int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal) {
        //base case
        if(col == n){
            ans.add(new ArrayList<>(board));
            return;
        }
        for(int row=0; row<n; row++){
            if(leftRow[row] == 0 && upperDiagonal[n-1+col-row] == 0 && lowerDiagonal[row+col]==0){
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col,'Q');
                board.set(row,sb.toString());
                leftRow[row] = 1;
                lowerDiagonal[row+col] = 1;
                upperDiagonal[n-1+col-row] = 1;
                //backtrack
                solveOptimise(col+1,board,ans,n,leftRow,upperDiagonal,lowerDiagonal);
                //remove
                sb.setCharAt(col,'.');
                board.set(row,sb.toString());
                leftRow[row] = 0;
                lowerDiagonal[row+col] = 0;
                upperDiagonal[n-1+col-row] = 0;
            }
        }

    }

    public void solve(int col, List<String> board, List<List<String>> ans, int n) {
        //base case
        if (col == n) {
            ans.add(new ArrayList<>(board));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isPossible(board, row, col)) {
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col, 'Q');
                board.set(row, sb.toString());

                //backtrack
                solve(col + 1, board, ans, n);

                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
            }
        }
    }

    private boolean isPossible(List<String> board, int row, int col) {
        int rowCounter = row;
        int colCounter = col;
        //check left row
        while (colCounter >= 0) {
            if (board.get(rowCounter).charAt(colCounter--) == 'Q') return false;
        }
        colCounter = col;
        //check upper diagonal
        while (colCounter >= 0 && rowCounter >= 0) {
            if (board.get(rowCounter).charAt(colCounter) == 'Q') return false;
            rowCounter--;
            colCounter--;
        }
        //check lower diagonal
        colCounter = col;
        rowCounter = row;
        while (colCounter >= 0 && rowCounter < board.size()) {
            if (board.get(rowCounter).charAt(colCounter) == 'Q') return false;
            rowCounter++;
            colCounter--;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> ans = new NQueens().solveNQueens(n);
        for (List<String> ele : ans) {
            ele.forEach(str -> System.out.print(str + " "));
            System.out.println(" ");
        }
    }
}
