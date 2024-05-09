package com.leecode;

import java.util.Arrays;

public class _0274HIndex {
    public int hIndex(int[] citations) {
        int hIndex = 0;
        int n = citations.length;
        Arrays.sort(citations);
        for (int i = 1; i <= citations[n - 1] && i <= n; i++) {
            for (int j = 0; j < n; j++) {
                int citation = citations[j];
                if (i <= citation && n - j >= i) {
                    hIndex = Math.max(hIndex, i);
                }
            }
        }
        return hIndex;
    }

    public int hIndex1(int[] citations) {
        int hIndex = 0;
        int n = citations.length - 1;
        Arrays.sort(citations);
        while (n >= 0 && hIndex < citations[n]) {
            hIndex++;
            n--;
        }
        return hIndex;
    }

    public static void main(String[] args) {
        System.out.println(new _0274HIndex().hIndex1(new int[]{1}));
    }
}
