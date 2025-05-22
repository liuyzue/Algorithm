package com.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/24 23:03
 */
public class YanzhengIp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int E = 0;
        int ERROR = 0;
        int PRI = 0;
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            try {
                String[] split = s.split("~");
                String[] ip = split[0].split("\\.");
                String[] mask = split[1].split("\\.");
                if (ip.length != 4 || mask.length != 4) {
                    ERROR++;
                    continue;
                }
                int[] ipNum = new int[4];
                int[] maskNum = new int[4];
                for (int i = 0; i < ip.length; i++) {
                    ipNum[i] = Integer.parseInt(ip[i]);
                    maskNum[i] = Integer.parseInt(mask[i]);
                }
                int ip0 = ipNum[0];
                int ip1 = ipNum[1];
                if (ip0 == 0 || ip0 == 127) {
                    continue;
                }
                if (!isIp(ipNum) || !isMask(maskNum)) {
                    ERROR++;
                    continue;
                }
                if (ip0 >= 1 && ip0 <= 126) {
                    A++;
                    if (ip0 == 10) {
                        PRI++;
                    }
                } else if (ip0 >= 128 && ip0 <= 191) {
                    B++;
                    if (ip0 == 172 && (ip1 >= 16 && ip1 <= 31)) {
                        PRI++;
                    }
                } else if (ip0 >= 192 && ip0 <= 223) {
                    C++;
                    if (ip0 == 192 && ip1 == 168) {
                        PRI++;
                    }
                } else if (ip0 >= 224 && ip0 <= 239) {
                    D++;
                } else if (ip0 >= 240 && ip0 <= 255) {
                    E++;
                }
            } catch (Exception e) {
                ERROR++;
            }
        }
        System.out.println(A + " " + B + " " + C + " " + D + " " + E + " " + ERROR + " " + PRI);

    }

    public static boolean isMask(int[] mask) {
        StringBuilder sb = new StringBuilder();
        for (int k : mask) {
            StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(k));
            if (binaryString.length() < 8) {
                String pre = "0";
                int x = 8 - binaryString.length();
                for (int j = 0; j < x; j++) {
                    binaryString.insert(0, pre);
                }
            }
            sb.append(binaryString);
        }
        boolean flag = false;
        String string = sb.toString();
        if (!string.contains("0") || !string.contains("1")) {
            return false;
        }
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                flag = true;
            }
            if (flag && chars[i] == '1') {
                return false;
            }
        }
        return true;
    }

    public static boolean isIp(int[] ip) {
        for (int i = 0; i < ip.length; i++) {
            if (ip[i] < 0 || ip[i] > 255) {
                return false;
            }
        }
        return true;
    }
}
