package com.huawei;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/13 17:25
 */
public class MaxPay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalTime = scanner.nextInt();
        int jobNum = scanner.nextInt();
        int[] cost = new int[jobNum];
        int[] pay = new int[jobNum];
        for (int i = 0; i < jobNum; i++) {
            cost[i] = scanner.nextInt();
            pay[i] = scanner.nextInt();
        }
        int[][] dp = new int[jobNum + 1][totalTime + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int last = dp[i - 1][j];
                int cur = cost[i - 1] > j ? 0 : pay[i - 1] + dp[i - 1][j - cost[i - 1]];
                dp[i][j] = Math.max(last,cur);
            }
        }
        System.out.println(dp[jobNum][totalTime]);
    }
}