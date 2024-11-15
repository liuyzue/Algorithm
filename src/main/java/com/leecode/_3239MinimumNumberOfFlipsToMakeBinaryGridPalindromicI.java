package com.leecode;

public class _3239MinimumNumberOfFlipsToMakeBinaryGridPalindromicI {
    /**
     * 给你一个 m x n 的二进制矩阵 grid 。
     *
     * 如果矩阵中一行或者一列从前往后与从后往前读是一样的，那么我们称这一行或者这一列是 回文 的。
     *
     * 你可以将 grid 中任意格子的值 翻转 ，也就是将格子里的值从 0 变成 1 ，或者从 1 变成 0 。
     *
     * 请你返回 最少 翻转次数，使得矩阵 要么 所有行是 回文的 ，要么所有列是 回文的 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：grid = [[1,0,0],[0,0,0],[0,0,1]]
     *
     * 输出：2
     *
     * 解释：
     *
     *
     *
     * 将高亮的格子翻转，得到所有行都是回文的。
     *
     * 示例 2：
     *
     * 输入：grid = [[0,1],[0,1],[0,0]]
     *
     * 输出：1
     *
     * 解释：
     *
     *
     *
     * 将高亮的格子翻转，得到所有列都是回文的。
     *
     * 示例 3：
     *
     * 输入：grid = [[1],[0]]
     *
     * 输出：0
     *
     * 解释：
     *
     * 所有行已经是回文的。
     *
     *
     *
     * 提示：
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m * n <= 2 * 105
     * 0 <= grid[i][j] <= 1
     */
    public int minFlips(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int rowSum = 0;
        int culSum = 0;
        for (int i = 0; i < n; i++) {
            for (int s = 0, e = m - 1; s < e; s++ , e--) {
                if ((grid[i][s] ^ grid[i][e]) != 0) {
                    rowSum++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int s = 0, e = n - 1; s < e; s++ , e--) {
                if ((grid[s][i] ^ grid[e][i]) != 0) {
                    culSum++;
                }
            }
        }
        return Math.min(rowSum, culSum);
    }

    public static void main(String[] args) {
        System.out.println(new _3239MinimumNumberOfFlipsToMakeBinaryGridPalindromicI().minFlips(new int[][]{{1,0,0}, {0, 0,0},{0,0,1}}));
    }


}
