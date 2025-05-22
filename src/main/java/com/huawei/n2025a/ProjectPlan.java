package com.huawei.n2025a;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/4/1 11:41
 */
public class ProjectPlan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
            max += nums[i];
        }
        int n = scanner.nextInt();
        int min = 0;
        while (min < max) {
            int mid = (max + min) / 2;
            boolean[] select = new boolean[nums.length];
            int[] cost = new int[n];
            if (find(0,nums, mid, cost, select)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min);
    }

    private static boolean find(int index, int[] nums, int mid, int[] cost, boolean[] select) {

        for (int i = 0; i < cost.length; i++) {
            if (select[index]) {
                continue;
            }
            if (cost[i] + nums[index] > mid) {
                continue;
            }
            cost[i] += nums[index];
            select[index] = true;
            if (find(index + 1, nums, mid, cost, select)) {
                return true;
            }
            cost[i] -= nums[index];
            select[i] = false;
        }
        return false;
    }
}
