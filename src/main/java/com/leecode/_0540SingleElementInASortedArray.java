package com.leecode;

public class _0540SingleElementInASortedArray {

    /**
     * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
     *
     * 请你找出并返回只出现一次的那个数。
     *
     * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,1,2,3,3,4,4,8,8]
     * 输出: 2
     * 示例 2:
     *
     * 输入: nums =  [3,3,7,7,10,11,11]
     * 输出: 10
     *
     *
     *
     * 提示:
     *
     * 1 <= nums.length <= 10^5
     * 0 <= nums[i] <= 10^5
     */
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid % 2 == 1) {
                if (nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (mid % 2 == 0) {
                if (mid == n - 1 || nums[mid] != nums[mid + 1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        _0540SingleElementInASortedArray singleElementInASortedArray = new _0540SingleElementInASortedArray();
        System.out.println(singleElementInASortedArray.singleNonDuplicate(new int[]{1,1,2,2,3,4,4,8,8}));
    }
}
