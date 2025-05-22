package com.huawei.n2025a;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/30 9:56
 */
public class LongestSubStr {
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();

        String maxSubStr = "";
        int count = 0;
        int flag1 = 0;
        int flag2 = 0;

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            for (int j = 0; j < s2.length(); j++) {
                if (s2.charAt(j) != c) {
                    continue;
                }
                flag1 = i;
                flag2 = j;
                while (flag1 < s1.length() && flag2 < s2.length() && s1.charAt(flag1) == s2.charAt(flag2)) {
                    count++;
                    flag1++;
                    flag2++;
                }
                if (count > maxSubStr.length()){
                    maxSubStr = s1.substring(i,flag1);
                }
                count = 0;

            }
        }
        System.out.println(maxSubStr);
    }*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int max = 0;
        int index = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        index = i;
                    }
                }
            }
        }
        System.out.println(s1.substring(index - max, index));
    }
}
