package com.huawei.n2025a;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/30 15:15
 */
public class ShootingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] opt = s.split(" ");
        long score = 0;
        List<Long> list = new ArrayList<>();

        for (String string : opt) {
            if ("+".equals(string)) {
                if (list.size() < 2) {
                    System.out.println(-1);
                    return;
                }
                long num = list.get(list.size() - 1) + list.get(list.size() - 2);
                list.add(num);
            } else if ("C".equals(string)) {
                if (list.isEmpty()) {
                    System.out.println(-1);
                    return;
                }
                list.remove(list.size() - 1);
            } else if ("D".equals(string)) {
                if (list.isEmpty()) {
                    System.out.println(-1);
                    return;
                }
                long num = list.get(list.size() - 1) * 2;
                list.add(num);
            } else {
                try {
                    long num = Integer.parseInt(string);
                    list.add(num);

                } catch (NumberFormatException e) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        for (Long l : list) {
            score += l;
        }
        System.out.println(score);


    }
}
