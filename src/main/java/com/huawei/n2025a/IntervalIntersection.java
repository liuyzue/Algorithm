package com.huawei.n2025a;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/28 10:24
 */
public class IntervalIntersection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> intervalList = new ArrayList<>();
        List<int[]> commonList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            for (int j = 0; j < intervalList.size(); j++) {
                int[] interval = intervalList.get(j);
                if ((start  >= interval[0] && start <= interval[1]) || (end >= interval[0] && end <= interval[1])){
                    int commonStart = Math.max(start,interval[0]);
                    int commonEnd = Math.min(end, interval[1]);

                    boolean has = false;
                    for (int k = 0; k < commonList.size(); k++) {
                        int[] common = commonList.get(k);
                        if ((commonStart  >= common[0] && commonStart <= common[1]) || (commonEnd >= common[0] && commonEnd <= common[1])){
                            commonList.set(k,new int[]{Math.min(commonStart,common[0]), Math.max(commonEnd,common[1])});
                            has = true;
                        }
                    }
                    if (!has) {
                        commonList.add(new int[]{commonStart,commonEnd});
                    }
                }
            }
            intervalList.add(new int[]{start, end});
        }
        for (int[] interval : commonList) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}
