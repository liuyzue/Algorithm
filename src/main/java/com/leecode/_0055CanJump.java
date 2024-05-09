package com.leecode;

public class _0055CanJump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 0) return false;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (!dp[i]) {
                return false;
            }
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j >= n - 1) return true;
                dp[i + j] = true;
            }
        }
        return dp[n - 1];
    }

    public boolean canJump1(int[] nums) {
        int n = nums.length;
        if (n == 0) return false;
        int farthest = 0;
        for (int i = 0; i < n; i++) {
            if (farthest < i) return false;
            farthest = Math.max(farthest, nums[i] + i);
            if (farthest >= n - 1) return true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _0055CanJump().canJump1(new int[]{3, 2, 1, 0, 1}));
    }
}
