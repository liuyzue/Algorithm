package com.huawei.n2025a;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/28 11:11
 */
public class BestPlantPlace {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] places = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            places[i] = scanner.nextInt();
            min = Math.min(min, places[i]);
            max = Math.max(max, places[i]);
        }
        int num = scanner.nextInt();
        Arrays.sort(places);
        //n颗树时，2棵树之间的最大距离为 n-1等分点的位置
        int maxDistance = (max - min) / (num - 1);
        while (maxDistance > 0) {

            int curIndex = 0;
            int plantNum = 1;
            for (int i = 1; i < places.length; i++) {
                if (places[i] - places[curIndex] >= maxDistance) {
                    plantNum++;
                    curIndex = i;
                }
            }
            if (plantNum >= num) {
                System.out.println(maxDistance);
                return;
            }
            maxDistance--;
        }

    }
}
