package com.striver.dsa.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {

    public List<Integer> sprialTraversal(int[][] mat){
        List<Integer> res = new ArrayList<>();
        int topRow = 0;
        int leftCol = 0;
        int rightCol = mat[0].length-1;
        int bottomRow = mat.length -1;

        while(topRow <= bottomRow && leftCol <= rightCol){

            //move right
            for(int col=leftCol;col<=rightCol;col++){
                res.add(mat[topRow][col]);
            }
            topRow++;

            //move down
            for(int row=topRow;row<=bottomRow;row++){
                res.add(mat[row][rightCol]);
            }
            rightCol--;

            //move left
            if(topRow <= bottomRow){
                for(int col=rightCol;col>=leftCol;col--){
                    res.add(mat[bottomRow][col]);
                }
                bottomRow--;
            }


            //move up
            if(leftCol <= rightCol){
                for(int row=bottomRow;row>=topRow;row--){
                    res.add(mat[row][leftCol]);
                }
                leftCol++;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        SpiralTraversal traversal = new SpiralTraversal();
        List<Integer> lt =  traversal.sprialTraversal(nums);
        System.out.println(" ");
        for(int ilt : lt){
            System.out.print(ilt + " ");
        }
        System.out.println(" ");

    }
}
