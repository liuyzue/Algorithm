package com.leecode;

public class _0005LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        String res = chars[0] + "";
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int from = i, to = j;
                while (from < to && chars[from] == chars[to]) {
                    from++;to--;
                }
                if (from >= to) {
                    res = res.length() > j - i ? res : s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _0005LongestPalindrome().longestPalindrome("a"));
    }
}
