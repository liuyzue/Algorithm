package com.leecode;

import java.util.Arrays;

public class _1953NumberOfWeeks {
    public long numberOfWeeks(int[] milestones) {

        long maxWork = milestones[0];
        long number = 0;
        for (int milestone : milestones) {
            maxWork = Math.max(maxWork, milestone);
            number+=milestone;
        }
        long rest = number - maxWork;
        if (rest + 1 >= maxWork) {
            return rest + maxWork;
        } else {
            return rest * 2 + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new _1953NumberOfWeeks().numberOfWeeks(new int[]{1,2,3,5,6,6,7}));
    }
}
