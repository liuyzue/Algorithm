package com.huawei;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/14 22:44
 */
public class Shitanggongcan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        int preRead = scanner.nextInt();
        int[] persons = new int[time];
        for (int i = 0; i < time; i++) {
            persons[i] = scanner.nextInt();
        }
        int speed = 0;
        int count = 0;
        while (preRead > 0 && count < time) {
            preRead -= persons[count++];
        }
        if (preRead < 0) {
            preRead = -preRead;
            int thisTime = count - 1;
            int r = preRead % thisTime;
            speed = (preRead + r) / thisTime;
        }
        int more = preRead;
        for (int i = count; i < time; i++) {
            more = more + persons[count];
            while (speed * count < more) {
                speed++;
            }
            count++;
        }
        System.out.println(speed);
    }
}
