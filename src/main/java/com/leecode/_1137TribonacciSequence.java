package com.leecode;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com.leecode
 * @date:2020/7/27
 * @time:15:07
 */
public class _1137TribonacciSequence {
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

    public int tribonacci(int n){
        if (n < 0 || n > 37) {
            return 0;
        }
        int n0 = 0, n1 = 1, n2 = 1;
        if (n == 0){
            return n0;
        } else if (n < 3){
            return n1;
        } else {
            for (int i = 3; i <= n ; i++) {
                int cache = n0 + n1 + n2;
                n0 = n1;
                n1 = n2;
                n2 = cache;
            }
            return n2;
        }
    }

}
