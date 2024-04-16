package com.leecode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class _0169MajorityElement {
    public int majorityElement(int[] nums) {

        int[] sortedNums = Arrays.stream(nums).sorted().toArray();

        return sortedNums[sortedNums.length/2];
    }

    public int majorityElement1(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(new _0169MajorityElement().majorityElement1(new int[]{1,1,2,3,1,2,1,1,4,1,5}));
    }
}
