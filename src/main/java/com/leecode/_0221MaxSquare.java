package com.leecode;

/**
 * @author liuyuze
 * @date 2025/4/8 13:58
 */
public class _0221MaxSquare {
    public static void main(String[] args) {

        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] matrix1 = {{'0','1'},{'1','0'}};
        System.out.println(maximalSquare1(matrix));
    }

    public static int maximalSquare(char[][] matrix) {

        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int area = 1;
                int large = Math.min(matrix.length - i,matrix[i].length - j);
                for (int k = 0; k < large; k++) {
                    boolean hasZero = false;
                    for (int l = 0; l <= k; l++) {
                        for (int m = 0; m <= k; m++) {
                            if (matrix[i + l][j + m] == '0'){
                                hasZero = true;
                                break;
                            }
                        }
                        if (hasZero) {
                            break;
                        }
                    }
                    if (!hasZero) {
                        area = (k + 1) * (k + 1);
                        maxArea = Math.max(maxArea,area);
                    }
                }
            }
        }
        return maxArea;

    }

    public static int maximalSquare1(char[][] matrix) {

        int maxLength = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                if (i < 1 || j < 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j],Math.min(dp[i - 1][j - 1],dp[i][j - 1])) + 1;
                }
                maxLength = Math.max(dp[i][j], maxLength);
            }
        }

        return maxLength * maxLength;

    }
}
