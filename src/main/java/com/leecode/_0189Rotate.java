package com.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _0189Rotate {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.reverse(list);
        List<Integer> subList = list.subList(0, k);
        List<Integer> subList1 = list.subList(k, list.size());
        Collections.reverse(subList);
        Collections.reverse(subList1);
        subList.addAll(subList1);

        for (int i = 0; i < subList.size(); i++) {
            nums[i] = subList.get(i);
        }
    }

    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int s, int e) {
        while (s < e) {
            int temp = nums[s];
            nums[s++] = nums[e];
            nums[e--] = temp;
        }
    }

    public static void main(String[] args) {
        new _0189Rotate().rotate1(new int[]{1, 2, 3, 4, 5}, 3);
    }


}
