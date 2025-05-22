package com.huawei.n2025a;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/28 14:25
 */
public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int t = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int n = 0;
        while ((t - (s + n * a)) % b != 0) {
            n++;
        }
        int m = 0;
        while ((t - (s - m * a)) % b != 0) {
            m++;
        }
        System.out.println(Math.min(n, m));
    }
}
