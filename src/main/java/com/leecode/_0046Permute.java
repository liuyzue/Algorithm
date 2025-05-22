package com.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuyuze
 * @date 2025/4/23 13:56
 */
public class _0046Permute {

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        for (List<Integer> list : permute) {
            System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(",")));
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> arrayList = new ArrayList<>();
            arrayList.add(nums[0]);
            list.add(arrayList);
            return list;
        }
        //回溯
        findList(list, nums, new boolean[nums.length], new ArrayList<>());
        return list;
    }

    private static void findList(List<List<Integer>> list, int[] nums, boolean[] used, List<Integer> integers) {
        if (integers.size() == nums.length) {
            list.add(new ArrayList<>(integers));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                integers.add(nums[i]);
                used[i] = true;
                findList(list, nums, used, integers);
                integers.remove(integers.size() - 1);
                used[i] = false;
            }
        }
    }
}
