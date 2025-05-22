package com.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/20 16:29
 */
public class PlayerMatch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] player = new int[n];
        for (int i = 0; i < n; i++) {
            player[i] = scanner.nextInt();
        }
        int[] games = new int[n + 1];
        int[] distances = new int[n + 1];
        Arrays.sort(player);
        for (int i = 2; i < n + 1; i++) {
            int isMatch = 0;
            int dis = player[i - 1] - player[i - 2];
            if (dis <= d) {
                isMatch = 1;
            }
            if (games[i - 2] + isMatch > games[i - 1]) {
                games[i] = games[i - 2] + isMatch;
                distances[i] = distances[i - 2] + dis;
            } else if(games[i - 2] + isMatch < games[i - 1]) {
                games[i] = games[i - 1];
                distances[i] = distances[i - 1];
            } else {
                games[i] = games[i - 1];
                if (distances[i - 2] + dis <= distances[i - 1]) {
                    distances[i] = distances[i - 2] = dis;
                } else {
                    distances[i] = distances[i - 1];
                }
            }
        }
        if (games[n] == 0) {
            System.out.println("-1");
        } else {
            System.out.println(distances[n]);
        }
    }
}
