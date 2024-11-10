package com.leecode;

import java.util.ArrayList;
import java.util.List;

public class _0151ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length - 1; i >= 0 ; i--) {
            if (!"".equals(split[i])) {
                stringBuilder.append(split[i]).append(" ");
            }
        }
        String result = stringBuilder.toString();
        while (result.endsWith(" ")) {
            result = result.substring(0,result.length() - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        _0151ReverseWordsInAString reverseWordsInAString = new _0151ReverseWordsInAString();

        System.out.println(reverseWordsInAString.reverseWords( "a good   example"));
    }
}
