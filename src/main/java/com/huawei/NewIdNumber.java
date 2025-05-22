package com.huawei;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/17 9:51
 */
public class NewIdNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long total = scanner.nextLong();
        int y = scanner.nextInt();

        double charNumber = Math.pow(26, y);
        int x = 1;
        double sum = charNumber * 10;
        while (sum < total) {
            x++;
            sum *= 10;
        }

        System.out.println(x);

    }
}
