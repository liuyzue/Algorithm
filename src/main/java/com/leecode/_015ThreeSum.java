package com.leecode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com
 * @date:2020/6/12
 * @time:7:40
 */
public class _015ThreeSum {
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *  
     *
     * 示例：
     *
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++ ){
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j < n - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int k = n - 1;
                int target = - nums[i] - nums[j];
                while (k > j && target < nums[k]) {
                    --k;
                }
                if (j == k) {
                    break;
                }
                if (target == nums[k]) {
                    List<Integer> resultList = new ArrayList<>();
                    resultList.add(nums[i]);
                    resultList.add(nums[j]);
                    resultList.add(nums[k]);
                    list.add(resultList);
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++ ){
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int firstResult = - nums[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                if (nums[left] + nums[right] == firstResult) {
                    List<Integer> resultList = new ArrayList<>();
                    resultList.add(nums[i]);
                    resultList.add(nums[left]);
                    resultList.add(nums[right]);
                    list.add(resultList);
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > firstResult) {
                    right--;
                } else if (nums[left] + nums[right] < firstResult) {
                    left++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum1(nums));
    }
}
