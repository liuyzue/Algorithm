package com.huawei.n2025a;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/31 16:43
 */
public class TreeNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        int[] nums = new int[split.length + 1];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i - 1]);
        }

        int minIndex = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (i * 2 + 1 < nums.length && nums[i * 2 + 1] != -1) continue;
            if (i * 2 < nums.length && nums[i * 2] != -1) continue;
            if (nums[i] >= 0 && nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append(min);
        while (minIndex > 1) {
            minIndex = minIndex / 2;
            sb.insert(0," ").insert(0,nums[minIndex]);
        }

        System.out.println(sb);
    }
}
