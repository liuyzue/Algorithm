package com.huawei;

import java.util.Map;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/26 7:00
 */
public class ChangeNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int g = 1 << n + k - 1;

        int slow = 0;
        int fast = slow;
        double result = 0;
        while (slow <= n) {
            int sum = 0;
            for (int i = 0; i < slow; i++) {
                sum += nums[i];
            }
            for (int i = slow; i <= fast && i < n; i++) {
                sum += (nums[i] + (nums[i] & m));
            }
            for (int i = fast + 1; i < n; i++) {
                sum += nums[i];
            }
            result += sum;
            fast++;
            if (fast >= n) {
                slow++;
                fast = slow;
            }
        }
        System.out.println(result / g % (Math.pow(10,9) + 7));
    }
}
