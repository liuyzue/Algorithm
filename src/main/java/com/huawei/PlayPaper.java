package com.huawei;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/24 20:16
 */
public class PlayPaper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        int[] papers = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            papers[i] = Integer.parseInt(split[i]);
        }
        int[] dp = new int[papers.length + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max( i > 3 ? dp[i - 3] : 0 , dp[i - 1] + papers[i - 1]);
        }
        System.out.println(dp[papers.length]);
    }
}
