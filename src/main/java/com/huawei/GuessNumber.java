package com.huawei;

import java.util.*;

/**
 * @author liuyuze
 * @date 2025/3/13 14:46
 */
public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<String> matchList = new ArrayList<>();
        StringBuilder excludeNumberSb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            String s = scanner.next();
            String s1 = scanner.next();
            if (s1.charAt(0) == '0' && s1.charAt(2) == '0') {
                excludeNumberSb.append(s);
            } else {
                matchList.add(s + " " + s1);
            }
        }
        List<String> result = new ArrayList<>();
        String excludeNum = excludeNumberSb.toString();
        for (int i = 0; i < 10000; i++) {
            String guess = String.format("%04d", i);
            if (excludeNum.indexOf(guess.charAt(0)) >= 0
            || excludeNum.indexOf(guess.charAt(1)) >= 0
            || excludeNum.indexOf(guess.charAt(2)) >= 0
            || excludeNum.indexOf(guess.charAt(3)) >= 0) {
                continue;
            }
            boolean isMatch = true;
            for (String str : matchList) {
                String[] split = str.split(" ");
                String matchNum = split[0];
                String match = split[1];

                char[] matchNums = matchNum.toCharArray();
                char[] guesses = guess.toCharArray();

                int x = 0;
                int y = 0;

                int[] matchNumsSpot = new int[10];
                int[] guessesSpot = new int[10];

                for (int j = 0; j < 4; j++) {
                    //数字和位置都正确
                    if (matchNums[j] == guesses[j]) {
                        x++;
                    } else {
                        matchNumsSpot[Integer.parseInt(String.valueOf(matchNums[j]))]++;
                        guessesSpot[Integer.parseInt(String.valueOf(guesses[j]))]++;
                    }
                }
                //数字同时存在，但不在一个位置
                for (int j = 0; j < 10; j++) {
                    y += Math.min(matchNumsSpot[j],guessesSpot[j]);
                }

                String guessMatch = x + "A" + y + "B";
                if (!match.equals(guessMatch)) {
                    isMatch = false;
                }
            }
            if (isMatch) {
                result.add(guess);
            }
        }
        System.out.println(result.size() == 1 ? result.get(0) : "NA");


    }
}
