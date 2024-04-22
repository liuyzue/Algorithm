package com.leecode;

import java.util.*;
import java.util.stream.Collectors;

public class _0377CombinationSum4 {

    Map<Integer, Integer> resultMap = new HashMap<>();

    Set<Integer> set = new HashSet<>();

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new _0377CombinationSum4().combinationSum4(new int[]{1,2,3},49));
    }
}
