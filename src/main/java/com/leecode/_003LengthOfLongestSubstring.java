package com.leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _003LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int cur = 0,start = 0,max = 0;
        Set<Character> set = new HashSet<>();
        while (start < s.length()) {
            if (cur == s.length()) {
                max = Math.max(max, cur - start);
                break;
            }
            char c = s.charAt(cur);
            if (set.contains(c)) {
                max = Math.max(max, cur - start);
                set.remove(s.charAt(start));
                start++;
            } else {
                cur++;
                set.add(c);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
