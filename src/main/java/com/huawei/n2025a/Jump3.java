package com.huawei.n2025a;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/28 21:02
 */
public class Jump3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] score = new int[n];
        for (int i = 0; i < score.length; i++) {
            score[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int[] dp = new int[n];
        dp[0] = score[0];
        for (int i = 1; i < n; i++) {
            int last = Integer.MIN_VALUE;
            for (int j = 1; j <= k; j++) {
                last = Math.max(last, dp[Math.max(i - j,0)]);
            }
            dp[i] = last + score[i];
        }
        System.out.println(dp[n - 1]);
    }
}
