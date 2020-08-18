package com.leecode;

import java.util.*;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com
 * @date:2020/6/12
 * @time:7:40
 */
public class ThreeSum {
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
    public List<List<Integer>> threeSum(int[] nums) {
        List list = new ArrayList();
        Set p = new HashSet();
        for (int i = 0 ; i < nums.length ; i++){
            for (int j = i+1 ; j< nums.length ; j++){
                for (int k = j + 1 ;k < nums.length ; k++)
                if ((nums[i]+nums[j]+nums[k])==0){
                    List<Integer> res = new ArrayList<Integer>();

                    res.add(nums[i]);res.add(nums[j]);res.add(nums[k]);
                    res.sort(new Comparator<Integer>() {
                        public int compare(Integer o1, Integer o2) {
                            return o1-o2;
                        }
                    });
                    p.add(res);
                }
            }
        }
        list.addAll(p);
        return list;
    }
}
