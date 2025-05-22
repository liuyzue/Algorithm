package com.huawei.n2025a;

import java.util.*;

/**
 * @author liuyuze
 * @date 2025/3/31 16:17
 */
public class MinTimes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();
        int time = 0;
        boolean isHead = false;
        for (int i = 0; i < n * 2; i++) {
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            if ("head".equals(split[0])) {
                if (!deque.isEmpty() && !isHead) {
                    isHead = true;
                }
                deque.addFirst(Integer.parseInt(split[2]));
            } else if ("tail".equals(split[0])) {
                deque.offer(Integer.parseInt(split[2]));
            } else if ("remove".equals(split[0])) {
                if (isHead) {
                    time++;
                    isHead = false;
                }
                deque.pollFirst();
            }
        }
        System.out.println(time);
    }
}
