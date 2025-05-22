package com.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyuze
 * @date 2025/5/22 11:33
 */
public class _0131Partition {

    public static void main(String[] args) {
        _0131Partition partition = new _0131Partition();
        partition.partition("aab");
        partition.partition("a");
    }

    /**
     * 给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "aab"
     * 输出：[["a","a","b"],["aa","b"]]
     * 示例 2：
     *
     * 输入：s = "a"
     * 输出：[["a"]]
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 16
     * s 仅由小写英文字母组成
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        subStrs(s, result, new ArrayList<>());
        return result;
    }

    private void subStrs(String s, List<List<String>> result, List<String> subList) {
        for (int i = 0; i < s.length(); i++) {
            // 子串的前部分
            String preString = s.substring(0, i + 1);
            if (isOk(preString)) {
                subList.add(preString);
                // 判断后面的部分
                String lastSubString = s.substring(i + 1);
                subStrs(lastSubString, result, subList);
                // 如果判断到最后一位返回结果
                if (lastSubString.isEmpty()) {
                    result.add(new ArrayList<>(subList));
                }
                // 回溯
                subList.remove(subList.size() - 1);
            }
        }
    }

    private boolean isOk(String s) {
        if (s.length() > 1) {
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}
