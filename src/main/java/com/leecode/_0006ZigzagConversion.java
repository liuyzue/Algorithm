package com.leecode;

import java.util.ArrayList;
import java.util.List;

public class _0006ZigzagConversion {
    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     *
     *
     * 示例 1：
     *
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     * 示例 2：
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * 示例 3：
     *
     * 输入：s = "A", numRows = 1
     * 输出："A"
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 由英文字母（小写和大写）、',' 和 '.' 组成
     * 1 <= numRows <= 1000
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        char[] charArray = s.toCharArray();
        int columnNum = charArray.length / (numRows + numRows - 2) *  (numRows - 1);
        int last = charArray.length % (numRows + numRows - 2);
        last =  last == 0 ? 0 : last < numRows ? 1 : last - numRows + 1;
        char[][] resultChars = new char[numRows][columnNum + last];
        int x = 0;int y = 0;
        for (char c : charArray) {
            resultChars[y][x] = c;
            if (x % (numRows - 1) == 0 && y <= numRows - 2) {
                y++;
            } else {
                y--;
                x++;
            }
        }
        for (char[] resultChar : resultChars) {
            for (char c : resultChar) {
                if (c != 0) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    public String convert1(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        char[] charArray = s.toCharArray();
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int flag = 0;
        for (char c : charArray) {
            StringBuilder stringBuilder = rows.get(flag < 0 ? -flag : flag);
            stringBuilder.append(c);
            if (flag == numRows - 1) {
                flag = -flag;
            }
            flag++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder row : rows) {
            stringBuilder.append(row);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        _0006ZigzagConversion zigzagConversion = new _0006ZigzagConversion();
        System.out.println(zigzagConversion.convert1("PAYPALISHIRING", 15));
    }
}
