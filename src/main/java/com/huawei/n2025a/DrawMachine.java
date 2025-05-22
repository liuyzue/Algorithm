package com.huawei.n2025a;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/31 10:42
 */
public class DrawMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        int[] offset = new int[e + 1];
        for (int i = 0; i < n; i++) {
            offset[scanner.nextInt()] = scanner.nextInt();
        }
        int startY = offset[0];
        int area = 0;
        for (int i = 1; i < e + 1; i++) {
            area += Math.abs(startY);
            startY = startY + offset[i];
        }
        System.out.println(area);
    }
}
