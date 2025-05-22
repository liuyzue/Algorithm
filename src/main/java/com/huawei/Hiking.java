package com.huawei;

import java.util.*;

/**
 * @author liuyuze
 * @date 2025/3/19 21:41
 */
public class Hiking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        Map<String , Integer> stepNumMap = new HashMap<>();
        int max = 0;
        String top = "0,0";
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int high = map[x][y];
            String point = x + "," + y;
            if (stepNumMap.get(point) != null) {
                continue;
            }
            stepNumMap.put(x + "," + y, poll[2]);

            if (high > max || (high == max && stepNumMap.get(top) > poll[2])) {
                top = point;
                max = high;
            }

            if (x - 1 >= 0 && Math.abs(map[x - 1][y] - high) <= k) {
                queue.offer(new int[]{x - 1, y, poll[2] + 1});
            }
            if (x + 1 < m && Math.abs(map[x + 1][y] - high) <= k) {
                queue.offer(new int[]{x + 1, y, poll[2] + 1});
            }
            if (y - 1 >= 0 && Math.abs(map[x][y - 1] - high) <= k) {
                queue.offer(new int[]{x, y - 1, poll[2] + 1});
            }
            if (y + 1 < n && Math.abs(map[x][y + 1] - high) <= k) {
                queue.offer(new int[]{x, y + 1, poll[2] + 1});
            }
        }
        if (stepNumMap.size() <= 1 || max == map[0][0]) {
            System.out.println("0 0");
        } else {
            System.out.println(max + " " + (stepNumMap.get(top) == null ? 0 : stepNumMap.get(top)));
        }
    }
}
