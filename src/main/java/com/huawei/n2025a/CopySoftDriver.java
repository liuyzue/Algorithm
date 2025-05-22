package com.huawei.n2025a;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/27 23:11
 */
public class CopySoftDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] soft = new int[n];
        int[] block = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < soft.length; i++) {
            int b = scanner.nextInt();
            soft[i] = b;
            block[i] = b / 512 + (b % 512 > 0 ? 1 : 0);
            min = Math.min(block[i],min);
        }
        int total = 1474560 / 512;
        int[][] dp = new int[n + 1][total + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = min; j < total + 1; j++) {
                dp[i][j] = Math.max(j >= block[i - 1] ? dp[i - 1][j - block[i - 1]] + soft[i - 1] : dp[i - 1][j], dp[i - 1][j]);
            }
        }
        System.out.println(dp[n][total]);
    }
}
