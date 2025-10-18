package com.striver.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class RatMaze {

    public static List<String> findPath(int[][] maze, int n){
        List<String> ans = new ArrayList<>();
        boolean[][] vis = new boolean[n][n];
        if(maze[0][0] == 1){
            solve(0,0,maze,n,ans,vis,new StringBuilder());
        }
        return ans;
    }

    private static void solve(int row,int col, int[][] maze, int n, List<String> ans, boolean[][] vis,StringBuilder sb){
        //base case
        if(row == n-1 && col == n-1){
            ans.add(sb.toString());
            return;
        }
        //down
        if(row+1<n && !vis[row+1][col] && maze[row+1][col] == 1){
            vis[row][col] = true;
            sb.append('D');
            solve(row+1,col,maze,n,ans,vis,sb);
            sb.deleteCharAt(sb.length()-1);
            vis[row][col] = false;
        }
        //left
        if(col-1>=0 && !vis[row][col-1] && maze[row][col-1] == 1){
            vis[row][col] = true;
            sb.append('L');
            solve(row,col-1,maze,n,ans,vis,sb);
            sb.deleteCharAt(sb.length()-1);
            vis[row][col] = false;
        }
        //right
        if(col+1<n && !vis[row][col+1] && maze[row][col+1] == 1){
            vis[row][col] = true;
            sb.append('R');
            solve(row,col+1,maze,n,ans,vis,sb);
            sb.deleteCharAt(sb.length()-1);
            vis[row][col] = false;
        }
        //up
        if(row-1>=0 && !vis[row-1][col] && maze[row-1][col] == 1){
            vis[row][col] = true;
            sb.append('U');
            solve(row-1,col,maze,n,ans,vis,sb);
            sb.deleteCharAt(sb.length()-1);
            vis[row][col] = false;
        }
    }

    public static void main(String[] args) {
        int[][] maze = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
        List<String> ans = findPath(maze, maze.length);
        for(String str: ans){
            System.out.println(str+" ");
        }
    }
}
