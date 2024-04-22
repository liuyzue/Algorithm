package com.leecode;

public class _0392IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0, tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;tIndex++;
            } else {
                tIndex++;
            }
        }
        return sIndex == s.length();
    }

    public static void main(String[] args) {
        System.out.println(new _0392IsSubsequence().isSubsequence("aaaaa", "bbaaaaa"));
    }
}
