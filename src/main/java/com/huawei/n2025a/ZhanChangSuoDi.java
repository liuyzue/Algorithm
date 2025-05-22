package com.huawei.n2025a;

import java.util.*;

/**
 * @author liuyuze
 * @date 2025/3/27 20:48
 */
public class ZhanChangSuoDi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        boolean[][] visited = new boolean[n][m];
        for (boolean[] booleans : visited) {
            Arrays.fill(booleans,false);
        }
        int eCount = 0;
        String[][] map = new String[n][m];
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                map[i][j] = String.valueOf(chars[j]);
                if ("E".equals(map[i][j])) {
                    eCount++;
                }
                if ("#".equals(map[i][j])) {
                    //墙壁标记为已经走过
                    visited[i][j] = true;
                }
            }
        }
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        int result = 0;
        //从某一点出发，走过所有可以走过的点
        //标记是否走过
        while (eCount > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    //从0 0开始寻找可以走的空地
                    if (visited[i][j]) {
                        continue;
                    }
                    queue.offer(new int[]{i,j});
                    int num = 0;
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];
                        if (visited[x][y]) {
                            continue;
                        }
                        visited[x][y] = true;
                        if ("E".equals(map[x][y])) {
                            num++;
                            eCount--;
                        }
                        for (int[] dir : dirs) {
                            int nextX = x + dir[0];
                            int nextY = y + dir[1];
                            if (nextX >=0 && nextX < n && nextY >=0 && nextY < m && !"#".equals(map[nextX][nextY]) && !visited[nextX][nextY]) {
                                queue.offer(new int[]{nextX,nextY});
                            }
                        }
                    }
                    if (num < k) {
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
