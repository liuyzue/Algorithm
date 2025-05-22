package com.huawei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuyuze
 * @date 2025/3/24 22:54
 */
public class RandomNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            numSet.add(scanner.nextInt());
        }

        List<Integer> result = numSet.stream().sorted().collect(Collectors.toList());
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
