package com.leecode;

/**
 * @author liuyuze
 * @date 2025/5/15 16:47
 */
public class _2177SumOfThree {
    public long[] sumOfThree(long num) {
        long mid = num / 3;
        long first = mid - 1;
        long last = mid + 1;

        if (mid + first + last == num) {
            return new long[]{first, mid, last};
        }

        return new long[0];
    }
}
