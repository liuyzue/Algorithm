package com.leecode;


public class _1702MaximumBinaryString {

    public String maximumBinaryString(String binary) {
        char[] charArray = binary.toCharArray();
        int zeroIndex = charArray[0] == '0' ? 0 : -1;
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == '0') {
                if (charArray[i - 1] == '0') {
                    charArray[i - 1] = '1';
                    zeroIndex = i;
                    continue;
                }
                if (zeroIndex == -1) {
                    zeroIndex = i;
                } else {
                    charArray[zeroIndex] = '1';
                    charArray[zeroIndex + 1] = '0';
                    charArray[i] = '1';
                    zeroIndex = zeroIndex + 1;
                }
            }
        }
        return String.valueOf(charArray);
    }

    public String maximumBinaryString1(String binary) {
        char[] charArray = binary.toCharArray();
        int start0 = binary.indexOf('0');
        int zeroCount = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '0') {
                zeroCount++;
                if (zeroCount > 1) {
                    charArray[i] = '1';
                }
            }
        }
        if (zeroCount > 1) {
            charArray[start0] = '1';
            charArray[start0 + zeroCount - 1] = '0';
        }
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        String binary = "000110";
        System.out.println(new _1702MaximumBinaryString().maximumBinaryString1(binary));
    }
}
