package com.striver.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperator {

    /*Time Complexity: O(4^n), since in each recursive call, we can choose 4 possibilities
    for each substring (three operators: +, -, *, or no operator in the case of the first number),
    resulting in an exponential time complexity with a branching factor of 4.
    Space Complexity: O(n), since the space complexity is dominated by the recursion depth,
     which can go as deep as the length of the string. Additionally, we store the result expressions in a list,
     but this doesn't increase the space complexity beyond the recursion stack and the input size.
    */
    public List<String> addOperators(String nums, int target) {
        List<String> ans = new ArrayList<>();
        solve(nums, target, 0, 0, 0, "", ans);
        return ans;
    }

    private void solve(String nums, int target, int start, long currentValue, long lastOperand, String expr, List<String> ans) {
        //base case
        if (nums.length() == start) {
            if (target == currentValue) {
                ans.add(expr);
            }
            return;
        }
        for (int i = start; i < nums.length(); i++) {
            if (i > start && nums.charAt(start) == '0') return;
            String currentNum = nums.substring(start, i + 1);
            long currentNumVal = Long.parseLong(currentNum);
            if (start == 0) {
                solve(nums, target, i + 1, currentNumVal, currentNumVal, currentNum, ans);
            } else {
                solve(nums, target, i + 1, currentValue + currentNumVal, currentNumVal, expr + '+' + currentNum, ans);
                solve(nums, target, i + 1, currentValue - currentNumVal, -currentNumVal, expr + '-' + currentNum, ans);
                solve(nums, target, i + 1, currentValue - lastOperand + lastOperand * currentNumVal, lastOperand * currentNumVal, expr + '*' + currentNum, ans);
            }
        }
    }

    public static void main(String[] args) {
        String nums = "232";
        int target = 8;
        List<String> ans = new ExpressionAddOperator().addOperators(nums, target);
        for (String ele : ans) {
            System.out.print(ele + " ");
        }
    }
}
