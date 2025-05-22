package com.huawei.n2025a;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/31 13:45
 */
public class WordLong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }
        boolean[] used = new boolean[n];
        used[k] = true;
        StringBuilder sb = new StringBuilder(words[k]);
        int nextIndex = k;
        int maxLength = 0;
        while (nextIndex >= 0) {
            nextIndex = -1;
            for (int i = 0; i < n; i++) {
                if (used[i]) {
                    continue;
                }
                if (words[i].charAt(0) == sb.charAt(sb.length() - 1) && words[i].length() >= maxLength) {
                    if (words[i].length() == maxLength && words[i].compareTo(words[nextIndex]) > 0) {
                        continue;
                    }
                    maxLength = words[i].length();
                    nextIndex = i;
                }
            }
            if (nextIndex >= 0) {
                sb.append(words[nextIndex]);
                used[nextIndex] = true;
                maxLength = 0;
            }
        }
        System.out.println(sb);

    }
}
