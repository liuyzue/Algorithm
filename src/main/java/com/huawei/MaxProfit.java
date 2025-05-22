package com.huawei;

import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/13 9:33
 */
public class MaxProfit {

    public static void main(String[] args) {
        maxProfit();
    }
    public static void maxProfit() {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int days = scanner.nextInt();
        int[] items = new int[number];
        for (int i = 0; i < number; i++) {
            int num = scanner.nextInt();
            items[i] = num;
        }
        int[][] itemPrices = new int[number][days];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < days; j++) {
                int price = scanner.nextInt();
                itemPrices[i][j] = price;
            }
        }
        int maxProfit = 0;
        for (int i = 0; i < number; i++) {
            int itemProfit = 0;
            for (int j = 1; j < days; j++) {
                itemProfit += Math.max(0,itemPrices[i][j] - itemPrices[i][j-1]) * items[i];
            }
            maxProfit += itemProfit ;
        }

        System.out.println(maxProfit);
    }
}
