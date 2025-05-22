package com.leecode;

/**
 * @author liuyuze
 * @date 2025/4/8 11:51
 */
public class _0931MinFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int[][] matrix1 = {{2}};

        System.out.println(minFallingPathSum(matrix1));
    }

    public static int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix.length];
        dp[0] = matrix[0];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == matrix.length - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]),dp[i - 1][j + 1]);
                }
            }
        }
        for (int i : dp[matrix.length - 1]) {
            min = Math.min(min, i);
        }
        return min;
    }
}
