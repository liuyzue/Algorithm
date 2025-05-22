package com.huawei;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/25 15:30
 */
public class IsSameSubInternet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mask = scanner.nextLine();
        String ip1 = scanner.nextLine();
        String ip2 = scanner.nextLine();

        String[] strings = new String[3];
        strings[0] = mask;
        strings[1] = ip1;
        strings[2] = ip2;

        for (int i = 0; i < strings.length; i++) {
            String ip = strings[i];
            String[] split = ip.split("\\.");
            if (split.length != 4) {
                System.out.println(1);
                return;
            }

            int[] ipNum = new int[4];
            for (int j = 0; j < split.length; j++) {
                ipNum[j] = Integer.parseInt(split[j]);
                if (ipNum[j] < 0 || ipNum[j] > 255) {
                    System.out.println(1);
                    return;
                }
                String binary = Integer.toBinaryString(ipNum[j]);
                if (binary.length() != 8) {
                    StringBuilder sb = new StringBuilder(binary);
                    int z = 8 - binary.length();
                    for (int k = 0; k < z; k++) {
                        sb.insert(0,"0");
                    }
                    binary = sb.toString();
                }
                split[j] = binary;
            }
            strings[i] = String.join(".",split);
        }
        char[] masks = strings[0].toCharArray();
        boolean flag = false;
        for (char c : masks) {
            if (c == '0') {
                flag = true;
            }
            if (flag && c == '1') {
                System.out.println(1);
                return;
            }
        }

        for (int i = 0; i < strings[0].length(); i++) {
            if (strings[0].charAt(i) == '1' && strings[1].charAt(i) != strings[2].charAt(i)) {
                System.out.println(2);
                return;
            }
            if (strings[0].charAt(i) == '0') {
                System.out.println(0);
                return;
            }
        }

    }
}
