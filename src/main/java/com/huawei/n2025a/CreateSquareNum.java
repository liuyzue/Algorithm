package com.huawei.n2025a;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author liuyuze
 * @date 2025/3/31 13:59
 */
public class CreateSquareNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] point = new int[n][2];
        Set<String> pointSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            point[i][0] = scanner.nextInt();
            point[i][1] = scanner.nextInt();
            pointSet.add(point[i][0] + "," + point[i][1]);
        }
        if (point.length < 4) {
            System.out.println(0);
            return;
        }
        int count = 0;
        for (int i = 0; i < point.length; i++) {
            for (int j = i + 1; j < point.length; j++) {
                if (j == i) {
                    continue;
                }
                //2点确定一个边向量
                int ix = point[i][0];
                int iy = point[i][1];
                int jx = point[j][0];
                int jy = point[j][1];

                int dx = ix - jx;
                int dy = iy - jy;

                //以此为基准找剩余的两个点
                int x1 = ix - dy;
                int y1 = iy + dx;

                int x2 = jx - dy;
                int y2 = jy + dx;

                int x3 = ix + dy;
                int y3 = iy - dx;

                int x4 = jx + dy;
                int y4 = jy - dx;

                if (pointSet.contains(x1 + "," + y1) && pointSet.contains(x2 + "," + y2)) {
                    count++;
                }
                if (pointSet.contains(x3 + "," + y3) && pointSet.contains(x4 + "," + y4)) {
                    count++;
                }


            }
        }
        System.out.println(count / 4);
    }
}
