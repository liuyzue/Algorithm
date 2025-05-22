package com.huawei.n2025a;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/27 23:44
 */
public class HuangDaoQiuSheng {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        if (split.length > 30000) {
            System.out.println(-1);
            return;
        }
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
            if (nums[i] == 0) {
                System.out.println(-1);
                return;
            }
        }

        int total = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                continue;
            }
            if (nums[i] < 0){
                int left = nums[i];
                for (int j = i - 1; j >= 0 ; j--) {
                    if (nums[j] == 0) {
                        continue;
                    }
                    int battle = nums[j] + left;
                    if (battle < 0){
                        nums[j] = 0;
                        total--;
                        left = battle;
                    } else if (battle == 0) {
                        nums[j] = battle;
                        total -= 2;
                        break;
                    } else {
                        total--;
                        nums[j] = battle;
                        break;
                    }
                }
                nums[i] = 0;
            }
        }
        System.out.println(total);
    }
}
