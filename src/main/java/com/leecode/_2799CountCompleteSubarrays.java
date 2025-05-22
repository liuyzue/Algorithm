package com.leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author liuyuze
 * @date 2025/4/24 10:21
 */
public class _2799CountCompleteSubarrays {

    public static void main(String[] args) {
        System.out.println(countCompleteSubarrays(new int[] {459,459,962,1579,1435,756,1872,1597}));
        System.out.println(countCompleteSubarrays(new int[] {1,3,1,2,2}));
        System.out.println(countCompleteSubarrays(new int[] {5,5,5,5}));
    }

    public static int countCompleteSubarrays(int[] nums) {
        int result = 0;
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }
        int left = 0;
        int right = -1;
        Map<Integer,Integer> hasMap = new HashMap<>();
        while (left < nums.length && right < nums.length) {
            if (hasMap.size() == numMap.size()) {
                result += nums.length - right;
                Integer count = hasMap.get(nums[left]);
                if (count - 1 == 0) {
                    hasMap.remove(nums[left]);
                } else {
                    hasMap.put(nums[left], count - 1);
                }
                left++;
            } else {
                right++;
                if (right < nums.length) {
                    hasMap.put(nums[right], hasMap.getOrDefault(nums[right], 0) + 1);
                }
            }
        }
        return result;
    }
}
