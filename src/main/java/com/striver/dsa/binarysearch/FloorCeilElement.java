package com.striver.dsa.binarysearch;

public class FloorCeilElement {

    private int getFloorElement(int[] nums,int target){
        int ans = -1;

        int low =0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] <= target){
                ans = nums[mid];
                //move toward high
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }

        return ans;
    }
    private int getCeilElement(int[] nums,int target){
        int ans = -1;

        int low =0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] >= target){
                ans = nums[mid];
                //move toward low
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public int[] solve(int[] nums,int target){
        int[] ans = {-1,-1};

        int floor = getFloorElement(nums,target);
        int ceil = getCeilElement(nums,target);

        ans[0] = floor;
        ans[1] = ceil;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,5,5,9,10};
        int[] ans = new FloorCeilElement().solve(arr,10);

        System.out.println("floor "+ ans[0] + " ceil "+ ans[1]);

    }
}
