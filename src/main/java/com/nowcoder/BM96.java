package com.nowcoder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author liuyuze
 * @date 2025/4/2 10:15
 */
public class BM96 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = Integer.valueOf(s.charAt(0));

        int first = s.indexOf(",");
        String s1 = s.substring(first + 3, s.length() - 2);
        String[] intervalStr = s1.split("],\\[");
        List<int[]> list = new ArrayList<>();
        for (String string : intervalStr) {
            String[] split1 = string.split(",");
            list.add(new int[]{Integer.parseInt(split1[0]), Integer.parseInt(split1[1])});
        }
        list = list.stream().sorted(Comparator.comparing(e -> e[0])).collect(Collectors.toList());
        int count = 0;
        while (!list.isEmpty()) {
            List<Integer> indexList = new ArrayList<>();
            int end = 0;
            for (int i = 0; i < list.size(); i++) {
                int[] interval = list.get(i);
                if (interval[0] >= end) {
                    end = interval[1];
                    indexList.add(i);
                }
            }
            for (int i = indexList.size() - 1; i >= 0; i--) {
                list.remove(indexList.get(i).intValue());
            }
            count++;
        }

        System.out.println(count);
    }
}
