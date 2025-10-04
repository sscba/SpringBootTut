package com.striver.dsa.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElementI {

    //Brute Force - Two loops
    public static int[] bruteForce(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[n1];
        Arrays.fill(ans, -1);
        for(int i=0; i<n1; i++){
            int matchElementIndx = -1;
            for(int j=0; j<n2; j++){
                if(nums1[i] == nums2[j]){
                    matchElementIndx = j;
                    break;
                }
            }
            if(matchElementIndx != -1){
                int k = matchElementIndx+1;
                while(k<n2){
                    if(nums1[i] < nums2[k]){
                        ans[i] = nums2[k];
                        break;
                    }
                    k++;
                }
            }
        }
        return ans;
    }

    public static int[] optimal(int[] nums1, int[] nums2){
        int n1= nums1.length;
        int n2 = nums2.length;
        int[] nextGreatermp = new int[10001];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i=n2-1; i>=0; i--){
            while(!st.isEmpty() && st.peek() <= nums2[i]){
                st.pop();
            }
            if(st.isEmpty()) nextGreatermp[nums2[i]] = -1;
            else{
                nextGreatermp[nums2[i]] = st.peek();
            }
            st.push(nums2[i]);
        }
        for(int i=0; i<n1; i++){
            nums1[i] = nextGreatermp[nums1[i]];
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] ans = optimal(nums1,nums2);
        for(int ele: ans){
            System.out.print(ele +" ");
        }
    }
}
