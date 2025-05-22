package com.huawei.n2025a;

import java.util.*;

/**
 * @author liuyuze
 * @date 2025/3/26 22:15
 */
public class TreeMid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        Stack<String> nodeStack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '}') {
                StringBuilder sb = new StringBuilder();
                Integer index = stack.pop();
                for (int j = index; j <= nodeStack.size(); j++) {
                    sb.insert(0,nodeStack.pop());
                }
                //弹出剩余的括号
                nodeStack.pop();
                String root = nodeStack.pop();
                String[] split = sb.toString().split(",");
                String left = split[0];
                String right = split[1];

                nodeStack.push(left + root + right);

            } else {
                if(c == '{') {
                    stack.push(nodeStack.size());
                }
                nodeStack.push(String.valueOf(c));
            }
        }
        System.out.println(nodeStack.pop());
    }
}
