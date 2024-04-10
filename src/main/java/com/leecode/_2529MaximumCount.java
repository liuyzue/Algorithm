package com.leecode;

public class _2529MaximumCount {

    static int pos = 0,neg = 0;

    public static int maximumCount(int[] nums) {
        binarySearch(nums,0,nums.length - 1);
        return Math.max(pos,neg);
    }

    public static void binarySearch(int[] nums, int left, int right) {
        if (left != right) {
            int mid = (left + right) / 2;
            binarySearch(nums, left, mid);
            binarySearch(nums, mid + 1, right);
        } else {
            if (nums[left] > 0) {
                pos++;
            }
            if (nums[left] < 0) {
                neg++;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {-1,2,-3,4,-5,6,-7,8,-9,-1,1,1,-1,1,-1,1,1,1,1};
        System.out.println(maximumCount(nums));
    }
}
