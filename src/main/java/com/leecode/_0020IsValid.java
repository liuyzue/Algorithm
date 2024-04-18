package com.leecode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0020IsValid {

    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : charArray) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                switch (c) {
                    case ']' : if (pop != '[') return false;break;
                    case '}' : if (pop != '{') return false;break;
                    case ')' : if (pop != '(') return false;break;
                    default : return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new _0020IsValid().isValid("{{(())}}"));
    }
}
