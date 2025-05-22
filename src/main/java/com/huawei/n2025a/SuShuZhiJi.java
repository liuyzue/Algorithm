package com.huawei.n2025a;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/30 15:33
 */
public class SuShuZhiJi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();
        long end = (long) Math.sqrt(l);
        for (long num = end; num > 0; num--) {
            if (isSuShu(num) && l % num == 0 && isSuShu(l / num)) {
                System.out.println(Math.min(num, l / num) + " " + Math.max(num, l / num));
                return;
            }
        }
        System.out.println("-1 -1");

    }

    public static boolean isSuShu(long num) {
        if (num < 3 && num > 0) {
            return true;
        }
        long end = (long) Math.sqrt(num);
        for (long l = 2; l <= end; l++) {
            if (num % l == 0){
                return false;
            }
        }
        return true;
    }
}
