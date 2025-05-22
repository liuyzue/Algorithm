package com.huawei;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/14 15:27
 */
public class LongestSublist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int sum = scanner.nextInt();
        String[] numStrs = s.split(",");
        int left = 0;
        int right = 0;
        int tempSum = 0;
        int maxLength = -1;
        while (right <= numStrs.length && left < numStrs.length) {
            if (tempSum < sum) {
                if (right == numStrs.length) {
                    System.out.println(-1);
                    return;
                }
                tempSum += Integer.parseInt(numStrs[right]);
                right++;
            }
            if (tempSum == sum) {
                maxLength = Math.max(maxLength, right - left);
                left++;
            }
            if (tempSum > sum) {
                tempSum -= Integer.parseInt(numStrs[left]);
                left++;
            }
            if (right < left) {
                right = left;
            }
        }
        System.out.println(maxLength);
    }
}
