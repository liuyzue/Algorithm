package com.leecode;

public class _2923FindChampion {

    public int findChampion(int[][] grid) {
        int row = 0;
        while (row < grid.length) {
            int count = 0;
            for (int j = 0; j < grid[row].length; j++) {
                count += grid[row][j];
            }
            if (count == grid.length - 2) {
                return row;
            } else {
                row++;
            }
        }
        return 0;
    }
}
