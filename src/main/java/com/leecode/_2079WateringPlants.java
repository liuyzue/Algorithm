package com.leecode;

public class _2079WateringPlants {

    public int wateringPlants(int[] plants, int capacity) {
        int stepNum = 0;
        int water = capacity;
        for (int i = 0; i < plants.length; i++) {
            stepNum++;
            if (water < plants[i]) {
                stepNum = stepNum + ((i + 1 ) << 1) - 2;
                water = capacity;
            }
            water -= plants[i];
        }
        return stepNum;
    }

    public static void main(String[] args) {
        System.out.println(new _2079WateringPlants().wateringPlants(new int[]{7}, 4));
    }
}
