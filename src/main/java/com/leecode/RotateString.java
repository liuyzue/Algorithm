package com.leecode;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author create by lyz
 * @version: v1.0
 * @description: com
 * @date:2020/6/10
 * @time:10:59
 */
public class RotateString {
    /**
     * 原地自旋
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public static char[] rotateString(char[] str, int offset) {
        // write your code here
        if (offset >0 && str.length>0){
            offset = offset%str.length;
            for (int i = 0;i < offset ;i++ ){
                char tep = str[str.length-1];
                for(int j = str.length; j > 1 ; j--){
                    str[j-1] = str[j-2];
                }
                str[0] = tep;
            }
        }
        return str;
    }
}
