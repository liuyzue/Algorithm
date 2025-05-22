package com.huawei;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/22 20:45
 */
public class Jump3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        int[] dp = new int[n + 1];
        dp[0] = score[0];

        for (int i = 1; i < n; i++) {
            int max = Integer.MIN_VALUE;
            int pre = Math.max(i - k, 0);
            for (int j = pre; j < i; j++) {
                max = Math.max(dp[j] + score[i], max);
            }
            dp[i] = max;
        }

        System.out.println(dp[n - 1]);

    }
}
