package com.leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyuze
 * @date 2025/5/9 14:13
 */
public class _0290WordPattern {

    /**
     * 290. 单词规律
     * 简单
     * 相关标签
     * 相关企业
     * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
     *
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
     *
     *
     *
     * 示例1:
     *
     * 输入: pattern = "abba", s = "dog cat cat dog"
     * 输出: true
     * 示例 2:
     *
     * 输入:pattern = "abba", s = "dog cat cat fish"
     * 输出: false
     * 示例 3:
     *
     * 输入: pattern = "aaaa", s = "dog cat cat dog"
     * 输出: false
     *
     *
     * 提示:
     *
     * 1 <= pattern.length <= 300
     * pattern 只包含小写英文字母
     * 1 <= s.length <= 3000
     * s 只包含小写英文字母和 ' '
     * s 不包含 任何前导或尾随对空格
     * s 中每个单词都被 单个空格 分隔
     * @param pattern
     * @param s
     * @return
     */
    public static boolean wordPattern(String pattern, String s) {

        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map1 = new HashMap<>();
        String[] s1 = s.split(" ");
        if (pattern.length() != s1.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str1 = s1[i];
            String str = map.get(c);
            Character d = map1.get(str1);
            if ((str != null && !str.equals(str1)) || (d != null && d != c)) {
                return false;
            }
            map.put(c, str1);
            map1.put(str1, c);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }
}
