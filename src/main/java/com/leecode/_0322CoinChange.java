package com.leecode;

import java.util.Arrays;

public class _0322CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    min = Math.min(min, dp[i - coin] + 1);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new _0322CoinChange().coinChange(new int[]{186,419,83,408}, 6249));
    }
}
