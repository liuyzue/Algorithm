package com.leecode;

public class _0035SearchInsertPosition {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 请必须使用时间复杂度为 O(log n) 的算法。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     * 示例 2:
     *
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     * 示例 3:
     *
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     *
     *
     * 提示:
     *
     * 1 <= nums.length <= 10^4
     * -10^4 <= nums[i] <= 10^4
     * nums 为 无重复元素 的 升序 排列数组
     * -10^4 <= target <= 10^4
     */
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right){
            int mid = (right + left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,5,7};

        _0035SearchInsertPosition searchInsertPosition = new _0035SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(nums, 9));
    }
}
