package com.leecode;

import java.util.Arrays;

public class _0238ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        Arrays.fill(L, 1);
        Arrays.fill(R, 1);
        L[0] = 1;
        R[res.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = L[i] * R[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = new _0238ProductExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4});

       Arrays.stream(ints).boxed().forEach(System.out::println);
    }
}
