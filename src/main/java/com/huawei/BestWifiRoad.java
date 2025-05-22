package com.huawei;

import java.util.*;

/**
 * @author liuyuze
 * @date 2025/3/21 13:38
 */
public class BestWifiRoad {

    static int r;
    static int c;
    static int[][] cov;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        r = scanner.nextInt();
        c = scanner.nextInt();
        cov = new int[r][c];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                cov[i][j] = scanner.nextInt();
                max = Math.max(max, cov[i][j]);
                min = Math.min(min, cov[i][j]);
            }
        }
        while (min <= max) {
            int mid = (max + min) / 2;
            if (!search(mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(max);
    }

    private static boolean search(int mid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        if (cov[0][0] < mid) {
            return false;
        }
        Set<String> visited = new HashSet<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            if (x == r - 1 && y == c - 1) {
                return true;
            }
            visited.add(x + "," + y);
            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                if (nextX >= 0 && nextX < r && nextY >= 0 && nextY < c && cov[nextX][nextY] >= mid && !visited.contains(nextX + "," + nextY)) {
                    queue.offer(new int[]{nextX, nextY, poll[2]});
                }
            }
        }

        return false;
    }
}
