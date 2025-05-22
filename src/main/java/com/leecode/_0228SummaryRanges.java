package com.leecode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuyuze
 * @date 2025/5/9 15:01
 */
public class _0228SummaryRanges {

    /**
     * 228. 汇总区间
     * 简单
     * 相关标签
     * 相关企业
     * 给定一个  无重复元素 的 有序 整数数组 nums 。
     *
     * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
     *
     * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
     *
     * "a->b" ，如果 a != b
     * "a" ，如果 a == b
     *
     *
     * 示例 1：
     *
     * 输入：nums = [0,1,2,4,5,7]
     * 输出：["0->2","4->5","7"]
     * 解释：区间范围是：
     * [0,2] --> "0->2"
     * [4,5] --> "4->5"
     * [7,7] --> "7"
     * 示例 2：
     *
     * 输入：nums = [0,2,3,4,6,8,9]
     * 输出：["0","2->4","6","8->9"]
     * 解释：区间范围是：
     * [0,0] --> "0"
     * [2,4] --> "2->4"
     * [6,6] --> "6"
     * [8,9] --> "8->9"
     *
     *
     * 提示：
     *
     * 0 <= nums.length <= 20
     * -231 <= nums[i] <= 231 - 1
     * nums 中的所有值都 互不相同
     * nums 按升序排列
     * @param nums
     * @return
     */
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(String.valueOf(nums[0]));
            return result;
        }
        int start = nums[0];
        int current = nums[0];
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num - current == 1) {
                current = num;
                if (i < nums.length - 1) {
                    continue;
                }
            }
            if (current != start) {
                result.add(start + "->" + current);
                last = current;
            } else {
                result.add(String.valueOf(start));
                last = start;
            }
            start = num;
            current = num;
        }
        if (last != current) {
            result.add(String.valueOf(current));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> strings = summaryRanges(new int[]{0,2,3,4,6,8,9});
        System.out.println(strings.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }
}
