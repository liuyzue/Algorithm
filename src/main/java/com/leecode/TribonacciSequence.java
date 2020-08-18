package com.leecode;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com.leecode
 * @date:2020/7/27
 * @time:15:07
 */
public class TribonacciSequence {
/**
 * The Tribonacci sequence Tn is defined as follows: 
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 * Example 1:
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * Example 2:
 *
 * Input: n = 25
 * Output: 1389537
 *
 * Constraints:
 * 0 <= n <= 37
 * The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 */
    static int[] data = new int[40];

    public int tribonacci(int n){
        if (n>=0 && n <= 37){

            if (n == 0){
                return 0;
            } else if (n < 3){
                return 1;
            }
            if (data[n]>0){
                return data[n];
            }
            int res = tribonacci(n-3) + tribonacci(n-2) + tribonacci(n-1);
            data[n] = res;
            return res;
        }
        return 0;
    }

}
