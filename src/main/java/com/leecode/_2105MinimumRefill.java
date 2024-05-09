package com.leecode;

import java.util.Arrays;

public class _2105MinimumRefill {

    /**
     * 不控制步数，更小结果
     */
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int sum = Arrays.stream(plants).sum();
        if (capacityA >= sum || capacityB >= sum) {
            return 0;
        }
        int[] isWater = new int[plants.length];
        int minimum = 0;
        int left = 0;
        int right = plants.length - 1;
        int waterA = capacityA;
        int waterB = capacityB;
        while (left <= right) {
            if (waterA < plants[left] && isWater[left] == 0) {
                waterA = capacityA;
                minimum++;
            }
            while (waterA >= plants[left]) {
                waterA -= plants[left];
                isWater[left] = 1;
                left++;
            }
            if (waterB < plants[right] && isWater[right] == 0) {
                waterB = capacityB;
                minimum++;
            }
            while (waterB >= plants[right]) {
                waterB -= plants[right];
                isWater[right] = 1;
                right--;
            }
        }

        return minimum;
    }

    /**题目正解
     */
    public int minimumRefill1(int[] plants, int capacityA, int capacityB) {
        int minimum = 0;
        int left = 0;
        int right = plants.length - 1;
        int waterA = capacityA;
        int waterB = capacityB;
        while (left <= right) {
            if (waterA >= plants[left]) {
                waterA -= plants[left];
            } else {
                waterA = capacityA - plants[left];
                minimum++;
            }
            left++;
            if (waterB >= plants[right]) {
                waterB -= plants[right];
            } else {
                waterB = capacityB - plants[right];
                minimum++;
            }
            right--;

            if (left == right) {
                if (waterA >= plants[left] || waterB >= plants[right]) {
                    return minimum;
                } else {
                    return ++minimum;
                }
            }
        }
        return minimum;
    }

    public static void main(String[] args) {
        System.out.println(new _2105MinimumRefill().minimumRefill1(new int[]{493,980,689,776,932,7}, 990, 1570));
    }
}
