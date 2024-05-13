package com.leecode;

public class _2391GarbageCollection {
    public int garbageCollection(String[] garbage, int[] travel) {
        int count = 0;
        int indexM = 0,indexP = 0, indexG = 0;
        for (int i = 0; i < garbage.length; i++) {
            String garbageStr = garbage[i];
            char[] garbages = garbageStr.toCharArray();
            for (char c : garbages) {
                if (c == 'M') {
                    count++;
                    indexM = i;
                }
                if (c == 'P') {
                    count++;
                    indexP= i;
                }
                if (c == 'G') {
                    count++;
                    indexG= i;
                }
            }
        }
        for (int i = 0; i < travel.length; i++) {
            if (i < indexG) {
                count+=travel[i];
            }
            if (i < indexP) {
                count+=travel[i];
            }
            if (i < indexM) {
                count+=travel[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new _2391GarbageCollection().garbageCollection(new String[]{"G","P","GP","GG"},new int[]{2,4,3}));
    }
}
