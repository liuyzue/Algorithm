package com.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/25 14:27
 */
public class UnionString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        s = s.replace(" ","");
        char[] sChars = new char[s.length() / 2];
        char[] dChars = new char[s.length() - sChars.length];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                dChars[i / 2] = chars[i];
            } else {
                sChars[i / 2] = chars[i];
            }
        }
        Arrays.sort(dChars);
        Arrays.sort(sChars);
        for (int i = 0; i < chars.length; i++) {
            char c;
            if (i % 2 == 0) {
                c = dChars[i / 2];
            } else {
                c = sChars[i / 2];
            }
            char r = handleChar(c);
            if (r == '-') {
                chars[i] = c;
            } else {
                chars[i] = r;
            }
        }
        System.out.println(new String(chars));
    }

    public static char handleChar(char c) {
        int x = -1;
        if (c >= '0' && c <= '9') {
            x = c - '0';
        } else {
            switch (String.valueOf(c).toLowerCase()) {
                case "a":
                    x = 10;
                    break;
                case "b":
                    x = 11;
                    break;
                case "c":
                    x = 12;
                    break;
                case "d":
                    x = 13;
                    break;
                case "e":
                    x = 14;
                    break;
                case "f":
                    x = 15;
                    break;
            }
        }
        StringBuilder binary = new StringBuilder(Integer.toBinaryString(x));
        if (binary.length() != 4) {
            int z = 4 - binary.length();
            for (int i = 0; i < z; i++) {
                binary.insert(0, "0");
            }
        }
        char[] chars = binary.toString().toCharArray();
        int value = 0;
        for (int i = 0; i < chars.length; i++) {
            value += chars[i] == '0' ? 0 : (int) Math.pow(2, i);
        }
        if (value < 10) {
            return String.valueOf(value).toCharArray()[0];
        }
        switch (value) {
            case 10 : return 'A';
            case 11 : return 'B';
            case 12 : return 'C';
            case 13 : return 'D';
            case 14 : return 'E';
            case 15 : return 'F';
        };
        return '-';
    }
}
