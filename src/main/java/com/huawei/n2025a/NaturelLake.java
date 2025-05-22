package com.huawei.n2025a;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/27 21:58
 */
public class NaturelLake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] split = str.split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        if (nums.length < 2) {
            System.out.println(0);
            return;
        }
        int max = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int lower = Math.min(nums[i], nums[j]);
                int total = 0;
                for (int k = i + 1; k < j; k++) {
                    total += lower - nums[k];
                }
                if (total > max) {
                    max = total;
                    left = i;
                    right = j;
                }
            }
        }
        if (max > 0){
            System.out.println(left + " " + right + ":" + max);
        } else {
            System.out.println(0);
        }
    }
}
