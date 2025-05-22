package com.huawei.n2025a;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author liuyuze
 * @date 2025/3/27 16:16
 */
public class HeSuanJianCe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h1 = scanner.nextInt();
        int m1 = scanner.nextInt();
        int h2 = scanner.nextInt();
        int m2 = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] d = new int[n][3];
        for (int i = 0; i < d.length; i++) {
            //id
            d[i][0] = scanner.nextInt();
            //距离
            d[i][1] = scanner.nextInt();
            //当前人数
            d[i][2] = scanner.nextInt();
        }
        //把时间都转化成分钟
        int start = (h1 * 60) + m1;
        int end = (h2 * 60) + m2;

        if (end < 480 || start > 1200) {
            System.out.println(0);
            return;
        }
        List<int[]> result = new ArrayList<>();
        //每公里10分钟  10元  检测每人花费1分钟
        //8-10 3   12-14 10  18-20 20 其他1/5
        for (int i = 0; i < d.length; i++) {
            //路上花费时间
            int distanceTime = d[i][1] * 10;
            //路费
            int distanceCost = d[i][1] * 10;
            //到达时间
            int arrTime = start + distanceTime;
            if (arrTime > 1200) {
                continue;
            }
            int line = 0;
            if (arrTime > 480 && start <= 600) {
                int num = (Math.min(600, arrTime) - Math.max(480, start)) * 3;
                line += num;
            }
            if (arrTime > 600 && start <= 720) {
                int num = (Math.min(720, arrTime) - Math.max(600, start)) / 5;
                line += num;
            }
            if (arrTime > 720 && start <= 840) {
                int num = (Math.min(840, arrTime) - Math.max(720, start)) * 10;
                line += num;
            }
            if (arrTime > 840 && start <= 1080) {
                int num = (Math.min(1080, arrTime) - Math.max(840, start)) / 5;
                line += num;
            }
            if (arrTime > 1080 && start <= 1200) {
                int num = (Math.min(1200, arrTime) - Math.max(1080, start)) * 20;
                line += num;
            }
            //到达时排队的人数
            int inLineNum = line - distanceTime + d[i][2];
            //到达时间 + 排队时间 = 检查时间
            int checkTime = arrTime + (Math.max(inLineNum, 0));
            if (checkTime > 1200) {
                continue;
            }
            result.add(new int[]{d[i][0], checkTime - start, distanceCost});
        }
        result = result.stream().sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] - o2[1] > 1) {
                    return 1;
                }
                if (o1[2] - o2[2] > 1) {
                    return 1;
                }
                if (o1[0] - o2[0] > 1) {
                    return 1;
                }
                return -1;
            }
        }).collect(Collectors.toList());

        System.out.println(result.size());
        if (!result.isEmpty()) {
            for (int[] ints : result) {
                System.out.println(ints[0] + " " + ints[1] + " " + ints[2]);
            }
        }
    }
}
