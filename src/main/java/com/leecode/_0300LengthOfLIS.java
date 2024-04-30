package com.leecode;

public class _0300LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int maxLen = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new _0300LengthOfLIS().lengthOfLIS(new int[]{7}));
    }
}
