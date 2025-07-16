package com.striver.dsa.binarysearch;

public class SortedArraysMedian {

    public double optimal(int[] nums1,int[] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2) return optimal(nums2,nums1);

        int low=0;
        int high=n1;
        int left = (n1+n2+1)/2;
        int n = n1+n2;
        while(low<=high){
            int mid1 = (low+high)/2;
            int mid2 = left - mid1;

            //initialise l1,l2,r1,r2
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 < n1) r1 = nums1[mid1];
            if(mid2 < n2) r2 = nums2[mid2];
            if(mid1-1 >= 0) l1 = nums1[mid1-1];
            if(mid2-1 >= 0) l2 = nums2[mid2-1];

            //binary search logic
            if(l1 <= r2 && l2 <= r1){
                //even
                if(n%2 == 0){
                    return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
                //odd
                return Math.max(l1,l2);
            }

            else if(l1 > r2) high = mid1-1;
            else low = mid1 + 1;
        }
        return 0;
    }

    public double betterSolution(int[] nums1,int[] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        int ind2 = n/2;
        int ind1 = ind2 -1;
        int indx = 0;
        int ele1 =-1;
        int ele2 =-1;
        int i=0;
        int j=0;

        while(i<n1 && j<n2){
            if(nums1[i] <= nums2[j]){
                if(indx == ind1) ele1 = nums1[i];
                if(indx == ind2) ele2 = nums1[i];
                indx++;
                i++;
            }else{
                if(indx == ind1) ele1 = nums2[j];
                if(indx == ind2) ele2 = nums2[j];
                indx++;
                j++;
            }
        }

        while(i<n1){
            if(indx == ind1) ele1 = nums1[i];
            if(indx == ind2) ele2 = nums1[i];
            indx++;
            i++;
        }
        while(j<n2){
            if(indx == ind1) ele1 = nums2[j];
            if(indx == ind2) ele2 = nums2[j];
            indx++;
            j++;
        }

        //check odd or even
        if(n%2==0){
            return ((double)(ele1+ele2)/2.0);
        }
        else{
            return ele2;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,5,7,8,11,32};
        int[] arr2 = {4,6,12,18,21,35,41,43};

        double ans = new SortedArraysMedian().optimal(arr1,arr2);
        System.out.println(ans);

    }
}
