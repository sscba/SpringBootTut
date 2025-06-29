package com.striver.dsa.arrays;

import java.util.*;

public class Sum4 {

    public List<List<Integer>> striverSolution(int[] nums, int target) {
        int n = nums.length; // size of the array
        Set<List<Integer>> st = new HashSet<>();

        // checking all possible quadruplets:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    // taking bigger data type
                    // to avoid integer overflow:
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long fourth = target - sum;
                    if (hashset.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int) fourth);
                        temp.sort(Integer::compareTo);
                        st.add(temp);
                    }
                    // put the kth element into the hashset:
                    hashset.add((long) nums[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }

    public List<List<Integer>> optimal(int[] nums, int target){
        int n = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            for(int j=i+1;j<n;j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                int k = j+1;
                int l = n-1;

                while(k<l){
                    long sum =(long) nums[i] + nums[j];
                    sum+=nums[k];
                    sum+= nums[l];

                    if(sum<target){
                        k++;
                    }else if(sum>target){
                        l--;
                    }else{
                        res.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        l--;

                        while(nums[k] == nums[k-1] && k<l){
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }

                }
            }
        }
        return new ArrayList<>(res);
    }


    public List<List<Integer>> solve(int[] nums, int target){
        int n = nums.length;
        Set<List<Integer>> res = new HashSet<>();

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Set<Long> fourthElementSet= new HashSet<>();
                for(int k=j+1;k<n;k++){
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long fourth = target - sum;

                    if(fourthElementSet.contains(fourth)){
                        List<Integer> ansList = Arrays.asList(nums[i],nums[j],nums[k],(int) fourth);
                        Collections.sort(ansList);
                        res.add(ansList);
                    }
                    fourthElementSet.add((long) nums[k]);
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        int[] arr = {1000000000,1000000000,1000000000,1000000000};
//        int[] arr = {1,0,-2,-1,2,0};
        Sum4 sum4 = new Sum4();
        List<List<Integer>> ans = sum4.optimal(arr,-294967296);

        System.out.println("Print ans array");

        for(List<Integer> set : ans){
            for(int ele: set){
                System.out.print(ele + " ");
            }
            System.out.println(" ");
        }
        System.out.println("Printed ans array");
    }
}
