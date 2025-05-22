package com.huawei.n2025a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/31 9:57
 */
public class MatrixArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[3][4];
        for (int i = 0; i < 3; i++) {
            matrix[i][0] = scanner.nextInt();
            matrix[i][1] = scanner.nextInt();
            matrix[i][2] = scanner.nextInt();
            matrix[i][3] = scanner.nextInt();
        }
        List<int[]> xIntervals = new ArrayList<>();
        List<int[]> yIntervals = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            xIntervals.add(new int[]{matrix[i][0], matrix[i][0] + matrix[i][2]});
            yIntervals.add(new int[]{matrix[i][1], matrix[i][1] - matrix[i][3]});
        }

        int[] xCommonInterval = xIntervals.get(0);
        Arrays.sort(xCommonInterval);
        for (int i = 1; i < 3; i++) {
            int[] nextInterval = xIntervals.get(i);
            Arrays.sort(nextInterval);
            if (xCommonInterval[0] >= nextInterval[0] && xCommonInterval[0] <= nextInterval[1] || xCommonInterval[1] >= nextInterval[0] && xCommonInterval[1] <= nextInterval[1]) {
                xCommonInterval[0] = Math.max(xCommonInterval[0], nextInterval[0]);
                xCommonInterval[1] = Math.min(xCommonInterval[1], nextInterval[1]);
            } else {
                System.out.println(0);
                return;
            }
        }
        int[] yCommonInterval2 = yIntervals.get(0);
        Arrays.sort(yCommonInterval2);
        for (int i = 1; i < 3; i++) {
            int[] nextInterval = yIntervals.get(i);
            Arrays.sort(nextInterval);
            if (yCommonInterval2[0] >= nextInterval[0] && yCommonInterval2[0] <= nextInterval[1] || yCommonInterval2[1] >= nextInterval[0] && yCommonInterval2[1] <= nextInterval[1]) {
                yCommonInterval2[0] = Math.max(yCommonInterval2[0], nextInterval[0]);
                yCommonInterval2[1] = Math.min(yCommonInterval2[1], nextInterval[1]);
            } else {
                System.out.println(0);
                return;
            }
        }
        int area = (xCommonInterval[1] - xCommonInterval[0]) * (yCommonInterval2[1] - yCommonInterval2[0]);
        System.out.println(area);
    }
}
