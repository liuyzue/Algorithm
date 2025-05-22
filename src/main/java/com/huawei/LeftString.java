package com.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/14 9:34
 */
public class LeftString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int k = scanner.nextInt();
        Map<Character,Integer> s1CharMap = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1CharMap.put(c,s1CharMap.getOrDefault(c,0) + 1);
        }
        int count = s1.length();
        int fast = 0;
        int slow = 0;
        while (fast < s2.length()) {
            Integer num = s1CharMap.get(s2.charAt(fast));
            if (num != null && num > 0) {
                count--;
                s1CharMap.put(s2.charAt(fast), num - 1);
            }
            if (fast - slow == s1.length() + k) {
                Integer slowNum = s1CharMap.get(s2.charAt(slow));
                if (slowNum != null) {
                    count++;
                    s1CharMap.put(s2.charAt(slow), slowNum + 1);
                }
                slow++;
            }
            if (count == 0) {
                System.out.println(slow);
                return;
            }
            fast++;
        }
        System.out.println("-1");
    }
}
