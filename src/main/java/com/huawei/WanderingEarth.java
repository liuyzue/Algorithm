package com.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/11 20:38
 */
public class WanderingEarth {

    public static void wanderingEarth() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int E = scanner.nextInt();
        int[] engines = new int[N];
        Arrays.fill(engines, -1);
        for (int i = 0; i < E; i++) {
            int time = scanner.nextInt();
            int p = scanner.nextInt();
            engines[p] = time;
        }
        int sum = N;
        for (int i = 0; ; i++) {
            int count = 0;
            List<String> startList = new ArrayList<>();
            for (int j = 0; j < engines.length; j++) {
                if (engines[j] == i) {
                    sum--;
                    count++;
                    startList.add(String.valueOf(j));
                    int pre = (j - 1 + N) % N;
                    if (engines[pre] < 0 || engines[pre] > i + 1) {
                        engines[pre] = i + 1;
                    }
                    int next = (j + 1 + N) % N;
                    if (engines[next] < 0 || engines[next] > i + 1) {
                        engines[next] = i + 1;
                    }
                }
            }
            if (sum == 0) {
                System.out.println(count);
                System.out.println(String.join(" ",startList));
                break;
            }
        }
    }

    public static void main(String[] args) {
        wanderingEarth();
    }

}
