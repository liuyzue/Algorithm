package com.huawei;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/17 15:44
 */
public class CopySoftDriver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 1474560;
        int block = 512;
        int totalBlock = total / block;
        int num = scanner.nextInt();
        int[] memory = new int[num];
        int[] useBlock = new int[num];
        for (int i = 0; i < num; i++) {
            memory[i] = scanner.nextInt();
            useBlock[i] = (memory[i] / block) + (memory[i] % block > 0 ? 1 : 0);
        }
        int[][] dp = new int[num + 1][totalBlock + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int last = dp[i - 1][j];
                int curr = j >= useBlock[i-1] ? dp[i - 1][j - useBlock[i-1]] + memory[i-1] : dp[i][j];
                dp[i][j] = Math.max(last,curr);
            }
        }
        System.out.println(dp[num][totalBlock]);


    }
}
