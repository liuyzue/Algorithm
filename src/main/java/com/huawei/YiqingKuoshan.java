package com.huawei;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/17 14:11
 */
public class YiqingKuoshan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        int exp = (int) Math.sqrt(split.length);
        if (exp == 0) {
            System.out.println(-1);
            return;
        }
        int[][] dp = new int[exp][exp];
        int safe = 0;
        for (int i = 0; i < split.length; i++) {
            int state = Integer.parseInt(split[i]);
            if (state == 0) safe++;
            dp[i / exp][i % exp] = state;
        }
        if (safe == 0 || safe == split.length) {
            System.out.println(-1);
            return;
        }
        int time = 0;
        while (safe > 0) {
            time++;
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    if (dp[i][j] == time) {
                        if (i - 1 >= 0 && dp [i - 1][j] == 0) {
                            dp[i - 1][j] = dp[i][j] + 1;
                            safe--;
                        }
                        if (j - 1 >= 0 && dp[i][j - 1] == 0) {
                            dp[i][j - 1] = dp[i][j] + 1;
                            safe--;
                        }
                        if (i + 1 < dp[i].length && dp[i + 1][j] == 0) {
                            dp[i + 1][j] = dp[i][j] + 1;
                            safe--;
                        }
                        if (j + 1 < dp[i].length && dp[i][j + 1] == 0) {
                            dp[i][j + 1] = dp[i][j] + 1;
                            safe--;
                        }
                    }
                }
            }
        }
        System.out.println(time);
    }
}
