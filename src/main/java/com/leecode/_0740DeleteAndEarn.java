package com.leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _0740DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] sum = new int[max + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        int[] dp = new int[max + 1];
        dp[0] = 0;dp[1] = sum[1];
        int res = dp[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + sum[i],dp[i - 1]);
            res = Math.max(res, dp[i]);
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(i + ":" + dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _0740DeleteAndEarn().deleteAndEarn(new int[]{8,10,4,9,1,3,5,9,4,10}));
    }
}
