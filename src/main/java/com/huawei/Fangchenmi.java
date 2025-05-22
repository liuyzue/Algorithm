package com.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/14 23:24
 */
public class Fangchenmi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] names = new String[num];
        int[] priority = new int[num];
        int[][] times = new int[num][2];
        for (int i = 0; i < num; i++) {
            names[i] = scanner.next();
            priority[i] = scanner.nextInt();
            times[i][0] = Integer.parseInt(scanner.next().replace(":",""));
            times[i][1] = Integer.parseInt(scanner.next().replace(":",""));
        }
        int targetTime = Integer.parseInt(scanner.next().replace(":",""));
        List<Integer> registry = new ArrayList<>();
        registry.add(0);
        for (int i = 1; i < num; i++) {
            if (times[i][0] >= times[i][1]) {
                continue;
            }
            for (Integer cur : registry) {
                if ((times[i][0] >= times[cur][0] && times[i][0] < times[cur][1])
                || (times[i][1] > times[cur][0] && times[i][1] < times[cur][1])
                || (times[i][0] <= times[cur][0] && times[i][1] >= times[cur][1])) {
                    if (priority[cur] >= priority[i]) {
                        continue;
                    }
                    registry.remove(cur);
                    break;
                }
            }
            registry.add(i);
        }
        for (Integer i : registry) {
            if (targetTime >= times[i][0] && targetTime < times[i][1]) {
                System.out.println(names[i]);
                return;
            }
        }
        System.out.println("NA");
    }
}
