package com.leecode;

import java.util.*;

public class _0350Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int k : nums1) {
            map.put(k, map.getOrDefault(k , 0) + 1);
        }
        for (int j : nums2) {
            Integer count = map.get(j);
            if (count != null && count != 0) {
                res.add(j);
                map.put(j, --count);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        int[] intersect = new _0350Intersect().intersect(nums1, nums2);
        for (int i : intersect) {
            System.out.println(i);
        }
    }
}
