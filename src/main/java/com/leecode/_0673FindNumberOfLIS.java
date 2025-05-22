package com.leecode;

import java.util.Arrays;

/**
 * @author liuyuze
 * @date 2025/4/9 15:59
 */
public class _0673FindNumberOfLIS {

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(findNumberOfLIS(nums));
    }
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int num = 0;
        int maxLength = 1;
        int maxIndex = 0;

        int[] dp = new int[n];
        int[] counts = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    if (dp[j - 1] + 1 == dp[j]) {
                        counts[j] += 1;
                    } else {
                        dp[j] = dp[j - 1] + 1;
                    }
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                if (dp[j] > maxLength) {
                    maxLength = dp[j];
                    maxIndex = j;
                }
            }
        }

        return counts[maxIndex];
    }
}
