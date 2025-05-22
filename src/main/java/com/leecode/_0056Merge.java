package com.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author liuyuze
 * @date 2025/5/9 16:14
 */
public class _0056Merge {

    /**
     * 56. 合并区间
     * 中等
     * 相关标签
     * 相关企业
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2：
     *
     * 输入：intervals = [[1,4],[4,5]]
     * 输出：[[1,5]]
     * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *
     *
     * 提示：
     *
     * 1 <= intervals.length <= 104
     * intervals[i].length == 2
     * 0 <= starti <= endi <= 104
     * @param intervals
     * @return
     */
    public static int[][] merge1(int[][] intervals) {
        List<int[]> mergeList = new ArrayList<>();
        mergeList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] startInterval = mergeList.get(mergeList.size() - 1);
            int[] interval = intervals[i];
            if ((startInterval[0] <= interval[0] && startInterval[1] >= interval[0])
                    || (startInterval[0] <= interval[1] && startInterval[1] >= interval[1])
                    || (startInterval[0] <= interval[0] && startInterval[1] >= interval[1])
                    || (interval[0] <= startInterval[0] && interval[1] >= startInterval[1])){
                startInterval[0] = Math.min(startInterval[0], interval[0]);
                startInterval[1] = Math.max(startInterval[1], interval[1]);
            } else {
                mergeList.add(interval);
            }
        }
        int[][] res = new int[mergeList.size()][];
        for (int i = 0; i < mergeList.size(); i++) {
            res[i] = mergeList.get(i);
        }
        return res;
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> mergeList = new ArrayList<>();
        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];
            if (mergeList.isEmpty() || mergeList.get(mergeList.size() - 1)[1] < l) {
                mergeList.add(new int[]{l, r});
            } else {
                mergeList.get(mergeList.size() - 1)[1] = Math.max(mergeList.get(mergeList.size() - 1)[1], r);
            }

        }
        return mergeList.toArray(new int[mergeList.size()][]);
    }

    public static void main(String[] args) {
        int[][] merge = merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        System.out.println(merge);
        merge = merge(new int[][]{{1, 4}, {4, 5}});
        System.out.println(merge);
        merge = merge(new int[][]{{1, 4}, {0, 4}});
        System.out.println(merge);
    }
}
