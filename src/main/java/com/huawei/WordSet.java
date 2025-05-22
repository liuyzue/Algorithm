package com.huawei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuyuze
 * @date 2025/3/18 15:17
 */
public class WordSet {
    public static void main(String[] args) {

        Map<Character, String> relationMap = new HashMap<>();
        relationMap.put('0', "abc");
        relationMap.put('1', "def");
        relationMap.put('2', "ghi");
        relationMap.put('3', "jkl");
        relationMap.put('4', "mno");
        relationMap.put('5', "pqr");
        relationMap.put('6', "st");
        relationMap.put('7', "uv");
        relationMap.put('8', "wx");
        relationMap.put('9', "yz");
        Scanner scanner = new Scanner(System.in);
        String relationStr = scanner.next();
        String ban = scanner.next();
        List<String> selectList = new ArrayList<>();
        for (char c : relationStr.toCharArray()) {
            selectList.add(relationMap.get(c));
        }
        StringBuilder sb = new StringBuilder();
        dfs(selectList,0,sb,new StringBuilder(),ban);
        System.out.println(sb);
    }

    private static void dfs(List<String> selectList, int i, StringBuilder sb, StringBuilder stringBuilder,String ban) {

        if (i == selectList.size()) {
            if (!stringBuilder.toString().contains(ban)) {
                sb.append(stringBuilder).append(",");
            }
            return;
        }

        String s = selectList.get(i);
        for (int j = 0; j < s.length(); j++) {
            stringBuilder.append(s.charAt(j));
            dfs(selectList,i + 1, sb, stringBuilder,ban);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
