package com.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/12 15:28
 */
public class CountQuack {

    public static void countQuack() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] chars = input.toCharArray();
        boolean hasQuack = true;
        int total = 0;
        String quack = "quack";
        while (hasQuack) {
            int[] state = new int[5];
            Arrays.fill(state, -1);
            int count = 0;
            hasQuack = false;
            for (int i = 0; i < chars.length; i++) {
                int index = quack.indexOf(chars[i]);
                if (index < 0 || (index > 0 && state[index - 1] == -1)) {
                    continue;
                }

                if (state[index] == -1) {
                    state[index] = i;
                    count++;
                }
                if (count == 5) {
                    hasQuack = true;
                    for (int j = 0; j < state.length; j++) {
                        chars[state[j]] = ' ';
                        state[j] = -1;
                    }
                    count = 0;
                }
            }
            if (hasQuack) {
                total++;
            }
        }
        System.out.println(total == 0 ? -1 : total);
    }

    public static void main(String[] args) {
        countQuack();
    }
}
