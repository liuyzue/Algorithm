package com.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/14 10:29
 */
public class EnhanceStrstr {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String source = scanner.nextLine();
        String pattern = scanner.nextLine();
        List<String> patternList = new ArrayList<>();
        while (pattern.contains("[")){
            int start = pattern.indexOf("[");
            int end = pattern.indexOf("]");
            String selectChar = pattern.substring(start, end + 1);
            patternList.add(selectChar);
            pattern = pattern.replace(selectChar,"*" + (patternList.size() - 1));
        }
        for (int i = 0; i < source.length(); ) {
            boolean isMatch = true;
            int end = i;
            for (int j = 0; j < pattern.length(); j++) {
                if (end < source.length()  &&
                (pattern.charAt(j) == source.charAt(end) || (pattern.charAt(j) == '*' && patternList.get(pattern.charAt(++j) - '0').contains(source.charAt(end) + "")))) {
                    end++;
                } else {
                    isMatch = false;
                    i = i + 1;
                    break;
                }
            }
            if (isMatch) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("-1");
    }
}
