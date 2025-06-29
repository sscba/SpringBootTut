package com.striver.dsa.arrays;

import java.util.*;

public class Sum3 {


    public List<List<Integer>> optimal(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];

                if (total > 0) {
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    while (nums[j] == nums[j-1] && j < k) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return res;

    }

    public List<List<Integer>> solve(int[] nums){
        Set<List<Integer>> resultSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> temp = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int sum = -(nums[i] + nums[j]);
                if (temp.contains(sum)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], sum);
                    Collections.sort(triplet); // sort to avoid duplicates in different order
                    resultSet.add(triplet);
                }
                temp.add(nums[j]);
            }
        }

        return new ArrayList<>(resultSet);
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        Sum3 sum3 = new Sum3();
        sum3.optimal(arr);

    }
}
