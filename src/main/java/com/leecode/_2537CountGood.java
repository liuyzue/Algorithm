package com.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyuze
 * @date 2025/4/16 14:24
 */
public class _2537CountGood {

    public static void main(String[] args) {
        System.out.println(countGood1(new int[]{3, 1, 4, 3, 2, 2, 4}, 2));
        // System.out.println(countGood1(new int[]{1,1,1,1,1}, 10));
    }


    //超时
    public static long countGood(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                Integer num = map.getOrDefault(nums[j], 0);
                sum = sum + num;
                map.put(nums[j], num + 1);
                if (sum >= k) {
                    result += nums.length - j;
                    break;
                }
            }
        }
        return result;
    }

    public static long countGood1(int[] nums, int k) {
        int result = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = -1;
        int sum = 0;
        while (left < n) {
            while (right + 1 < n && sum < k) {
                ++right;
                Integer num = map.getOrDefault(nums[right], 0);
                sum += num;
                map.put(nums[right], num + 1);
            }
            if (sum >= k) {
                result += n - right;
            }
            Integer num = map.get(nums[left]);
            sum -= (num - 1);
            map.put(nums[left], num - 1);
            left++;
        }

        return result;
    }
}
