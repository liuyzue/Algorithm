package com.huawei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuyuze
 * @date 2025/3/17 10:12
 */
public class EmptyStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        List<Integer> stack = new ArrayList<>();
        stack.add(Integer.parseInt(split[0]));
        for (int i = 1; i < split.length; i++) {
            int item = Integer.parseInt(split[i]);
            int sum = 0;
            for (int j = stack.size() - 1; j >= 0; j--) {
                sum += stack.get(j);
                if (sum == item) {
                    stack.set(j, item * 2);
                    stack = stack.subList(0,j + 1);
                    break;
                }
                if (sum > item || j == 0) {
                    stack.add(item);
                    break;
                }

            }
        }

        System.out.println(stack.stream().map(String::valueOf).collect(Collectors.joining(" ")));

    }
}
