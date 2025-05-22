package com.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author liuyuze
 * @date 2025/3/17 15:23
 */
public class SimpleString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char minChar = 'z';
        Set<Character> set = new HashSet<>();
        boolean in = false;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == ')') in = !in;
            if (in && c != '(') {
                set.add(c);
                minChar = c > minChar ? minChar : c;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == ')') in = !in;
            if (in || c == ')') {
                continue;
            }
            if (set.contains(c)) {
                sb.append(minChar);
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}
