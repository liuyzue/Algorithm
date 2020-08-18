package com.leecode;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com
 * @date:2020/6/11
 * @time:21:55
 */
public class IsPalindrome {
    /**
     * 回文数
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if ( x<0 )
            return false;
        /*String tmp=String.valueOf(x);

        for (int i = 0; i < tmp.length()/2 ; i++){
            if (tmp.charAt(tmp.length()-1-i) != (tmp.charAt(i)))
                return false;
        }

        return true;*/
        long tmp = 0;  int num = x;
        do{
            tmp = tmp*10 + num%10;
            num = num/10;
        }while (num>0);

        return x==tmp;
    }
}
