package com.huawei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuyuze
 * @date 2025/3/20 15:25
 */
public class NumberList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        Set<Integer> set = new HashSet<>();
        int[] num = new int[4];
        for (int i = 0; i < split.length; i++) {
            int n = Integer.parseInt(split[i]);
            if (n < 1 || n > 9 || set.contains(n)
                    || (set.contains(2) && n == 5 || set.contains(5) && n == 2)
                    || (set.contains(6) && n == 9 || set.contains(9) && n == 6)) {
                System.out.println("-1");
                return;
            }
            set.add(n);
            num[i] = n;
        }
        Arrays.sort(num);
        int k = num[3];
        if (k <= 4) {
            System.out.println(num[k - 1]);
            return;
        }
        List<Integer> result = new ArrayList<>();
        if (set.contains(2)) {
            result.add(5);
        }
        if (set.contains(5)) {
            result.add(2);
        }
        if (set.contains(9)) {
            result.add(6);
        }
        if (set.contains(6)) {
            result.add(9);
        }
        for (int i : num) {
            result.add(i);
        }
        result = result.stream().sorted().collect(Collectors.toList());

        int size = result.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    continue;
                }
                int newValue = result.get(i) * 10 + result.get(j);
                String s1 = String.valueOf(newValue);
                if (s1.contains("2") && s1.contains("5")) {
                    continue;
                }
                if (s1.contains("6") && s1.contains("9")) {
                    continue;
                }
                result.add(newValue);
                if (result.size() > k) {
                    System.out.println(result.get(k - 1));
                    return;
                }
            }
        }
    }
}
