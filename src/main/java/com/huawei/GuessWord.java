package com.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liuyuze
 * @date 2025/3/13 13:37
 */
public class GuessWord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String guessStr = scanner.nextLine();
        String wordsStr = scanner.nextLine();
        String[] guesses = guessStr.split(",");
        String[] words = wordsStr.split(",");
        List<String> answerList = new ArrayList<>();
        for (String guess : guesses) {
            for (String word : words) {
                boolean match = true;
                String temp = guess;
                for (char c : word.toCharArray()) {
                    temp = temp.replace(String.valueOf(c), "");
                }
                for (char g : temp.toCharArray()) {
                    if (word.indexOf(g) < 0) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    answerList.add(word);
                    break;
                }
            }
        }
        System.out.println(answerList.isEmpty() ? "not found" : String.join(",", answerList));
    }


}
