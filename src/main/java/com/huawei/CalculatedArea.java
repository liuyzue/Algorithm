package com.huawei;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/14 16:22
 */
public class CalculatedArea {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int E = scanner.nextInt();
        int[] yOffset = new int[E + 1];
        for (int i = 0; i < N; i++) {
            int index = scanner.nextInt();
            int y = scanner.nextInt();
            yOffset[index] = y;
        }
        int area = 0;
        int y = yOffset[0];
        for (int x = 1; x < E + 1; x++) {
            area += Math.abs(y);
            y += yOffset[x];
        }
        System.out.println(area);
    }
}
