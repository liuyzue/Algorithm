package com.nowcoder;

/**
 * @author liuyuze
 * @date 2025/4/7 13:50
 */
public class NC1 {
    public static void main(String[] args) {
        System.out.println(solve("99", "9"));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public static String solve (String s, String t) {
        StringBuilder longer = new StringBuilder(s.length() > t.length() ? s : t);
        StringBuilder shorter = new StringBuilder(s.length() <= t.length() ? s : t);
        int sub = longer.length() - shorter.length();
        for (int i = 0; i < sub; i++) {
            shorter.insert(0,"0");
        }
        int up = 0;
        StringBuilder result = new StringBuilder();
        for (int i = longer.length() - 1; i >= 0; i--) {
            int sum = Integer.parseInt(String.valueOf(longer.charAt(i))) + Integer.parseInt(String.valueOf(shorter.charAt(i))) + up;
            if (sum >= 10) {
                up = 1;
            } else {
                up = 0;
            }
            result.insert(0, sum % 10);
        }
        if (up == 1) {
            result.insert(0, 1);
        }
        return result.toString();
    }
}
