package com.leecode;

import java.util.Arrays;

/**
 * @author liuyuze
 * @date 2025/4/22 23:20
 */
public class _1561MaxCoins {

    public static void main(String[] args) {
        _1561MaxCoins maxCoins = new _1561MaxCoins();
        System.out.println(maxCoins.maxCoins(new int[]{2,4,5}));
    }
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int offset = 0;
        int sum = 0;
        int num = piles.length / 3;
        for (int i = piles.length - 1; i >= 0 && num > 0; i--) {
            if (offset == 1) {
                sum += piles[i];
                num--;
            }
            offset++;
            if (offset == 2) {
                offset = 0;
            }
        }
        return sum;
    }
}
