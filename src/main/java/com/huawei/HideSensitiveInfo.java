package com.huawei;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/14 17:09
 */
public class HideSensitiveInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        String s = scanner.next();
        char[] chars = s.toCharArray();
        boolean in = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\"') {
                in = !in;
            }
            if (in && chars[i] == '_') {
                chars[i] = '&';
            }
            if (!in && i > 0 && chars[i] == '_' && (chars[i - 1] == '_' || chars[i - 1] == '+')) {
                chars[i] = '+';
            }
        }
        String string = String.valueOf(chars);
        string = string.replace("+", "");
        String[] split = string.split("_");
        if (split.length < index) {
            System.out.println("ERROR");
            return;
        }
        split[index] = "******";
        String join = String.join("_", split);
        System.out.println(join.replace("&", "_"));
    }
}
