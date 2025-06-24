package com.striver.dsa.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSubArray {

    //Approach 2 - hashset and checking by increment and decrementing element if its contained in set or not
    public int findLongestSubsequenceByHashset(int[] nums){
        int n = nums.length;
        int maxSubsequence = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        for(int i=0; i< n;i++){
            int sequence = 0;

            int num = nums[i];
            //checking left side on set or less than numbers
            while(set.contains(--num)){
                sequence++;
                set.remove(num);
            }

            //checking right side on set or greater than numbers
            while(set.contains(++num)){
                sequence++;
                set.remove(num);
            }

            maxSubsequence = Math.max(maxSubsequence,sequence);
        }
        return maxSubsequence;
    }

    //Approach 1 - sorting and then iterating to check diff in consecutive element is 1
    public int findLongestSubsequence(int[] nums){

        int n = nums.length;
        if(n==0){
            return 0;
        }

        int maxSubsequence = 0;
        int subsequnce = 1;

        Arrays.sort(nums);



        for(int i = 0;i < n-1;i++){
            if(nums[i+1] - nums[i] ==1 ){
                subsequnce++;
            }else if(nums[i] != nums[i+1]){
                maxSubsequence = Math.max(maxSubsequence,subsequnce);
                subsequnce=1;
            }
//            System.out.println("Index: "+ i + " subsequenceValue: "+ subsequnce+ " maxS: "+ maxSubsequence);
        }

        maxSubsequence = Math.max(maxSubsequence,subsequnce);

        return maxSubsequence;
    }

    public static void main(String[] args) {
//        int[] arr = {100,4,200,1,3,2};
//        int[] arr = {1,0,0,1,2,3,4,6};
        int[] arr = {};
        LongestConsecutiveSubArray subArray = new LongestConsecutiveSubArray();
        System.out.println(subArray.findLongestSubsequence(arr));
    }
}
