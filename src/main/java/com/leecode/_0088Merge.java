package com.leecode;

public class _0088Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) {
            return;
        }
        int length = nums1.length;
        int index1 = m - 1;
        int index2 = n - 1;
        for (int i = 0; i < length; i++) {
            if (index2 >= 0 && index1 >= 0) {
                if (nums1[index1] > nums2[index2]) {
                    nums1[length - 1 - i] = nums1[index1--];
                } else {
                    nums1[length - 1 - i] = nums2[index2--];
                }
            } else if (index2 >= 0){
                nums1[length - 1 - i] = nums2[index2--];
            } else if (index1 >= 0) {
                nums1[length - 1 - i] = nums1[index1--];
            }
        }
    }
}
