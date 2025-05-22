package com.huawei.n2025a;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/31 23:40
 */
public class UserInvoke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] usage = new int[n][3];
        int max = 0;
        int min = 0;
        for (int i = 0; i < usage.length; i++) {
            usage[i][0] = scanner.nextInt();
            usage[i][1] = scanner.nextInt();
            usage[i][2] = scanner.nextInt();
            max += Math.max(Math.max(usage[i][0], usage[i][1]), usage[i][2]);
            min += Math.min(Math.min(usage[i][0], usage[i][1]), usage[i][2]);
        }
        int[] select = new int[usage.length];
        Arrays.fill(select, -1);
        while (min < max) {
            int mid = (max + min) / 2;
            Arrays.fill(select, -1);
            if (canDo(0,mid, usage,select)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min);
    }

    private static boolean canDo(int index,int mid, int[][] usage, int[] select) {
        if (index == usage.length) {
            return true;
        }
        for (int j = 0; j < 3; j++) {
            if (index > 0 && j == select[index - 1] || usage[index][j] > mid) {
                continue;
            }
            if (usage[index][j] <= mid) {
                select[index] = j;
                mid -= usage[index][j];
                if (canDo(index + 1, mid, usage, select)) {
                    return true;
                }
                mid += usage[index][j];
                select[index] = -1;
            }
        }
        return false;
    }

}
