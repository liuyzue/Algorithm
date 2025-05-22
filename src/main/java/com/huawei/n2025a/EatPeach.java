package com.huawei.n2025a;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/30 23:32
 */
public class EatPeach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        int[] peaches = new int[split.length];
        int min = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < peaches.length; i++) {
            peaches[i] = Integer.parseInt(split[i]);
            max = Math.max(max,peaches[i]);
        }
        int h = scanner.nextInt();
        if (h < peaches.length) {
            System.out.println(0);
            return;
        }
        Arrays.sort(peaches);
        int mid;
        while (min < max) {
            mid = (min + max) / 2;
            int count = 0;
            for (int i = 0; i < peaches.length; i++) {
                if (peaches[i] <= mid) {
                    count++;
                } else {
                    count += peaches[i] / mid + (peaches[i] % mid == 0 ? 0 : 1);
                }
            }
            if (count > h) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        System.out.println(min);
    }
}
