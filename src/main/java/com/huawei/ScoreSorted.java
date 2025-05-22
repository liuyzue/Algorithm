package com.huawei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/25 15:58
 */
public class ScoreSorted {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int op = scanner.nextInt();
        String[][] students = new String[n][2];
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students[i].length; j++) {
                students[i][j] = scanner.next();
            }
        }
        if (op == 0) {
            Arrays.sort(students, Comparator.comparing(a -> -Integer.parseInt(a[1])));
        } else if (op == 1) {
            Arrays.sort(students, Comparator.comparing(a -> Integer.parseInt(a[1])));
        }
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i][0] + " " + students[i][1]);
        }
    }
}
