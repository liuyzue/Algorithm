package com.leecode;

import java.util.HashMap;
import java.util.Map;

public class _2244MinimumRounds {

    public int minimumRounds(int[] tasks) {
        int rounds = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        for (Integer value : map.values()) {
            int last = value % 3;
            if (last == 0) {
                rounds = rounds + value / 3;
            } else if (last == 1) {
                if (value > 3) {
                    rounds = rounds + value / 3 + 1;
                } else {
                    return -1;
                }
            } else if (last == 2) {
                rounds = rounds + value / 3 + 1;
            }
        }
        return rounds;
    }

    public static void main(String[] args) {
        System.out.println(new _2244MinimumRounds().minimumRounds(new int[]{2,2,3,3}));
    }
}
