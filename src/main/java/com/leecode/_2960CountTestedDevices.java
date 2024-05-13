package com.leecode;

public class _2960CountTestedDevices {
    public int countTestedDevices(int[] batteryPercentages) {
        int count = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            batteryPercentages[i] = Math.max(batteryPercentages[i] - count, 0);
            if (batteryPercentages[i] > 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new _2960CountTestedDevices().countTestedDevices(new int[]{0,1,2}));
    }
}
