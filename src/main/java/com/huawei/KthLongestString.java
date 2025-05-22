package com.huawei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuyuze
 * @date 2025/3/14 14:18
 */
public class KthLongestString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int k = scanner.nextInt();
        Map<Character,Integer> charMap = new HashMap<>();
        int num = 0;
        char c = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                num++;
            }
            if (c != s.charAt(i) || i == s.length() - 1) {
                charMap.put(c, Math.max(charMap.getOrDefault(c, 0), num));
                num = 1;
                c = s.charAt(i);
            }
        }
        List<Character> charList = charMap.keySet().stream().sorted(Comparator.comparing(charMap::get)).collect(Collectors.toList());
        System.out.println(charList.size() < k ? -1 : charMap.get(charList.get(charList.size() - k)));
    }
}
