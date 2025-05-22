package com.leecode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuyuze
 * @date 2025/5/15 16:01
 */
public class _0128LongestConsecutive {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longestConsecutive(new int[]{1,0,1,2}));
        System.out.println(longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));
        System.out.println(longestConsecutive(new int[]{0,1,2,4,8,5,6,7,9,3,55,88,77,99,999999999}));
    }
    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 1;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int length = 1;
                while (set.contains(num + 1)) {
                    num++;
                    length ++;
                }
                count = Math.max(count, length);
            }
        }

        return count;
    }
}
