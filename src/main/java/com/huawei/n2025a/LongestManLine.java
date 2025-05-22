package com.huawei.n2025a;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/28 17:11
 */
public class LongestManLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s1 = scanner.nextLine();
            String[] split1 = s1.split(",");
            for (int j = 0; j < m; j++) {
                map[i][j] = split1[j].charAt(0);
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'M') {
                    //横向
                    int man = 1;
                    int x = i - 1;
                    while (x >= 0) {
                        if (map[x][j] == 'M') {
                            man++;
                        }
                        x--;
                    }
                    x = i + 1;
                    while (x < n) {
                        if (map[x][j] == 'M') {
                            man++;
                        }
                        x++;
                    }
                    max = Math.max(max, man);

                    //纵向
                    int y = j - 1;
                    man = 1;
                    while (y >= 0) {
                        if (map[i][y] == 'M') {
                            man++;
                        }
                        y--;
                    }
                    y = j + 1;
                    while (y < m) {
                        if (map[i][y] == 'M') {
                            man++;
                        }
                        y++;
                    }
                    max = Math.max(max, man);

                    //对角
                    x = i + 1;
                    y = j - 1;
                    man = 1;
                    while (x < n && y >= 0) {
                        if (map[x][y] == 'M') {
                            man++;
                        }
                        x++;
                        y--;
                    }
                    x = i - 1;
                    y = j + 1;
                    while (x >= 0 && y < m) {
                        if (map[x][y] == 'M') {
                            man++;
                        }
                        x--;
                        y++;
                    }
                    max = Math.max(max, man);

                    //反对角
                    x = i - 1;
                    y = j - 1;
                    man = 1;
                    while (x >= 0 && y >= 0) {
                        if (map[x][y] == 'M') {
                            man++;
                        }
                        y--;
                        x--;
                    }
                    x = i + 1;
                    y = j + 1;
                    while (x < n && y < m) {
                        if (map[x][y] == 'M') {
                            man++;
                        }
                        y++;
                        x++;
                    }
                    max = Math.max(max, man);
                }
            }
        }
        System.out.println(max);
    }
}
