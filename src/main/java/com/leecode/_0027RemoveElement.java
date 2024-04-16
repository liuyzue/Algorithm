package com.leecode;

public class _0027RemoveElement {

    public int removeElement(int[] nums, int val) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[res] = nums[i];
            if (nums[i] != val) {
                res++;
            }
        }
        return res;
    }
}
