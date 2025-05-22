package com.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyuze
 * @date 2025/5/8 15:07
 */
public class _0054SpiralOrder {
    /**
     * 54. 螺旋矩阵
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     *
     *
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *
     *
     * 提示：
     *
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 10
     * -100 <= matrix[i][j] <= 100
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int adj = 0;
        int x = 0;
        int y = 0;
        int sum = 0;
        while (sum < n * m) {
            if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]){
                visited[x][y] = true;
                result.add(matrix[x][y]);
                sum++;
                x += dirs[adj][0];
                y += dirs[adj][1];
            } else {
                x -= dirs[adj][0];
                y -= dirs[adj][1];
                adj = (adj + 1) % dirs.length;
                x += dirs[adj][0];
                y += dirs[adj][1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> integers = spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : integers) {
            stringBuilder.append(integer).append(",");
        }
        System.out.println(stringBuilder);
    }
}
