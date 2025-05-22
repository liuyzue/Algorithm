package com.leecode;

import java.util.*;

public class _0139WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        for (int i = 1; i <= s.length(); i++) {
            String substring = s.substring(0, i);
            if (wordDict.contains(substring)) {
                String lastStr = s.substring(i);
                if(wordBreak(lastStr, wordDict) || lastStr.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        List<String> wordDict = Arrays.asList(strings);
        _0139WordBreak wordBreak = new _0139WordBreak();
        System.out.println(wordBreak.wordBreak1("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", wordDict));
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (dp[i] && wordDict.contains(sub)) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
