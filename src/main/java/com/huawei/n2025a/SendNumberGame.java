package com.huawei.n2025a;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/28 15:16
 */
public class SendNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            boolean isOk = false;
            //数学性质  x%b == y%b  则 （x-y）%b == 0
            //所以如果有2个子串的和与m的余数相同，那么后面的子串减去前面的子串，剩余的部分就可以满足要求
            boolean[] cache = new boolean[m];
            int sum = 0;
            for (int num : nums) {
                sum += num;
                int x = sum % m;
                if (cache[x] == true) {
                    System.out.println(1);
                    isOk = true;
                    break;
                } else {
                    cache[x] = true;
                }
            }
            if (!isOk) {
                System.out.println(0);
            }
        }

    }
}
