package com.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/17 13:37
 */
public class LianxuFangboXinhao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        char[] chars = s.toCharArray();
        List<String> resultList = new ArrayList<>();
        int first = s.indexOf("01");
        if (first < 0) {
            System.out.println("-1");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = first; i < chars.length; i++) {
            sb.append(chars[i]);
            if (chars[i] == '0' && (i == chars.length - 1 || chars[i + 1] == '0')) {
                resultList.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        int maxLength = 0;
        int index = -1;
        for (int i = 0; i < resultList.size(); i++) {
            String s1 = resultList.get(i);
            if (s1.length() < 3) {
                continue;
            }
            String s2 = ("1" + s1).substring(0, s1.length() + 1);
            boolean isMatch = true;
            for (int j = 0; j < s1.length(); j++) {
                if (Integer.parseInt(String.valueOf(s1.charAt(j))) + Integer.parseInt(String.valueOf(s2.charAt(j))) > 1) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch && maxLength < s1.length()) {
                maxLength = s1.length();
                index = i;
            }
        }
        System.out.println(index > -1 ? resultList.get(index) : "-1");

    }
}
