package com.leecode;

/**
 * @author liuyz@sunwayworld.com 2020年09月29日
 */
public class Poxxn {
    public static double pox(double x, int n){
        double result = x;

        for (int i = 0; i < n-1; i++){
            result *= x;
        }

        return result;
    }
}
