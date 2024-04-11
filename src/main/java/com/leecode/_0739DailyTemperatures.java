package com.leecode;

import java.util.Stack;

public class _0739DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0;i < temperatures.length; i++) {
            if (stack.empty()) {
                stack.push(temperatures[i]);
            }
            Integer pop = stack.peek();
            if (null != pop && pop < temperatures[i]) {
                stack.push(temperatures[i]);
                result[i - stack.size() + 1]++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(dailyTemperatures(new int[]{1,2,3,4,7,8,5,4,2,1,5,9,5,4,2}));
    }

}
