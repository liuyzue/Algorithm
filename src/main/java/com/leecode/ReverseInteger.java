package com.leecode;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com.leecode
 * @date:2020/7/21
 * @time:10:47
 */
public class ReverseInteger {
    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 示例 1:
     * 输入: 123
     * 输出: 321
     *  示例 2:
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * 输入: 120
     * 输出: 21
     * 注意:
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2`31,  2`31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     */
    public static int reverseInteger(int x){
        if (x==0){
            return 0;
        }
        long result = 0;
        while (x!=0){
            int tmp = x%10 ;
            result = result*10 + tmp;
            x/=10;
        }
        if (result > Integer.MAX_VALUE || result<Integer.MIN_VALUE){
            return 0;
        }
        return (int) result;
    }

    public static int reverseInteger2(int x){
        if (x==0){
            return 0;
        }
        int result = 0;
        while (x!=0){
            int tmp = x%10 ;
            if (result > 0 && (result > Integer.MAX_VALUE/10 || result*10 > Integer.MAX_VALUE - tmp)){
                return 0;
            }
            if (result < 0 && (result < Integer.MIN_VALUE/10 || result*10 < Integer.MIN_VALUE - tmp)){
                return 0;
            }
            result = result*10 + tmp;
            x/=10;
        }
        return result;
    }
}
