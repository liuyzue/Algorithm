package com.leecode;

import java.util.Arrays;

/**
 * @author liuyuze
 * @date 2025/4/8 16:02
 */
public class _0516LongestPalindromeSubseq {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq1("a"));
    }

    public static int longestPalindromeSubseq(String s) {
        if (s.length() == 1) {
            return 1;
        }
        char[] chars = s.toCharArray();
        int[][] dp = new int[s.length()][s.length()];
        for (int i = chars.length - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }


    //aaaababbbccbbcc
    public static int longestPalindromeSubseq1(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s.charAt(i - 1) == reverse.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }
}
