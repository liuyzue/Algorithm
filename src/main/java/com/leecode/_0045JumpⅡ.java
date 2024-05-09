package com.leecode;

import java.util.Arrays;

public class _0045JumpⅡ {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
             for (int j = 0; j < i; j++) {
                 if (j + nums[j] >= i) {
                     dp[i] = Math.min(dp[i], dp[j] + 1);
                 }
             }
        }
        return dp[n - 1];
    }

    public int jump1(int[] nums) {
        int n = nums.length;
        int end = 0;
        int step = 0;
        int farthest = 0;
        for (int i = 0; i < n - 1 ; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                end = farthest;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new _0045JumpⅡ().jump1(new int[]{2,3,1,1,4}));
    }
}
