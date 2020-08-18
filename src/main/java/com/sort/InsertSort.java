package com.sort;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com.sort
 * @date:2020/7/27
 * @time:17:16
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] ints = {7, 2, 4, 5, 8, 3, 45, 54, 32};
        //i从开始 因为插入排序默认第一个数是以及排好的序列
        for (int i = 1; i < ints.length; i++) {
            int mix = ints[i];
            int j = i - 1;
            for (; j >= 0; j--){
                if (mix < ints[j]){
                    ints[j+1] = ints[j];
                }else {
                    break;
                }
                ints[j] = mix;
            }
            System.out.println("第"+i+"次排序： "+Arrays.toString(ints));
        }
    }
}
