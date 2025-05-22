package com.leecode;

/**
 * @author liuyuze
 * @date 2025/5/7 16:52
 */
public class _0209MinSubArrayLen {

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * 示例 2：
     *
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     * 示例 3：
     *
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     *
     *
     * 提示：
     *
     * 1 <= target <= 109
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 104
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        if (nums.length < 2) {
            if (nums.length == 1 && nums[0] >= target) {
                return 1;
            } else {
                return 0;
            }
        }
        int slow = 0;
        int fast = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while (slow < nums.length) {
            if (sum < target) {
                if (fast == nums.length) {
                    break;
                }
                sum += nums[fast];
                fast++;
            } else {
                len = Math.min(len, fast - slow);
                sum -= nums[slow];
                slow++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1}));
    }
}
