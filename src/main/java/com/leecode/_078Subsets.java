package com.leecode;

import java.util.ArrayList;
import java.util.List;

public class _078Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        for (int index = 0;index < (1 << length); index++) {
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0;i < nums.length; i++) {
                int check = index & (1 << i);
                if (check != 0) {
                    tempList.add(nums[i]);
                }
            }
            result.add(tempList);
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        subsets(new int[]{1,5,2,3,4});
    }
}
