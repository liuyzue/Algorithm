package com.leecode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com.leecode
 * @date:2020/7/27
 * @time:15:49
 */
public class KthSymbolGrammar {
    /**
     * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
     *
     * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
     *
     * 例子:
     * 输入: N = 1, K = 1
     * 输出: 0
     * 输入: N = 2, K = 1
     * 输出: 0
     * 输入: N = 2, K = 2
     * 输出: 1
     * 输入: N = 4, K = 5
     * 输出: 1
     * 解释:
     * 第一行: 0
     * 第二行: 01
     * 第三行: 0110
     * 第四行: 01101001
     * 注意：
     * N 的范围 [1, 30].
     * K 的范围 [1, 2^(N-1)].
     */
    public int symbolGrammar(int N , int K){
        if (N < 1 || N > 30 || K < 1 || K > 2 << N - 1){
            return 0;
        }
        int[] data = {0};
        if (N == 1){
            return data[0];
        }
        data = exec(data,N);
        return data[K-1];

    }
    public int[] exec(int[] data , int n){
        int[] result =new int[data.length << 1];
        int len = 0;
        for (int c :
                data) {
            if (c == 0){
                result[len++] = 0;
                result[len++] = 1;
            } else if (c == 1){
                result[len++] = 1;
                result[len++] = 0;
            }
        }
        if (n == 1){
            System.out.println(Arrays.toString(result));
            return result;
        }
        //System.out.println(Arrays.toString(result));
        return exec(result,n-1);
    }
}
