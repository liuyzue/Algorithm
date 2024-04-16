package com.leecode;

public class _0080RemoveDuplicates {
    public int removeDuplicates(int[] nums) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[res++] = nums[i];
            if (i < nums.length - 2 && nums[i] == nums[i + 2]) {
                res--;
            }
        }
        return res;
    }
}
