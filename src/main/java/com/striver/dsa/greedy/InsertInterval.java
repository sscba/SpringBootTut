package com.striver.dsa.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(List.of(intervals[i][0], intervals[i][1]));
            i++;
        }
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(List.of(newInterval[0], newInterval[1]));
        while (i < n) {
            res.add(List.of(intervals[i][0], intervals[i][1]));
            i++;
        }
        return res.stream()
                .map(inner -> inner.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] ans = insert(arr, newInterval);
        for (int[] list : ans) {
            System.out.println("["+ list[0] + ", "+ list[1]+"]");
        }
    }
}
