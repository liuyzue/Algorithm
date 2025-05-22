package com.leecode;

/**
 * @author liuyuze
 * @date 2025/5/6 10:21
 */
public class _0028StrStr {

    public static void main(String[] args) {
        System.out.println(strStr("baaaa", "aaa"));
    }

    public static int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);

        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean has = true;
                for (int j = 1;j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        has = false;
                        break;
                    }
                }
                if (has) {
                    return i;
                }
            }
        }
        return -1;
    }
}
