package com.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyuze
 * @date 2025/4/8 11:19
 */
public class _0120TriangleMinRoadSum {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> triangle1 = new ArrayList<>();
        List<Integer> triangle2 = new ArrayList<>();
        List<Integer> triangle3 = new ArrayList<>();
        List<Integer> triangle4 = new ArrayList<>();
        triangle1.add(2);
        triangle2.add(3);
        triangle2.add(4);
        triangle3.add(6);
        triangle3.add(5);
        triangle3.add(7);
        triangle4.add(4);
        triangle4.add(1);
        triangle4.add(8);
        triangle4.add(3);

        triangle.add(triangle1);
        triangle.add(triangle2);
        triangle.add(triangle3);
        triangle.add(triangle4);

        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dpList = new ArrayList<>();
        dpList.add(new ArrayList<>(triangle.get(0)));
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> lastDp = dpList.get(i - 1);
            List<Integer> level = triangle.get(i);
            List<Integer> dpNext = new ArrayList<>();
            for (int j = 0; j < level.size(); j++) {
                if (j == 0) {
                    dpNext.add(lastDp.get(j) + level.get(j));
                } else if (j < lastDp.size()){
                    dpNext.add(level.get(j) + Math.min(lastDp.get(j - 1), lastDp.get(j)));
                } else {
                    dpNext.add(level.get(j) + lastDp.get(j - 1));
                }
            }
            dpList.add(dpNext);
        }
        for (Integer i : dpList.get(dpList.size() - 1)) {
            min = Math.min(min, i);
        }
        return min;
    }
}
