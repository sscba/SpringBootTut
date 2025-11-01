package com.striver.dsa.slidingwindow;

public class CardScore {

    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sumFromFront=0;
        int sumFromLast=0;
        int maxSum=0;
        for(int i=0; i<k; i++){
            sumFromFront+=cardPoints[i];
        }
        maxSum=sumFromFront;
        int rightInd=n-1;
        for(int i=k-1; i>=0 ;i--){
            sumFromFront -= cardPoints[i];
            sumFromLast += cardPoints[rightInd--];
            maxSum = Math.max(maxSum, sumFromFront+sumFromLast);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] cardPoints = {9,7,7,9,7,7,9};
        int k = 7;
        System.out.println(maxScore(cardPoints,k));
    }
}
