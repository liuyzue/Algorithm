package com.leecode;

public class _0125IsPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] charArray = s.toCharArray();
        int i = 0, j = charArray.length - 1;
        while (i < j){
            boolean first = Character.isLetterOrDigit(charArray[i]);
            if (!first) {
                ++i;
            }
            boolean last = Character.isLetterOrDigit(charArray[j]);
            if (!last) {
                --j;
            }
            if (first && last) {
                if (charArray[i] != charArray[j]) {
                    return false;
                }
                ++i;--j;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _0125IsPalindrome().isPalindrome(".1231,"));
    }

}
