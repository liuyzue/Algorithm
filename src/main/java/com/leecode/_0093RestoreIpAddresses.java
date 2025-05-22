package com.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyuze
 * @date 2025/4/22 9:40
 */
public class _0093RestoreIpAddresses {

    public static void main(String[] args) {
        // List<String> strings = restoreIpAddresses("25525511135");
        List<String> strings = restoreIpAddresses1("0000");
        for (String string : strings) {
            System.out.println(string);
        }
    }
    /*public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        int length = chars.length;
        //遍历数组
        //分4段，每段长度不超过3
        String[] subs = new String[4];
        for (int i = 0; i < 3 && i < length; i++) {
            StringBuilder sb = new StringBuilder();
            //如果后续长度大于9，则继续
            if (length - i - 1 > 9) {
                continue;
            }
            //第一段
            //首位不能为0
            String sub1 = s.substring(0, i + 1);
            int num1 = Integer.parseInt(sub1);
            //每段ip数字小于256
            if (num1 < 256) {
                subs[0] = sub1;
            } else {
                break;
            }
            //第二段
            for (int j = i + 1; j <= i + 3  && j < length - 2; j++) {
                //如果后续长度大于6，则继续
                if (length - j - 1 > 6) {
                    continue;
                }
                String sub2 = s.substring(i + 1, j + 1);
                int num2 = Integer.parseInt(sub2);
                if (num2 < 256) {
                    subs[1] = sub2;
                } else {
                    break;
                }
                //第三段
                for (int k = j + 1; k <= j + 3  && k < length - 1; k++) {
                    //如果后续长度大于6，则继续
                    if (length - k - 1 > 3) {
                        continue;
                    }
                    String sub3 = s.substring(j + 1, k + 1);
                    int num3 = Integer.parseInt(sub3);
                    if (num3 < 256) {
                        subs[2] = sub3;
                    } else {
                        break;
                    }
                    // 第四段,直接到字符串结尾
                    String sub4 = s.substring(k + 1, length);
                    if (sub4.length() > 1 && sub4.startsWith("0")) {
                        continue;
                    }
                    int num4 = Integer.parseInt(sub4);
                    if (num4 < 256 ) {
                        subs[3] = sub4;
                        result.add(String.join(",",subs));
                    } else {
                        continue;
                    }
                    if (num3 == 0) {
                        break;
                    }
                }
                if (num2 == 0) {
                    break;
                }
            }
            if (num1 == 0) {
                break;
            }
        }
        return result;
    }*/

    public static List<String> restoreIpAddresses1(String s) {
        List<String> result = new ArrayList<>();
        String[] subs = new String[4];
        findSub(result, s, 0, 2,subs, 0);
        return result;
    }

    public static void findSub(List<String> result, String s, int start, int end, String[] subs, int index) {
        int longestLength = (4 - index) * 3;
        int lastLength = s.length() - start - 1;
        if (lastLength > longestLength) {
            return;
        }
        if (index == 3) {
            String s1 = selectNum(s, start, s.length());
            if ("NO".equals(s1)) {
                return;
            }
            subs[index] = s1;
            result.add(String.join(".", subs));
            return;
        }
        for (int i = start; i <= end && i < s.length(); i++) {
            String sub = selectNum(s, start, i + 1);
            if (!"NO".equals(sub)) {
                subs[index] = sub;
                findSub(result, s, i + 1, i + 3, subs, index + 1);
            }
        }
    }

    public static String selectNum(String s, int start, int end) {
        String sub = s.substring(start, Math.min(end,s.length()));
        if (sub.isEmpty()) {
            return "NO";
        }
        int num = Integer.parseInt(sub);
        if(sub.length() > 1 && sub.startsWith("0") || num > 255) {
            return "NO";
        }
        return sub;
    }
}
