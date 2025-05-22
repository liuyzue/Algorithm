package com.leecode;

/**
 * @author liuyuze
 * @date 2025/5/6 13:44
 */
public class _0167TwoSum {

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 17);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
    public static int[] twoSum(int[] numbers, int target) {
        int front = 1;
        int rear = numbers.length;
        while (front < rear && numbers[front - 1] + numbers[rear - 1] != target) {
            if (numbers[front - 1] + numbers[rear - 1] < target) {
                front++;
            } else {
                rear--;
            }
        }
        return new int[]{front,rear};
    }
}
