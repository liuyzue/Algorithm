package com.leecode;

import com.test.Main;

import java.util.Set;

/**
 * @author liuyuze
 * @date 2025/5/6 13:59
 */
public class _0011MaxArea {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int max = 0;
        int front = 0;
        int rear = height.length - 1;
        while (front < rear) {
            int area = (rear - front) * Math.min(height[rear], height[front]);
            max = Math.max(area, max);
            if (height[rear] > height[front]) {
                front++;
            } else {
                rear--;
            }
        }
        return max;
    }
}
