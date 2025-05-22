package com.huawei;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/13 21:25
 */
public class SendCandy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long total = scanner.nextLong();

        int count = 0;
        for (long i = total; i != 1; ) {
            if (i == 3) {
                count += 2;
                break;
            }
            if (i % 2 == 1) {
                if ((i + 1) / 2 % 2 == 0) {
                    i++;
                } else {
                    i--;
                }
                count++;
            }
            i = i / 2;
            count++;
        }

        System.out.println(count);
    }
}
