package com.striver.dsa.recursion;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        int index = 0;
        //linear search to find first char of word in board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(index)) {
                    if (searchNext(board,word,i,j,index,rows,cols))
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean searchNext(char[][] board, String word, int row, int col, int index, int m, int n) {
        //base case
        if (index == word.length()) return true;
        //negative cases
        if (row < 0 || col < 0 || row == m || col == n
                || board[row][col] != word.charAt(index)
                || board[row][col] == '1')
            return false;
        //backtracking
        char c = board[row][col];
        board[row][col] = '!';
        boolean top = searchNext(board, word, row - 1, col, index + 1, m, n);
        boolean bottom = searchNext(board, word, row + 1, col, index + 1, m, n);
        boolean right = searchNext(board, word, row, col + 1, index + 1, m, n);
        boolean left = searchNext(board, word, row, col - 1, index + 1, m, n);
        board[row][col] = c;
        return top || bottom || right || left;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board,"ABCCEE"));
    }
}
