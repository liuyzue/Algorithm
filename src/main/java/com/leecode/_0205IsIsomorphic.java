package com.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyuze
 * @date 2025/5/8 17:25
 */
public class _0205IsIsomorphic {
    /**
     * 205. 同构字符串
     * 简单
     * 相关标签
     * 相关企业
     * 给定两个字符串 s 和 t ，判断它们是否是同构的。
     *
     * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
     *
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     *
     *
     *
     * 示例 1:
     *
     * 输入：s = "egg", t = "add"
     * 输出：true
     * 示例 2：
     *
     * 输入：s = "foo", t = "bar"
     * 输出：false
     * 示例 3：
     *
     * 输入：s = "paper", t = "title"
     * 输出：true
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 5 * 104
     * t.length == s.length
     * s 和 t 由任意有效的 ASCII 字符组成
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Character> mapA = new HashMap<>();
        Map<Character,Character> mapB = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char d = t.charAt(i);
            Character c1 = mapA.get(c);
            Character d1 = mapB.get(d);
            if ((c1 != null && c1 != d) || (d1 != null && d1 != c)) {
                return false;
            }
            mapA.put(c, d);
            mapB.put(d, c);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("foo", "egg"));
    }
}
