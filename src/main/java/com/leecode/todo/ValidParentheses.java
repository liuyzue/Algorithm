package com.leecode.todo;

import com.datastruct.MyLinkStack;

import java.util.Stack;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com.leecode.todo
 * @date:2020/7/21
 * @time:17:12
 */
public class ValidParentheses {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     *
     * 输入: "()"
     * 输出: true
     * 示例 2:
     *
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     *
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     *
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     *
     * 输入: "{[]}"
     * 输出: true
     */
    public static boolean valid(String s){
        char[] chars = s.toCharArray();
        Stack<Character> charStack = new Stack<>();
        for(int i = 0; i < chars.length ; i++){
            switch (chars[i]) {
                case '('  :
                case '['  :
                case '{'  :
                    charStack.push(chars[i]);
                    break;
                case ')' : {
                    Character temp = charStack.pop();
                    if (temp != '(') {
                        return false;
                    }
                    break;
                }
                case '}' : {
                    Character temp = charStack.pop();
                    if (temp != '{') {
                        return false;
                    }
                    break;
                }
                case ']' : {
                    Character temp = charStack.pop();
                    if (temp != '[') {
                        return false;
                    }
                    break;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(valid("{}}{}{}"));
    }
}
