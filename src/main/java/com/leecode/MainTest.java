package com.leecode;

import org.junit.Test;

import java.util.Date;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com.leecode
 * @date:2020/7/21
 * @time:14:39
 */
public class MainTest {

    @Test
    public void romanToIntegerTest(){
        RomanToInteger rm = new RomanToInteger();
        System.out.println(rm.romanToInt("IVV"));
    }

    @Test
    public void longestCommonPrefix(){
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String comm = lcp.longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println(comm);
    }

    @Test
    public void testFibonacci(){
        FibonacciSequence fibonacciSequence = new FibonacciSequence();

        for (int i =1 ; i <= 45;i++) {
            Date date1 = new Date();
            System.out.print("n="+ i +" : "+ fibonacciSequence.fibonacci3(i));
            Date date2 = new Date();
            System.out.print(" "+(date2.getTime() - date1.getTime()) + " ms");
            System.out.println();
        }
    }

    @Test
    public void testFac(){
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        /*for (int i=0;i<=10;i++) {
            System.out.println("n="+i+" : "+fibonacciSequence.tailFac(1,i));
        }*/
        System.out.println(fibonacciSequence.fibonacci4(1, 0, 10));
    }

    @Test
    public void testTribonacciSequence(){
        _1137TribonacciSequence a1137TribonacciSequence = new _1137TribonacciSequence();
        for (int i = 0;i < 39 ; i++) {
            System.out.println("n="+i+" : "+ a1137TribonacciSequence.tribonacci(i));
        }
    }

    @Test
    public void testKthSymbolGrammar(){
        KthSymbolGrammar kthSymbolGrammar = new KthSymbolGrammar();
        System.out.println(kthSymbolGrammar.symbolGrammar(20, 4));
    }

    @Test
    public void testRemoveDuplicatesFromSortedArray(){
        RemoveDuplicatesFromSortedArray array = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1,1,2};
        System.out.println(array.removeDuplicates(nums));
    }

    @Test
    public void testPoxXN(){
        double d = 2;
        double result = Poxxn.pox(d,10) ;
        System.out.println(result);
    }

}
