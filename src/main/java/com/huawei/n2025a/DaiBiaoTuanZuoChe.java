package com.huawei.n2025a;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/29 15:30
 */
public class DaiBiaoTuanZuoChe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int total = scanner.nextInt();

        Arrays.sort(nums);

        int[] dp = new int[total + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            int last = total - nums[i];
            for (int j = last; j >= 0; j--) {
                //sum = (j+num[i])
                //和当前数字j组合得到数字sum的组合数 = 组成j数字的组合数 + 已经通过其他数字组成sum的方式
                dp[j + nums[i]] = dp[j] + dp[j + nums[i]];
            }
        }
        System.out.println(dp[total]);

        /*int[][] dp = new int[nums.length + 1][total + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = total; j > 0; j--) {
                int a = j >= nums[i - 1] ? dp[i - 1][j - nums[i - 1]] + 1 : dp[i - 1][j];
                dp[i][j] = Math.max(a, dp[i - 1][j]);
            }
        }
        System.out.println(dp[nums.length][total]);*/
    }
}
