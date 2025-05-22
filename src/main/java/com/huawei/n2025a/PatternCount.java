package com.huawei.n2025a;

import java.util.*;

/**
 * @author liuyuze
 * @date 2025/3/29 20:51
 */
public class PatternCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] am = new int[m];
        int[] bn = new int[n];

        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            am[i] = scanner.nextInt();
            if (m > n) {
                Integer num = map.getOrDefault(am[i], 0);
                map.put(am[i],++num);
            }
        }
        for (int i = 0; i < n; i++) {
            bn[i] = scanner.nextInt();
            if (m <= n) {
                Integer num = map.getOrDefault(bn[i], 0);
                map.put(bn[i],++num);
            }
        }
        int[] loop = m >= n ? bn : am;
        for (int i : loop) {
            count += map.getOrDefault(i,0);
        }


        System.out.println(count);
    }
}
