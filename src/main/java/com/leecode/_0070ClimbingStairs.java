package com.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 *
 * 提示：
 *
 * 1 <= n <= 45
 */
public class _0070ClimbingStairs {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int result = climbStairs3(45);

        long end = System.currentTimeMillis();

        System.out.println("result : " + result + "   time:" + (end - start));
    }


    public static int climbStairs0(int n) {
        int result = 0;
        if (n == 1) {
            result = 1;
        } else if (n == 2) {
            result = 2;
        } else {
            result = climbStairs0(n - 1)  + climbStairs0(n - 2);
        }
        return result;
    }




    public static Map<Integer, Integer> cache = new HashMap<>();
    public static int climbStairs1(int n) {
        int result = 0;
        if (n == 1) {
            result = 1;
            cache.put(1, result);
        } else if (n == 2) {
            result = 2;
            cache.put(2, result);
        } else {
            Integer resultLastOne = cache.get(n - 1) == null ? climbStairs1(n - 1) : cache.get(n - 1);
            Integer resultLastTwo = cache.get(n - 2) == null ? climbStairs1(n - 2) : cache.get(n - 2);
            result = resultLastOne + resultLastTwo;
            cache.put(n, result);
        }
        return result;
    }

    public int climbStairs2(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                cache.put(1, 1);
            } else if (i == 2) {
                cache.put(2, 2);
            } else {
                cache.put(i, cache.get(i - 1) + cache.get(i - 2));
            }
        }
        return cache.get(n);
    }

    public static int climbStairs3(int n) {
        int result = 1;
        int lastOne = 0;
        int lastTwo = 0;
        for (int i = 1 ; i <= n; i++) {
            lastTwo = lastOne;
            lastOne = result;
            result = lastTwo + lastOne;
        }
        return result;
    }

}
