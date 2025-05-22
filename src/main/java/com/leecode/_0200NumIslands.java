package com.leecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuyuze
 * @date 2025/4/23 15:46
 */
public class _0200NumIslands {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int num = 0;
        int xLength = grid.length;
        int yLength = grid[0].length;
        boolean[][] visited = new boolean[xLength][yLength];

        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if (grid[i][j] == '0' || visited[i][j]) {
                    continue;
                }
                num++;
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{i,j});
                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    int x = poll[0];
                    int y = poll[1];
                    if (visited[x][y]) {
                        continue;
                    }
                    visited[x][y] = true;
                    if (x + 1 < xLength && grid[x + 1][y] == '1') {
                        queue.offer(new int[]{x + 1, y});
                    }
                    if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                        queue.offer(new int[]{x - 1, y});
                    }
                    if (y + 1 < yLength && grid[x][y + 1] == '1') {
                        queue.offer(new int[]{x, y + 1});
                    }
                    if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                        queue.offer(new int[]{x, y - 1});
                    }
                }
            }
        }



        return num;
    }
}
