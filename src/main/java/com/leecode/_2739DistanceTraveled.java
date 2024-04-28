package com.leecode;

public class _2739DistanceTraveled {

    public int distanceTraveled(int mainTank, int additionalTank) {
        int count = 0;
        while (mainTank > 0) {
            ++count;
            if (count % 5 == 0 && additionalTank > 0) {
                --additionalTank;
            } else {
                --mainTank;
            }
        }
        return count * 10;
    }
}
