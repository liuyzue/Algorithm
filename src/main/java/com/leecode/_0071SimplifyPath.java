package com.leecode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class _0071SimplifyPath {

    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String s : paths) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if ((!".".equals(s) && !s.isEmpty())) {
                stack.offerLast(s);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/").append(stack.pollFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _0071SimplifyPath().simplifyPath1("/home/../foo/"));
    }

    public String simplifyPath1(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuffer ans = new StringBuffer();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }
}
