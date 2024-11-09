package com.leecode;

import java.util.*;

public class _3242DesignNeighborSumService {

    /**
     * 给你一个 n x n 的二维数组 grid，它包含范围 [0, n2 - 1] 内的不重复元素。
     *
     * 实现 neighborSum 类：
     *
     * neighborSum(int [][]grid) 初始化对象。
     * int adjacentSum(int value) 返回在 grid 中与 value 相邻的元素之和，相邻指的是与 value 在上、左、右或下的元素。
     * int diagonalSum(int value) 返回在 grid 中与 value 对角线相邻的元素之和，对角线相邻指的是与 value 在左上、右上、左下或右下的元素。
     */
    static class NeighborSum {
        int[][] grid;
        Map<Integer, List<Integer>> cache;

        public NeighborSum(int[][] grid) {
            this.grid = grid;
            this.cache = new HashMap<>();
            for (int i = 0; i < this.grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    int[] list = new int[2];
                    List<Integer> index = new ArrayList<>(Arrays.asList(i,j));
                    cache.put(grid[i][j], index);
                }
            }
        }

        public int adjacentSum(int value) {
            List<Integer> list = cache.get(value);
            return (list.get(0) - 1 >= 0 ? grid[list.get(0) - 1][list.get(1)] : 0) +
                    (list.get(1) - 1 >= 0 ? grid[list.get(0)][list.get(1) - 1] : 0) +
                    (list.get(0) + 1 < grid.length ? grid[list.get(0) + 1][list.get(1)] : 0) +
                    (list.get(1) + 1 < grid.length ? grid[list.get(0)][list.get(1) + 1] : 0);
        }

        public int diagonalSum(int value) {
            List<Integer> list = cache.get(value);
            return (list.get(0) - 1 >= 0 && list.get(1) - 1 >= 0 ? grid[list.get(0) - 1][list.get(1) - 1] : 0) +
                    (list.get(0) - 1 >= 0 && list.get(1) + 1 < grid.length ? grid[list.get(0) - 1][list.get(1) + 1] : 0) +
                    (list.get(0) + 1 < grid.length && list.get(1) + 1 < grid.length ? grid[list.get(0) + 1][list.get(1) + 1] : 0) +
                    (list.get(0) + 1 < grid.length && list.get(1) - 1 >= 0 ? grid[list.get(0) + 1][list.get(1) - 1] : 0);
        }

    }

    public static void main(String[] args) {
        int[][] arrays = {{1, 2, 0, 3}, {4, 7, 15, 6}, {8, 9, 10, 11},{12, 13, 14, 5}};
        NeighborSum neighborSum = new NeighborSum(arrays);
        System.out.println(neighborSum.adjacentSum(15));
        System.out.println(neighborSum.adjacentSum(4));
        // System.out.println(neighborSum.adjacentSum(3));
        System.out.println(neighborSum.diagonalSum(9));
        System.out.println(neighborSum.diagonalSum(8));
        // System.out.println(neighborSum.diagonalSum(1));

    }
}