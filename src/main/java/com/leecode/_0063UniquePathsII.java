package com.leecode;

public class _0063UniquePathsII {

    /**
     * 给定一个 m x n 的整数数组 grid。一个机器人初始位于 左上角（即 grid[0][0]）。机器人尝试移动到 右下角（即 grid[m - 1][n - 1]）。机器人每次只能向下或者向右移动一步。
     *
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。
     *
     * 返回机器人能够到达右下角的不同路径数量。
     *
     * 测试用例保证答案小于等于 2 * 109。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
     * 输出：2
     * 解释：3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     * 示例 2：
     *
     *
     * 输入：obstacleGrid = [[0,1],[0,0]]
     * 输出：1
     *
     *
     * 提示：
     *
     * m == obstacleGrid.length
     * n == obstacleGrid[i].length
     * 1 <= m, n <= 100
     * obstacleGrid[i][j] 为 0 或 1
     * @param obstacleGrid
     * @return
     */

    //递归  超时
    /*public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return moveOneStep(obstacleGrid,0, 0);
    }

    int moveOneStep(int[][] obstacleGrid,int right,int down) {
        int m = obstacleGrid[0].length - 1;
        int n = obstacleGrid.length - 1;
        if (right > m || down > n || obstacleGrid[down][right] == 1) {
            return 0;
        }
        if (right == m && down == n) {
            return 1;
        }
        return moveOneStep(obstacleGrid,right + 1, down) + moveOneStep(obstacleGrid,right,down + 1);
    }*/

    //动态规划 + 二维数组
    /*public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                result[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                result[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    result[i][j] =  result[i - 1][j] +  result[i][j - 1];
                }
            }
        }
        return result[m - 1][n - 1];
    }*/

    //动态规划 + 滚动数组压缩为一维数组
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] result = new int[n];
        result[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    result[j] = 0;
                } else if (j >= 1) {
                    result[j] += result[j - 1];
                }
            }
        }
        return result[n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        // int[][] obstacleGrid = {{1}};

        _0063UniquePathsII uniquePathsII = new _0063UniquePathsII();
        int i = uniquePathsII.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i);
    }
}
