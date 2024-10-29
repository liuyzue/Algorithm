package com.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个正整数 n。
 *
 * 如果一个二进制字符串 x 的所有长度为 2 的
 * 子字符串
 * 中包含 至少 一个 "1"，则称 x 是一个 有效 字符串。
 *
 * 返回所有长度为 n 的 有效 字符串，可以以任意顺序排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入： n = 3
 *
 * 输出： ["010","011","101","110","111"]
 *
 * 解释：
 *
 * 长度为 3 的有效字符串有："010"、"011"、"101"、"110" 和 "111"。
 *
 * 示例 2：
 *
 * 输入： n = 1
 *
 * 输出： ["0","1"]
 *
 * 解释：
 *
 * 长度为 1 的有效字符串有："0" 和 "1"。
 *
 *
 *
 * 提示：
 *
 * 1 <= n <= 18
 */
public class _3211GenerateBinaryStringWithoutAdjacentZeros {


    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        generateStrStartWith(result,"0", n - 1);
        generateStrStartWith(result,"1", n - 1);
        return result;
    }

    public void generateStrStartWith(List<String> result,String s, int n) {
        if (n == 0) {
            result.add(s);
            return;
        }
        if (s.endsWith("0")) {
            generateStrStartWith(result,s + "1", n - 1);
        } else {
            generateStrStartWith(result,s + "0", n - 1);
            generateStrStartWith(result,s + "1", n - 1);
        }
    }

    public static void main(String[] args) {
        _3211GenerateBinaryStringWithoutAdjacentZeros g = new _3211GenerateBinaryStringWithoutAdjacentZeros();
        List<String> strings = g.validStrings(1);

        strings.forEach(System.out::println);
    }
}
