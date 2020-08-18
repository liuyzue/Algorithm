package com.leecode;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com.leecode.todo
 * @date:2020/7/21
 * @time:17:10
 */
public class LongestCommonPrefix {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     *
     * 所有输入只包含小写字母 a-z 。
     */
    public String longestCommonPrefix(String[] strs){
        int len = strs.length;
        if (len == 0){ return "";}
        if (len == 1){ return strs[0];}
        int mixLen = strs[0].length();
        for (int i =1 ; i < len ; i++){
            if (strs[i].length() < mixLen){
                mixLen = strs[i].length();
            }
        }
        String common = "";
        for (int i = 1 ; i <= mixLen ; i++){
            common = strs[0].substring(0,i);
            for (int j = 1; j < len ; j++){
                if (!common.equals(strs[j].substring(0,i))){
                    if (i == 0) {return "";}
                    return strs[0].substring(0,i-1);
                }
            }
        }

        return common;
    }
}
