package com.huawei.n2025a;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/29 23:05
 */
public class NewWorkId {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        int y = scanner.nextInt();

        long charLength = (long) Math.pow(26, y);
        int n = 1;
        long numLength = 10;
        while (charLength * numLength < x) {
            n++;
            numLength *= 10;
        }
        System.out.println(n);
    }
}
