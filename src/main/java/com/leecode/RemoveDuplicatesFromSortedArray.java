package com.leecode;

/**
 * @author liuyz 2020年09月28日
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums){
        int flag = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[flag]){
                continue;
            }
            flag++;
            nums[flag] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+"   ");
        }

        return flag;
    }
}
