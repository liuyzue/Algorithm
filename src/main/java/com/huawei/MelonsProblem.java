package com.huawei;

import java.util.*;

/**
 * @author liuyuze
 * @date 2025/3/22 22:09
 */
public class MelonsProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> stones = new ArrayList<>();
        int total = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int stone = scanner.nextInt();
            stones.add(stone);
            total += stone;
            min = Math.min(min,stone);
        }
        if (total % 2 == 1) {
            System.out.println(-1);
            return;
        }
        int[] dp = new int[total / 2 + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (Integer stone : stones) {
            for (int i = dp.length - 1; i >= stone; i--) {
                dp[i] = Math.min(dp[i], dp[i - stone] + 1);
            }
        }
        if (dp[total / 2] == n) {
            System.out.println(-1);
        } else {
            System.out.println(dp[total / 2]);
        }
    }
}
