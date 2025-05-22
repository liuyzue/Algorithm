package com.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuyuze
 * @date 2025/4/22 23:54
 */
public class _0539FindMinDifference {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("00:00");
        list.add("23:59");
        list.add("22:00");
        list.add("01:22");
        System.out.println(findMinDifference(list));
    }

    public static int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;
        int[] nums = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String s = timePoints.get(i);
            String[] split = s.split(":");
            nums[i] = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int sub = 0;
            if (i == 0) {
                sub = (24 * 60) - nums[nums.length - 1] + nums[0];
            } else {
                sub = nums[i] - nums[i - 1];
            }
            min = Math.min(min,sub);
        }
        return min;
    }
}
