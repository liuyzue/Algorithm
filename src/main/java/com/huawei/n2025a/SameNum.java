package com.huawei.n2025a;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuyuze
 * @date 2025/3/30 23:15
 */
public class SameNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String[] split1 = s1.split(",");
        String s2 = scanner.nextLine();
        String[] split2 = s2.split(",");

        Map<String,Integer> s1Map = new HashMap<>();
        Map<String,Integer> s2Map = new HashMap<>();

        for (String s : split1) {
            Integer num = s1Map.getOrDefault(s, 0);
            s1Map.put(s, num + 1);
        }
        for (String s : split2) {
            Integer num = s2Map.getOrDefault(s, 0);
            s2Map.put(s, num + 1);
        }

        Map<Integer, List<Integer>> timeMap = new HashMap<>();
        for (String s : s1Map.keySet()) {
            Integer s1Num = s1Map.getOrDefault(s, 0);
            Integer s2Num = s2Map.getOrDefault(s, 0);
            if (s1Num > 0 && s2Num > 0){
                int min = Math.min(s1Num,s2Num);
                List<Integer> list = timeMap.getOrDefault(min, new ArrayList<>());
                list.add(Integer.parseInt(s));
                timeMap.put(min, list);
            }
        }

        List<Integer> timeList = timeMap.keySet().stream().sorted().collect(Collectors.toList());
        if (timeList.isEmpty()) {
            System.out.println("NULL");
        } else {
            for (Integer time : timeList) {
                List<Integer> list = timeMap.get(time);
                System.out.println(time + ":" + list.stream().sorted().map(String::valueOf).collect(Collectors.joining(",")));
            }
        }
    }
}
