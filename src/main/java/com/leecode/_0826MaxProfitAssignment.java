package com.leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _0826MaxProfitAssignment {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxProfit = 0;
        /*Map<Integer, Integer> difficultyIndexMap = new HashMap<>();
        for (int i = 0; i < difficulty.length; i++) {
            difficultyIndexMap.put(difficulty[i], i);
        }
        Arrays.sort(difficulty);
        Arrays.sort(worker);
        if (worker[worker.length - 1] < difficulty[0]) {
            return 0;
        }*/
        for (int i = 0; i < worker.length; i++) {
            int singleProfit = 0;
            for (int j = 0; j < difficulty.length ; j++) {
                if (worker[i] >= difficulty[j]) {
                    singleProfit = Math.max(singleProfit, profit[j]);
                }
            }
            maxProfit += singleProfit;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new _0826MaxProfitAssignment().maxProfitAssignment(new int[]{66,1,28,73,53,35,45,60,100,44,59,94,27,88,7,18,83,18,72,63},
                new int[]{66,20,84,81,56,40,37,82,53,45,43,96,67,27,12,54,98,19,47,77},
                new int[]{61,33,68,38,63,45,1,10,53,23,66,70,14,51,94,18,28,78,100,16}));
    }
}
