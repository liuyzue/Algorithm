package com.leecode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.LongStream;

public class _3261CountSubstringsThatSatisfyK_ConstraintII {

    /**
     * 给你一个 二进制 字符串 s 和一个整数 k。
     *
     * 另给你一个二维整数数组 queries ，其中 queries[i] = [li, ri] 。
     *
     * 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
     *
     * 字符串中 0 的数量最多为 k。
     * 字符串中 1 的数量最多为 k。
     * 返回一个整数数组 answer ，其中 answer[i] 表示 s[li..ri] 中满足 k 约束 的
     * 子字符串
     *  的数量。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "0001111", k = 2, queries = [[0,6]]
     *
     * 输出：[26]
     *
     * 解释：
     *
     * 对于查询 [0, 6]， s[0..6] = "0001111" 的所有子字符串中，除 s[0..5] = "000111" 和 s[0..6] = "0001111" 外，其余子字符串都满足 k 约束。
     *
     * 示例 2：
     *
     * 输入：s = "010101", k = 1, queries = [[0,5],[1,4],[2,3]]
     *
     * 输出：[15,9,3]
     *
     * 解释：
     *
     * s 的所有子字符串中，长度大于 3 的子字符串都不满足 k 约束。
     *
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 105
     * s[i] 是 '0' 或 '1'
     * 1 <= k <= s.length
     * 1 <= queries.length <= 105
     * queries[i] == [li, ri]
     * 0 <= li <= ri < s.length
     * 所有查询互不相同
     */
    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        int n = s.length();
        long[] res = new long[queries.length];
        int[] count = new int[2];
        int[] rights = new int[n];
        Arrays.fill(rights,n);
        long[] prefix = new long[n + 1];
        for (int i = 0,j = 0; j < n; j++) {
            count[s.charAt(j) - '0']++;
            while (count[0] > k && count[1] > k) {
                count[s.charAt(i) - '0']--;
                rights[i] = j;
                i++;
            }
            prefix[j + 1] = prefix[j] + j - i + 1;
        }
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int right = Math.min(rights[l], r + 1);
            long part1 = (long) (right - l + 1) * (right - l) / 2;
            long part2 = prefix[r + 1] - prefix[right];
            res[i] = part1 + part2;
        }

        return res;
    }

    public long[] countKConstraintSubstrings1(String s, int k, int[][] queries) {
        int n = s.length();
        int[] count = new int[2];
        int[] right = new int[n];
        Arrays.fill(right, n);
        long[] prefix = new long[n + 1];
        for (int i = 0, j = 0; j < n; ++j) {
            count[s.charAt(j) - '0']++;
            while (count[0] > k && count[1] > k) {
                count[s.charAt(i) - '0']--;
                right[i] = j;
                i++;
            }
            prefix[j + 1] = prefix[j] + j - i + 1;
        }

        long[] res = new long[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int l = queries[q][0], r = queries[q][1];
            int i = Math.min(right[l], r + 1);
            long part1 = (long) (i - l + 1) * (i - l) / 2;
            long part2 = prefix[r + 1] - prefix[i];
            res[q] = part1 + part2;
        }
        return res;
    }

    public static void main(String[] args) {
        _3261CountSubstringsThatSatisfyK_ConstraintII countSubstringsThatSatisfyKConstraintII = new _3261CountSubstringsThatSatisfyK_ConstraintII();
        long[] longs = countSubstringsThatSatisfyKConstraintII.countKConstraintSubstrings("001110001", 3, new int[][]{{0,8},{1,8},{4,8}});
        Arrays.stream(longs).forEach(System.out::println);
        longs = countSubstringsThatSatisfyKConstraintII.countKConstraintSubstrings1("001110001", 3, new int[][]{{0,8},{1,8},{4,8}});
        Arrays.stream(longs).forEach(System.out::println);
    }


}
