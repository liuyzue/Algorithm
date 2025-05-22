package com.huawei.n2025a;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author liuyuze
 * @date 2025/3/28 9:29
 */
public class RemoveLeastBall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int total = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
            total += nums[i];
            max = Math.max(max,nums[i]);
        }
        if (total <= sum) {
            System.out.println("[]");
            return;
        }
        int x = total - sum;
        int last = x / n;
        int maxCapacity = max - (Math.max(last,1));
        int[] remove = new int[n];
        for (int capacity = maxCapacity; capacity > 0; capacity--) {
            int more = x;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > capacity) {
                    int num = nums[i] - capacity;
                    remove[i] = num;
                    more -= num;
                }
            }
            if (more <= 0) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < remove.length; i++) {
            sb.append(remove[i]).append(",");
        }
        sb.deleteCharAt(sb.length() - 1).append("]");
        System.out.println(sb);
    }
}
