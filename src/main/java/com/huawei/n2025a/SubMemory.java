package com.huawei.n2025a;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/28 0:33
 */
public class SubMemory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int total = 100;
        List<int[]> subList = new ArrayList<>();
        int[] use = new int[100];
        while (n > 0) {
            String s = scanner.nextLine();
            String[] split = s.split("=");
            if ("REQUEST".equals(split[0])) {
                int x = Integer.parseInt(split[1]);
                if (x > total || x == 0) {
                    System.out.println("error");
                }
                boolean isOk = true;
                for (int i = 0; i < total - x; i++) {
                    int start = i;
                    int end = i + x - 1;
                    isOk = true;
                    for (int[] ints : subList) {
                        if ((start <= ints[0] && end >= ints[0]) || (start <= ints[1] && end >= ints[1])) {
                            isOk = false;
                            break;
                        }
                    }
                    if (isOk) {
                        subList.add(new int[]{start,end});
                        total -= x;
                        System.out.println(start);
                        break;
                    }
                }
                if (!isOk) {
                    System.out.println("error");
                }
            }
            if ("RELEASE".equals(split[0])) {
                int start = Integer.parseInt(split[1]);
                boolean isOk = false;
                for (int i = 0; i < subList.size(); i++) {
                    int[] sub = subList.get(i);
                    if (sub[0] == start) {
                        subList.remove(i);
                        total += sub[1] - sub[0] + 1;
                        isOk = true;
                        break;
                    }
                }
                if (!isOk) {
                    System.out.println("error");
                }
            }

        }
    }
}
