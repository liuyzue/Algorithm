package com.huawei;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/14 13:42
 */
public class MaxResponseTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int minReceiveTime = Integer.MAX_VALUE;
        for (int i = 0; i < num; i++) {
            int sendTime = scanner.nextInt();
            int receiveTime = scanner.nextInt();
            if (receiveTime >= 128) {
                receiveTime = ((receiveTime & 15) | 0x10) << ((receiveTime >> 4) & 7) + 3;
            }
            minReceiveTime = Math.min(minReceiveTime, sendTime + receiveTime);
        }
        System.out.println(minReceiveTime);
    }
}
