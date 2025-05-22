package com.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/13 21:35
 */
public class SendLog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        int[] logs = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        int good = 0;
        int bad = 0;
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < logs.length; i++) {
            good += logs[i];
            if (i > 0) {
                bad = bad * 2 + logs[i - 1];
            }
            if (good >= 100) {
                maxScore = Math.max(maxScore, 100 - bad);
            } else {
                maxScore = Math.max(maxScore, good - bad);
            }
        }
        System.out.println(maxScore);
    }
}
